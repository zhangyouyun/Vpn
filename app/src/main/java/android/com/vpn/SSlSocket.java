package android.com.vpn;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/**
 * Created by Auser on 2016/1/21.
 */
public class SSlSocket extends Activity {
    Activity act = this;
    private String TAG = this.getClass().getSimpleName();
    private String content = "";//内容
    private String text = "";
    private TextView textView;//显示文本
    private String http = ""; //存放http协议
    public static final String DOWNLOAD_PATH =
            Environment.getExternalStorageDirectory().getAbsolutePath()
                    + "/downloads/";
    private ImageView imageview;
    Bitmap bitmap;
    private String choice;


    private String ip;
    private String port;

    /**
     * 获取SSLSocket实例，该socket无验证bks
     *
     * @param ip   服务端ip
     * @param port 服务器端口
     */
    public SSLSocket getSSLSocketInstanceNoneBKS(String ip, int port) throws Exception {

        SSLContext context = SSLContext.getInstance("SSL");
        context.init(null, new TrustManager[]{new MyX509TrustManager()}, new SecureRandom());

        SocketFactory factory = context.getSocketFactory();
        return (SSLSocket) factory.createSocket(ip, port);
    }

    private static class MyX509TrustManager implements X509TrustManager {
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    class MyNetWorkTask extends AsyncTask<String, Void, String> {
        ProgressDialog pd;
        DataInputStream reader;
        DataOutputStream writer;
        FileOutputStream fileOutputStream;

        protected void onPreExecute() {
            pd = DialogUtil.showProgress(act);
            super.onPreExecute();
        }

        protected String doInBackground(String... params) {
            String result = null;
            Log.i(TAG, "doInBackground");
            try {
                //生成密钥
                SSLContext context;
                KeyStore ts = KeyStore.getInstance("BKS");
//                ts.load(getResources().openRawResource(R.raw.sslkey), "123456".toCharArray());
                TrustManagerFactory tmf = TrustManagerFactory.getInstance("X509");
                tmf.init(ts);
                TrustManager[] tm = tmf.getTrustManagers();
                context = SSLContext.getInstance("SSL");
                context.init(null, tm, null);
                SocketFactory factory = context.getSocketFactory();
                SSLSocket socket = (SSLSocket) factory.createSocket("192.168.254.92", 8889);

                if (choice.equals("message")) {
                    writer = new DataOutputStream(socket.getOutputStream());
                    http = "GET text HTTP/1.1\r\n";
                    writer.write(http.getBytes());
                    reader = new DataInputStream(socket.getInputStream());
                    result = reader.readUTF();
                    writer.flush();
                }
                http = "POST GetImage HTTP/1.1\n";
//				// 7：获取输出流
                socket.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (writer != null)
                        writer.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    if (reader != null)
                        reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return result;
        }

        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            pd.dismiss();
            text = text + '\n' + result;
            Log.i(TAG, "onPostExecute: result==" + text);
            textView.setText(result + '\n' + textView.getText());//显示发送的内容
            imageview.setImageBitmap(bitmap);
        }
    }
}


