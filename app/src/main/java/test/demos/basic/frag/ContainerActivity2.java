package test.demos.basic.frag;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import test.demos.basic.R;

public class ContainerActivity2 extends AppCompatActivity implements CFragment.IOnMessageClick {
    private CFragment cFragemnt;
    private TextView mTV_title_actvityContainer2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container2);

        //找到activity_container2中的TextView
        mTV_title_actvityContainer2=findViewById(R.id.tv_title_actcontainer2);

        //实例化CFragment
        cFragemnt=CFragment.changeText("现在是CFragment未改变前的TextView");
//        getSupportFragmentManager().beginTransaction().add(R.id.fl_fillall,cFragemnt).commitAllowingStateLoss();
        //添加一个标识
        getSupportFragmentManager().beginTransaction().add(R.id.fl_fillall,cFragemnt,"c").commitAllowingStateLoss();
    }

   //重写CFragment.IOnMessageClick接口中的onClick方法，在CFragment的Button的点击事件中将调用这个重写的方法
    @Override
    public void onClick(String text) {
        mTV_title_actvityContainer2.setText(text);
    }
}
