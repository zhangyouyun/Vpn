package android.com.vpn;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

/**
 * Created by Auser on 2016/1/20.
 */
public class DiyView extends LinearLayout {

    private UISwitchButton uiSwitchButton;
//    public interface OnButtonClick {
//        void onClickButton(Item item);
//    }
//    //初始化接口变量
//    OnButtonClick callBack = null;
//    // 自定义控件的自定义事件 iBack 接口类型
//    public void setOnButtonClick(OnButtonClick iBack)
//    {
//        callBack = iBack;
//    }
//    //定义一个接口
//    public interface ButtonClickListener{
//    public void buttonclicklistener(Item item);
//}
//    private ButtonClickListener buttonClickListener;
//
//    public void setButtonClickListener(ButtonClickListener button){
//        this.buttonClickListener=button;
//
//    }

//    public void setChangeListener(UISwitchButton uiSwitchButton){
//        this.uiSwitchButton=uiSwitchButton;
//    }
    private Context mContext;
    public DiyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext=context;
    }
    public View Line(){
        LinearLayout.LayoutParams lineparams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT , 1);
        ImageView line=new ImageView(mContext);
        line.setBackgroundColor(Color.GRAY);
        line.setLayoutParams(lineparams);
       return line;
    }

    public void CreateLayout(ArrayList<Item> list){
        //最外层的布局
        final LinearLayout layout = new LinearLayout(mContext);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT , LayoutParams.MATCH_PARENT);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(0, 30, 0, 30);
        layout.setLayoutParams(params);
        layout.setBackgroundColor(Color.WHITE);
        layout.setBackground(getResources().getDrawable(R.drawable.corner_top));

//        layout.addView(getButton());
//        layout.addView(Line());
        for (int i = 0; i < list.size(); i++) {
            Item item = list.get(i);
            layout.addView(getItemView(item) );
            if (i<list.size()-1)
                layout.addView(Line());
        }
        this.addView(layout);
    }

    public View getButton(){
        //是否连接Vpn
        LinearLayout buttonLayout = new LinearLayout(mContext);
        LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT , LayoutParams.WRAP_CONTENT);
        buttonLayout.setOrientation(LinearLayout.HORIZONTAL);
        buttonLayout.setLayoutParams(params3);
        buttonLayout.setPadding(70, 20, 70, 20);

        //是否连接Vpn
        TextView text2=new TextView(mContext);
        text2.setText("使用VPN: ");
        text2.setTextSize(18);
        text2.setTextColor(Color.BLACK);
        LayoutParams textParams2 = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        text2.setLayoutParams(textParams2);
        //按钮
         uiSwitchButton=new UISwitchButton(mContext);
        uiSwitchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Item item=new Item();
//                    callBack.onClickButton(item);
//                Toast.makeText(getContext(),"按钮，按钮",Toast.LENGTH_SHORT).show();
            }
        });
        buttonLayout.addView(text2);
        buttonLayout.addView(uiSwitchButton);
        return  buttonLayout;
    }

    public View getItemView(Item item){
        LinearLayout layout1 = new LinearLayout(mContext);
        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT , LayoutParams.WRAP_CONTENT);
        layout1.setOrientation(LinearLayout.HORIZONTAL);
        layout1.setLayoutParams(params1);
        layout1.setPadding(30, 20, 30, 10);

        //创建Textview
        TextView text=new TextView(mContext);
        text.setText(item.getTextName());
        text.setTextSize(18);
        text.setTextColor(Color.BLACK);
        LayoutParams textParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        text.setLayoutParams(textParams);
        //创建一个文本编辑框
        EditText edit = new EditText(mContext);
        edit.setHint(item.getEdHint());
        LayoutParams editParams = new LayoutParams(600 , LayoutParams.WRAP_CONTENT);
        edit.setLayoutParams(editParams);
        edit.setBackground(getResources().getDrawable(R.drawable.corner_gray));

        layout1.addView(text);
        layout1.addView(edit);
        return layout1;
    }
}
