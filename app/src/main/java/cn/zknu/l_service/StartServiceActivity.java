package cn.zknu.l_service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartServiceActivity extends AppCompatActivity  implements View.OnClickListener{

    private Button btnStart,btnStop;
    private TextView tvShowMsg;
    private  Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_service);
        btnStart=(Button)findViewById(R.id.btn_start);
        btnStop=(Button)findViewById(R.id.btn_stop);

        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_start:
                start();
                break;
            case R.id.btn_stop:
                stop();
                break;
        }
    }

    private void stop() {
        stopService(intent);
    }

    private void start() {
        intent=new Intent(StartServiceActivity.this,MyService.class);
        //intent.putExtra("service","Start Service 测试！");
        startService(intent);
    }
}
