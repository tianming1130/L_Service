package cn.zknu.l_service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import cn.zknu.l_service.R;

/**
 * Created by sun on 2018/1/13.
 */

public class MyService extends Service {
    private static final String TAG="MyService";
    private MediaPlayer mediaPlayer;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG,"MyService---->onBind");
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG,"MyService---->onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        Log.i(TAG,"MyService---->onCreate");
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true){
//                    SystemClock.sleep(1000);
//                    Log.i(TAG,"a");
//                }
//            }
//        }).start();

        mediaPlayer=MediaPlayer.create(this, R.raw.zuizaicaoyuan);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }

    @Override
    public void onDestroy() {
        Log.i(TAG,"MyService---->onDestroy");
        mediaPlayer.stop();
    }
}
