package cn.zknu.l_service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BindServiceActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnBind,btnUnBind,btnAdd;
    private MyBindService myService;
    private Boolean isBind=false;
    private ServiceConnection serviceConnection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_service);
        btnBind=(Button)findViewById(R.id.btn_bind);
        btnUnBind=(Button)findViewById(R.id.btn_unbind);
        btnAdd=(Button)findViewById(R.id.btn_add);

        btnAdd.setOnClickListener(this);
        btnBind.setOnClickListener(this);
        btnUnBind.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_bind:
                bind();
                break;
            case R.id.btn_unbind:
                unbind();
                break;
            case R.id.btn_add:
                add();
                break;
        }
    }

    private void add() {
        if (isBind){
            int result=myService.add(1,1);
            Toast.makeText(this,""+result,Toast.LENGTH_LONG).show();
        }
    }

    private void unbind() {
        if (isBind) {
            unbindService(serviceConnection);
            isBind=false;
        }
    }

    private void bind() {
        Intent intent=new Intent(BindServiceActivity.this, MyBindService.class);
        serviceConnection= new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                myService=((MyBindService.MyBinder)service).getService();
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                myService=null;
            }
        };
        bindService(intent,serviceConnection, Context.BIND_AUTO_CREATE);
        isBind=true;
    }
}
