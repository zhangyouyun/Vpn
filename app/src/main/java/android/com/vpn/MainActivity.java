package android.com.vpn;

import android.app.Activity;
import android.app.ProgressDialog;
import android.com.vpn.CustomWidget.SendButton;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    Activity act = this;
    private UISwitchButton uiSwitchButton;
    private Item item=new Item();
    EditTextBtn editTextBtn;
    TextView textView;
    DiyView diyView;
    SendButton sendButton;
    String TAG=getClass().getSimpleName();
    ButtonLan buttonLan;
    private String ip;
    private String port;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        //得到自定义控件部分
        editTextBtn = (EditTextBtn)findViewById(R.id.btn);
        diyView=(DiyView)findViewById(R.id.diyview);
        //调用方法，呈现布局
        addTopView();
        addSendButton();
        initSwitchBtnView();
        addVpnView();
    }
    //-------------------------------------------------------
    public void addVpnView(){
                    /*Vpn部分*/
        final ArrayList<Item> list1=new ArrayList();
        Item item3=new Item();
        item3.setTextName("VPN地址：");
        item3.setEdHint("请输入VPN地址");
        item3.setItemId(3);
        list1.add(item3);

        Item item4=new Item();
        item4.setTextName("VPN端口：");
        item4.setEdHint("请输入VPN端口");
        list1.add(item4);

        Item item5=new Item();
        item5.setTextName("VPN账号：");
        item5.setEdHint("请输入VPN账号");
        list1.add(item5);

        Item item6=new Item();
        item6.setTextName("VPN密码：");
        item6.setEdHint("请输入VPN密码");
        list1.add(item6);
        diyView.CreateLayout(list1);
    }
    //------------发送电子政务部分
    public void addSendButton(){
        sendButton=(SendButton)findViewById(R.id.sendbutton);
        ArrayList<Item> list2=new ArrayList();
       item=new Item();
        item.setButtonText("应用选择：");
        item.setButtonName("电子政务");
        list2.add(item);
        sendButton.CreateLayout(item);
        sendButton.setOnButtonClick(new SendButton.OnButtonClick() {
            public void onClickButton( Item item) {

                Map<Integer,Item> map= editTextBtn.getMap();
                Item ipItem = map.get(1);
                Item portItem=map.get(2);
                Toast.makeText(MainActivity.this, portItem.getPortText(), Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onClickButton: 111111111111111111111111" + ip);
            }
        });
    }
    //-------------------------------------------------------
    public void addTopView(){
        ArrayList<Item> list=new ArrayList();
        item=new Item();
        item.setIpText("应用地址：");
        item.setItemId(1);
        item.setEdHint("请输入应用地址");
        list.add(item);

        Item item1=new Item();
        item1.setIpText("平台端口：");
        item1.setItemId(2);
        item1.setEdHint("请输入平台端口");
        list.add(item1);
        editTextBtn.CreateLayout(list);
    }
    //-------------------------------------------------------
    private void initSwitchBtnView(){
        buttonLan=(ButtonLan)findViewById(R.id.buttonlan);
        //调用方法出现控件
        buttonLan.CreateLayout(item);
        //实现自定义控件中的setonClick自定义事件
        buttonLan.setonClick(new ButtonLan.CallBack() {
            public void onClickButton(Item item) {
                Toast.makeText(getApplicationContext(), "选中按钮", Toast.LENGTH_SHORT).show();
                if(item.getIsOpened()==true){
                    diyView.setVisibility(View.GONE);
                }else if(item.getIsOpened()==false){
                    diyView.setVisibility(View.VISIBLE);
                }
            }
        });
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
            return result;
        }
    }


}
