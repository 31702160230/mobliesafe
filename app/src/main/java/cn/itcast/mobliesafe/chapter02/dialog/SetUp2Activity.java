package cn.itcast.mobliesafe.chapter02.dialog;

import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;

import cn.itcast.mobliesafe.R;

public class SetUp2Activity extends BaseSetUpActivity implements View.OnClickListener{
    private TelephonyManager mTelephonyManager;
    private Button mBindSIMBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup2);
        mTelephonyManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        initView();

    }
    private void initView(){

    }

    @Override
    public void showNext() {

    }

    @Override
    public void showPre() {
     startActivityAndFinishSelf(SetUp1Activity.class);
    }

    @Override
    public void onClick(View view) {

    }
}
