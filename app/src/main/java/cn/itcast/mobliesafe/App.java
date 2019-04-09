package cn.itcast.mobliesafe;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;

/**
 * Created by Administrator on 2019/4/9.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        correctSIM();//检测SIM是否发生变化
    }

    public void correctSIM() {
        SharedPreferences sp =getSharedPreferences("config", Context.MODE_PRIVATE);
        boolean protecting = sp.getBoolean("protecting",true);
        if (protecting){
            String bindSIM=sp.getString("sim","");
            TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
             String realSIM = tm.getSimSerialNumber();
            if (bindSIM.equals(realSIM)){
                Log.i("","SIM卡未发生变化，还是您的手机");
            }else {
                Log.i("","SIM卡变化了");
                String safenumber=sp.getString("safephone","");
                if (!TextUtils.isEmpty(safenumber)){
                    SmsManager smsManager=SmsManager.getDefault();
                    smsManager.sendTextMessage(safenumber,null,"你的亲友手机的SIM卡已经被更改",null,null);
                }
            }
        }
    }

}
