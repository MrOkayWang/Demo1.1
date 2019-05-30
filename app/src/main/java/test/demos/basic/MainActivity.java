package test.demos.basic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import test.demos.basic.datastroage.DataStroageActivity;
import test.demos.basic.event.EventActivity;
import test.demos.basic.frag.ContainerActivity;
import test.demos.basic.frag.ContainerActivity2;
import test.demos.basic.jump.AActivity;

public class MainActivity extends AppCompatActivity  {
    private Button mBtn_TurnA;
    private Button mBtn_ToFrag,mBtn_ToFrag2;
    //跳转到事件处理的按钮
    private Button mBtn_turnToEvent;
    //跳转到数据存储界面的按钮
    private Button mBtn_stroage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtn_TurnA=findViewById(R.id.btn_JumpA);
        mBtn_ToFrag=findViewById(R.id.btn_ToFrag);
        mBtn_ToFrag2=findViewById(R.id.btn_ToFrag2);
        mBtn_turnToEvent=findViewById(R.id.btn_turnToEvent);
        mBtn_stroage=findViewById(R.id.btn_stroage);
          onClickListener();
    }

    public void onClickListener(){
        OnClick onClick =new OnClick();
        mBtn_TurnA.setOnClickListener(onClick);
        mBtn_ToFrag.setOnClickListener(onClick);
        mBtn_ToFrag2.setOnClickListener(onClick);
        mBtn_turnToEvent.setOnClickListener(onClick);
        mBtn_stroage.setOnClickListener(onClick);

    }


    class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent=null;
            switch (v.getId()){
                case R.id.btn_JumpA:
                    intent= new Intent(MainActivity.this, AActivity.class);
                    break;
                case R.id.btn_ToFrag:
                    intent=new Intent(MainActivity.this, ContainerActivity.class);
                    break;
                case R.id.btn_ToFrag2:
                    intent=new Intent(MainActivity.this, ContainerActivity2.class);
                    break;
                case R.id.btn_turnToEvent:
                    intent=new Intent(MainActivity.this, EventActivity.class);
                    break;
                case R.id.btn_stroage:
                    intent=new Intent(MainActivity.this, DataStroageActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }

}



