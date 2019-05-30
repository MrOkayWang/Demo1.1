package test.demos.basic.event;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import test.demos.basic.R;

public class EventActivity extends AppCompatActivity {
    private Button mBtn_jumpHandle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        //跳转到HandlerActivity
        mBtn_jumpHandle=findViewById(R.id.btn_jumpToHandler);
        mBtn_jumpHandle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EventActivity.this,HandlerActivity.class);
                startActivity(intent);
            }
        });
    }
    public void toast(View view){
        if (view.getId()==R.id.show_toast){
            Toast.makeText(EventActivity.this,"显示了Toast",Toast.LENGTH_LONG).show();
        }

    }
}
