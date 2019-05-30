package test.demos.basic.event;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import test.demos.basic.MainActivity;
import test.demos.basic.R;
import test.demos.basic.frag.ContainerActivity2;

public class HandlerActivity extends AppCompatActivity {
    //延迟3秒钟跳转到MainActivity
    private Handler mHandler1;
    //线程间通信
    private Handler mHandler2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        mHandler1=new Handler();
        mHandler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(HandlerActivity.this, ContainerActivity2.class);
                startActivity(intent);
            }
        },3000);//3000代表3延时3秒跳转

         mHandler2=new Handler(){
             @Override
             public void handleMessage(Message msg) {
                 super.handleMessage(msg);
                 switch (msg.what){
                     case 1:
                         Toast.makeText(HandlerActivity.this,"线程通信",Toast.LENGTH_LONG).show();
                         break;

                 }

             }
         };


        new Thread(){
            @Override
            public void run() {
                super.run();
                Message message=new Message();
                message.what=1;
                mHandler2.sendMessage(message);
            }
        }.start();
    }
}
