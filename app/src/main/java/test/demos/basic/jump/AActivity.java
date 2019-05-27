package test.demos.basic.jump;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import test.demos.basic.R;

public class AActivity extends AppCompatActivity {
     private Button mBtn_TurnB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        mBtn_TurnB=findViewById(R.id.btn_JumpB);
        mBtn_TurnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //发送数据
                Intent intent=new Intent(AActivity.this,BActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("name","wanghaoyu");
                bundle.putInt("Num",999);
                intent.putExtras(bundle);
                startActivityForResult(intent,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String back1=data.getExtras().getString("back1");
        String back2=data.getExtras().getString("back2");
        Toast.makeText(AActivity.this,back1+back2,Toast.LENGTH_LONG).show();
    }
}
