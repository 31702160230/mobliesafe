package cn.itcast.mobliesafe.chapter02.dialog;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.Toast;

import cn.itcast.mobliesafe.R;

public class SetUp1Activity extends BaseSetUpActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup1);
        initView();
    }
    private void initView(){
        ((RadioButton) findViewById(R.id.rb_first)).setChecked(true);
    }
    public void showNext(){
        startActivityAndFinishSelf(SetUp2Activity.class);
    }
    public void showPre(){
        Toast.makeText(this,"当前页面已经是第一页",Toast.LENGTH_SHORT).show();
    }




}
