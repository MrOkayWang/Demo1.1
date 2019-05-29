package test.demos.basic.frag;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import test.demos.basic.R;

public class CFragment extends Fragment {
    private Button mBtn_changeToDFrag,mBtn_changeText,mBtn_changeActivtyTv;
    private TextView mTv_wenzi,mTV_inToolBar;
    private DFragment dFragment;
    private Toolbar mTb_toolbar;
    //想调用ContainerActivity2中重写的onClick方法，要在onAattach方法中将context赋值给listener
    private IOnMessageClick listener;

    //更改TextView文字的方法：
   public static CFragment changeText(String string){
      CFragment cFragment=new CFragment();
      Bundle bundle=new Bundle();
      bundle.putString("String",string);
      cFragment.setArguments(bundle);
      return cFragment;
   }
   //定义一个接口，用于实现对Activity的信息传递
    //要让Activity实现这个接口并且重写onClick方法
   public interface IOnMessageClick{
       void onClick(String text);
   }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_c,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //添加标题
        mTb_toolbar=view.findViewById(R.id.tb_toobar);
        mTb_toolbar.setTitle("");
        mTV_inToolBar=view.findViewById(R.id.tv_inToolbar);
        mTV_inToolBar.setText("CFragment");

        //改变CotainerActivity2的Textview的文字
        mBtn_changeActivtyTv=view.findViewById(R.id.btn_changeActivityTv);
        //为这个Button添加点击事件调用listener.onClick(String text)方法
        mBtn_changeActivtyTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick("点击了“改变上面TextView的文字”按钮改变的文字");
            }
        });


        mTv_wenzi=view.findViewById(R.id.tv_wenzi);
        if (getArguments()!=null){
            mTv_wenzi.setText(getArguments().getString("String"));
        }
       //将CFragment切换到DFragment
        mBtn_changeToDFrag=view.findViewById(R.id.btn_changeToDfrag);
        mBtn_changeToDFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dFragment==null){
                    dFragment=new DFragment();
                }
                Fragment fragment=getFragmentManager().findFragmentByTag("c");
                if (fragment!=null){
                    //为了返回CFragment时保留离开时的状态 ，先hide再add
                    getFragmentManager().beginTransaction().hide(fragment).add(R.id.fl_fillall,dFragment).addToBackStack(null).commitAllowingStateLoss();
                }else {
                    //replace=remove + add
                    getFragmentManager().beginTransaction().replace(R.id.fl_fillall,dFragment).addToBackStack(null).commitAllowingStateLoss();
                }

            }
        });
        //切换TextView的文字
        mBtn_changeText=view.findViewById(R.id.btn_changeTextView);
        mBtn_changeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTv_wenzi.setText("这是CFragement点击按钮改变之后的文字！！");
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener= (IOnMessageClick) context;
        }catch (ClassCastException e){
            throw new ClassCastException("必须在ContainerActivity2中实现IOnMessageClick这个接口");
        }
    }
}
