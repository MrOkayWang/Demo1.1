package test.demos.basic.frag;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import test.demos.basic.R;

public class AFragemnt extends Fragment {
    private TextView mTv_title;
    public static AFragemnt newInstance(String title){
        AFragemnt fragemnt=new AFragemnt();
        Bundle bundle =new Bundle();
        bundle.putString("title",title);
        fragemnt.setArguments(bundle);
        return fragemnt;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_a,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTv_title=view.findViewById(R.id.tv_title);
        if (getArguments()!=null){
            mTv_title.setText(getArguments().getString("title"));
        }
    }
}
