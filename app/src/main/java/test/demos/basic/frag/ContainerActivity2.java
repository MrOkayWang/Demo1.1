package test.demos.basic.frag;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import test.demos.basic.R;

public class ContainerActivity2 extends AppCompatActivity {
    private CFragment cFragemnt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container2);

        //实例化CFragment
        cFragemnt=CFragment.changeText("现在是CFragment未改变前的TextView");
//        getSupportFragmentManager().beginTransaction().add(R.id.fl_fillall,cFragemnt).commitAllowingStateLoss();
        //添加一个标识
        getSupportFragmentManager().beginTransaction().add(R.id.fl_fillall,cFragemnt,"c").commitAllowingStateLoss();
    }




}
