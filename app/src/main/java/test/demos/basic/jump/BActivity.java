package test.demos.basic.jump;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import test.demos.basic.R;

public class BActivity extends AppCompatActivity {
    private TextView mTvShowFromA;
    private Button mBtn_BackToA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        mTvShowFromA=findViewById(R.id.tv_showFromA);
        mBtn_BackToA=findViewById(R.id.btn_backtoA);
        final Bundle bundle=getIntent().getExtras();
        String name=bundle.getString("name");
        int num=bundle.getInt("Num");

        mTvShowFromA.setText(name+":"+num);

        mBtn_BackToA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                Bundle bundle1=new Bundle();
                bundle.putString("back1","回来了1");
                bundle.putString("back2","回来了2");
                intent.putExtras(bundle);
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
    }
}
