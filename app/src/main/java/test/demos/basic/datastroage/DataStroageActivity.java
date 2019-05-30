package test.demos.basic.datastroage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import test.demos.basic.R;

public class DataStroageActivity extends AppCompatActivity {
    private Button mBtn_sharePreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_stroage);

        mBtn_sharePreferences=findViewById(R.id.btn_sharepreferences);
        getMyOnClick();
    }

    public void getMyOnClick(){
       MyOnClick myOnClick=new MyOnClick();
        mBtn_sharePreferences.setOnClickListener(myOnClick);
    }

    class MyOnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent=null;
            switch (v.getId()){
                case R.id.btn_sharepreferences:
                    intent=new Intent(DataStroageActivity.this,SharePreferencesActivity.class);
                    break;

            }
            startActivity(intent);
        }
    }
}
