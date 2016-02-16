package android.com.vpn;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Auser on 2016/1/21.
 */
public class ButtonLan extends LinearLayout {
    private UISwitchButton uiSwitchButton;


    //--------------------------------------------
    public interface CallBack {
        void onClickButton(Item item);
    }
    //初始化接口变量
    CallBack callBack = null;
    // 自定义控件的自定义事件 iBack 接口类型
    public void setonClick(CallBack iBack)
    {
        callBack = iBack;
    }

    //-------------------------------------------------------
    private Context mContext;
    public ButtonLan(Context context, AttributeSet attrs) {
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


    public void CreateLayout(Item item){

        LinearLayout buttonLayout = new LinearLayout(mContext);
        LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT , LayoutParams.WRAP_CONTENT);
        buttonLayout.setOrientation(LinearLayout.HORIZONTAL);
        buttonLayout.setLayoutParams(params3);
        buttonLayout.setPadding(30, 0, 70, 0);
        buttonLayout.setBackgroundColor(Color.WHITE);
        buttonLayout.setBackground(getResources().getDrawable(R.drawable.corner_special));

        //是否连接Vpn
        TextView text2=new TextView(mContext);
        text2.setText("使用VPN: ");
        text2.setTextSize(18);
        text2.setTextColor(Color.BLACK);
        LayoutParams textParams2 = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        text2.setLayoutParams(textParams2);

        //按钮
        uiSwitchButton = new UISwitchButton(mContext);
        uiSwitchButton.setChecked(item.getIsOpened());
        uiSwitchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Item item = new Item();
                item.setIsOpened(isChecked);
                callBack.onClickButton(item);
            }
        });
        buttonLayout.addView(text2);
        buttonLayout.addView(uiSwitchButton);
//        buttonLayout.addView(Line());

        this.addView(buttonLayout);
    }
}
