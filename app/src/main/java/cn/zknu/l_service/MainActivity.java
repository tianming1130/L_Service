package cn.zknu.l_service;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnStartService,btnBindService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStartService=(Button)findViewById(R.id.start_service);
        btnBindService=(Button)findViewById(R.id.bind_service);

        btnStartService.setOnClickListener(this);
        btnBindService.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start_service:
                startActivity(new Intent(MainActivity.this,StartServiceActivity.class));
                break;
            case R.id.bind_service:
                startActivity(new Intent(MainActivity.this,BindServiceActivity.class));
                break;
        }
    }

}
