package cn.itcast.mobliesafe.chapter02.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import cn.itcast.mobliesafe.R;

public class SetUpPasswordDialog extends Dialog implements android.view.View.OnClickListener {
    private TextView mTitleTV;
    public EditText mFirstPWDET;
    public EditText mAffirmET;
    private MyCallBack myCallBack;

    public SetUpPasswordDialog(Context context) {
        super(context,R.style.dialog_custom);
    }
    public void setCallBack(MyCallBack myCallBack){ //再调用接口
        this.myCallBack = myCallBack;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setup_password_dialog);
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        mTitleTV= (TextView) findViewById(R.id.tv_setupppwd_title);
        mFirstPWDET= (EditText) findViewById(R.id.et_affirm_password);
        mAffirmET= (EditText) findViewById(R.id.et_affirm_password);
        findViewById(R.id.btn_ok).setOnClickListener(this);
        findViewById(R.id.btn_cancle).setOnClickListener(this);
    }

    /**
     * 设置对话框标体栏
     */


    public void setTitle(String title){
        if (!TextUtils.isEmpty(title)){ //判断对话框标体栏是否为空
            mTitleTV.setText(title);
        }
    }

    @Override
    public void onClick(View view) {
        //按钮选择
        switch (view.getId()){
            case R.id.btn_ok:
                myCallBack.ok();
                break;
            case R.id.btn_cancle:
                myCallBack.cancle();
                break;
        }

    }
    public interface MyCallBack{  //先声明接口
        void ok();
        void cancle();
    }
}
