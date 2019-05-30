package test.demos.basic.datastroage;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import test.demos.basic.R;

public class SharePreferencesActivity extends AppCompatActivity {
    private EditText mEt_input;
    private Button mBtn_save,mBtn_show;
    private TextView mTv_show;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharepreferences);

        mSharedPreferences=getSharedPreferences("data",MODE_PRIVATE);
        mEditor=mSharedPreferences.edit();
        mEt_input=findViewById(R.id.ed_input);
        mTv_show=findViewById(R.id.tv_show);
        mBtn_save=findViewById(R.id.btn_save);
        mBtn_show=findViewById(R.id.btn_show);


        mBtn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.putString("name",mEt_input.getText().toString());
                mEditor.apply();
            }
        });

        mBtn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTv_show.setText(mSharedPreferences.getString("name",""));
            }
        });

    }
}
