package test.demos.basic.frag;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import test.demos.basic.R;

public class ContainerActivity extends AppCompatActivity {
    private Button mBtnChange;
    private AFragemnt aFragemnt;
    private BFragemnt bFragemnt;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_container);

            mBtnChange=findViewById(R.id.btn_changeFragment);
            mBtnChange.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (bFragemnt==null){
                        bFragemnt=new BFragemnt();
                    }
                    bFragemnt=new BFragemnt();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fl_change,bFragemnt).commitAllowingStateLoss();
                }
            });
          //实例化 AFragment
//            aFragemnt=new AFragemnt();
            aFragemnt=AFragemnt.newInstance("我是参数");
            getSupportFragmentManager().beginTransaction().add(R.id.fl_change,aFragemnt).commitAllowingStateLoss();

        }
}
