package android.com.vpn;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class EditTextBtn extends LinearLayout {
    Map<Integer, Item> map = new HashMap<Integer, Item>();
    public String message ;

    public Map<Integer,Item> getMap() {

        return map;
    }

    public void setMap(Map<Integer, Item> map) {
        this.map = map;
    }

    public String getMessage() {
        Log.i(TAG, "getMessage: message = " + message);
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //继承LinearLayout
    String TAG = getClass().getSimpleName();
    public interface CallBack {
        void onClickButton(String s);
    }
    //初始化接口变量
    CallBack callBack = null;
   //自定义控件的自定义事件 接口类型
    public void setonClick(CallBack iBack)
    {
        callBack = iBack;
    }
    private Context mContext;
    /**
     * 两个参数的构造函数（必须使用两个参数的构造函数，因为自定义的控件需要在XML布局中使用，里面含有属性）
    context 调用自定义控件的对象
    attrs
     */
    public EditTextBtn(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;

        //将自定义的控件添加到主布局

    }
    //下划线
    public View Line(){
        LinearLayout.LayoutParams lineparams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT , 2);
        ImageView line=new ImageView(mContext);
        line.setBackgroundColor(Color.GRAY);
        line.setLayoutParams(lineparams);
        return line;
    }
    public void CreateLayout(ArrayList<Item> list){
        //创建一个LinearLayout布局
        LinearLayout layout = new LinearLayout(mContext);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT , LayoutParams.MATCH_PARENT);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(0, 30, 0, 10);
        layout.setLayoutParams(params);
        layout.setBackgroundColor(Color.WHITE);
        layout.setBackground(getResources().getDrawable(R.drawable.corner_special));

        for (int i = 0; i < list.size(); i++) {
            Item item = list.get(i);
            layout.addView(getItemView(item) );
            if (i<list.size())
                layout.addView(Line());
        }
        this.addView(layout);
    }
    //-------------------------------------------------------

    public View getItemView(final Item item){
//        final Item item2 = item;
        LinearLayout layout1 = new LinearLayout(mContext);
        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT , LayoutParams.WRAP_CONTENT);
        layout1.setOrientation(LinearLayout.HORIZONTAL);
        layout1.setLayoutParams(params1);
        layout1.setPadding(30, 20, 30, 20);

        //创建Textview
        final TextView text=new TextView(mContext);
        text.setText(item.getIpText());
        text.setTextSize(18);
        text.setTextColor(Color.BLACK);
        LayoutParams textParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        text.setLayoutParams(textParams);
        //创建一个文本编辑框
        final EditText edit = new EditText(mContext);
        edit.setHint(item.getEdHint());
        edit.setText(item.getPortText());
        LayoutParams editParams = new LayoutParams(600 , LayoutParams.WRAP_CONTENT);
        edit.setLayoutParams(editParams);
        edit.setBackground(getResources().getDrawable(R.drawable.corner_gray));
        edit.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                message=edit.getText().toString();
                item.setIpText(message);
                item.setPortText(message);

                Log.i(TAG, "onTextChanged: 编辑框"+message);
            }
            public void afterTextChanged(Editable s) {
                map.put(item.getItemId(),item);
//                Log.i(TAG, "onTextChanged: hashmap数据" + map);
            }
        });
        Log.i(TAG, "getitemview = " + layout1);
        layout1.addView(text);
        layout1.addView(edit);
        Line();
        return layout1;
    }
}

