package cn.zknu.l_service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyBindService extends Service {

    private static final String TAG ="MyBindService" ;

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG,"MyBindService---->onBind");
        return new MyBinder();
    }

    @Override
    public void onCreate() {
        Log.i(TAG,"MyBindService---->onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG,"MyBindService---->onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i(TAG,"MyBindService---->onDestroy");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG,"MyBindService---->onUnbind");
        return super.onUnbind(intent);
    }

    public int add(int a, int b){
        return a+b;
    }
    public class MyBinder extends Binder{
        MyBindService getService(){
            return MyBindService.this;
        }
    }
}
