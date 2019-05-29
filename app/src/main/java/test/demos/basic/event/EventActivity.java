package test.demos.basic.event;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import test.demos.basic.R;

public class EventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
    }
    public void toast(View view){
        if (view.getId()==R.id.show_toast){
            Toast.makeText(EventActivity.this,"显示了Toast",Toast.LENGTH_LONG).show();
        }

    }
}
