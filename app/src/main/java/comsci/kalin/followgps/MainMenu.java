package comsci.kalin.followgps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity {

    //String name = getIntent().getStringExtra("userN");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        OnUser();
    }

    public void onClickMap (View view) {
        Intent intent = new Intent(MainMenu.this, ConnectMap.class);
        startActivity(intent);
    }

    public void onClickViewinfo (View view) {
        String name = getIntent().getStringExtra("userN");
        Intent intent = new Intent(MainMenu.this, ViewInfo.class);
        intent.putExtra("userN2", name);
        startActivity(intent);
    }

    public void OnUser(){
        String name = getIntent().getStringExtra("userN");
        TextView titleTextView = (TextView) findViewById(R.id.textView13);
        titleTextView.setText(name +" กำลังใช้งานอยู่");
    }
}
