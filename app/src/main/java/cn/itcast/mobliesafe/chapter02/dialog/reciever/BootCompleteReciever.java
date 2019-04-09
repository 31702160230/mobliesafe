package cn.itcast.mobliesafe.chapter02.dialog.reciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import cn.itcast.mobliesafe.App;

/**
 * Created by Administrator on 2019/4/9.
 */

public class BootCompleteReciever extends BroadcastReceiver {
    private static final  String TAG = BootCompleteReciever.class.getSimpleName();
    @Override
    public void onReceive(Context context, Intent intent) {
        ((App)context.getApplicationContext()).correctSIM();//初始化

    }
}
