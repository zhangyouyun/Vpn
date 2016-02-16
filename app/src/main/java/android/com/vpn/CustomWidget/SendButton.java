package android.com.vpn.CustomWidget;

import android.com.vpn.Item;
import android.com.vpn.R;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Auser on 2016/1/22.
 */
public class SendButton extends LinearLayout {

    public interface OnButtonClick {
        void onClickButton(Item item);
    }
    //初始化接口变量
    OnButtonClick onButtonClick = null;
    // 自定义控件的自定义事件 iBack 接口类型
    public void setOnButtonClick(OnButtonClick iBack)
    {
        onButtonClick = iBack;
    }

    //-------------------------------------------------------
    private Context mContext;
    public SendButton(Context context, AttributeSet attrs) {
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
    //-------------------------------------------------------创建布局
    public void CreateLayout(final Item item){

        LinearLayout buttonLayout = new LinearLayout(mContext);
        LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT , LayoutParams.MATCH_PARENT);
        buttonLayout.setOrientation(LinearLayout.HORIZONTAL);
        buttonLayout.setLayoutParams(params3);
        buttonLayout.setPadding(30, 10, 70, 10);
        buttonLayout.setBackgroundColor(Color.WHITE);
        buttonLayout.setBackground(getResources().getDrawable(R.drawable.corner_normal));
        //文本部分
        TextView text=new TextView(mContext);
        text.setText(item.getButtonText());
        text.setTextSize(18);
        text.setTextColor(Color.BLACK);
        LayoutParams textParams2 = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        text.setLayoutParams(textParams2);
        //发送按钮
        Button button=new Button(mContext);
        button.setText(item.getButtonName());
        LayoutParams Params = new LayoutParams(600 , LayoutParams.WRAP_CONTENT);
        button.setLayoutParams(Params);
        button.setBackground(getResources().getDrawable(R.drawable.corner_gray));
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick.onClickButton(item);
            }
        });

        buttonLayout.addView(text);
        buttonLayout.addView(button);

        this.addView(buttonLayout);
    }
}
