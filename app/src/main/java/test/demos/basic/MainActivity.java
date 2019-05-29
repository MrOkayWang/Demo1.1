package test.demos.basic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import test.demos.basic.frag.ContainerActivity;
import test.demos.basic.frag.ContainerActivity2;
import test.demos.basic.jump.AActivity;

public class MainActivity extends AppCompatActivity  {
    private Button mBtn_TurnA;
    private Button mBtn_ToFrag,mBtn_ToFrag2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtn_TurnA=findViewById(R.id.btn_JumpA);
        mBtn_ToFrag=findViewById(R.id.btn_ToFrag);
        mBtn_ToFrag2=findViewById(R.id.btn_ToFrag2);
          onClickListener();
    }

    public void onClickListener(){
        OnClick onClick =new OnClick();
        mBtn_TurnA.setOnClickListener(onClick);
        mBtn_ToFrag.setOnClickListener(onClick);
        mBtn_ToFrag2.setOnClickListener(onClick);

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
            }
            startActivity(intent);
        }
    }

}



