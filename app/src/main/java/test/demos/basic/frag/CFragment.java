package test.demos.basic.frag;

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
    private Button mBtn_changeToDFrag,mBtn_changeText;
    private TextView mTv_wenzi,mTV_inToolBar;
    private DFragment dFragment;
    private Toolbar mTb_toolbar;

    //更改TextView文字的方法：
   public static CFragment changeText(String string){
      CFragment cFragment=new CFragment();
      Bundle bundle=new Bundle();
      bundle.putString("String",string);
      cFragment.setArguments(bundle);
      return cFragment;
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
                mTv_wenzi.setText("这是CFragement改变之后的文字！！");
            }
        });
    }
}
