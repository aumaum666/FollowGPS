package comsci.kalin.followgps;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity {
    private Status objStatus;
    private Member objMember;

    //String name = getIntent().getStringExtra("userN");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        connectedSQLite();
        OnUser();
    }

    public void onClickMap (View view) {
        String name = getIntent().getStringExtra("userN");
        String[] strviewMAll = objMember.viewinfoMember(name);
        String[] strStatus = objStatus.viewStatus(strviewMAll[7]);
        Uri location = Uri.parse("http://maps.google.com/maps?q=loc:"+strStatus[2]+","+strStatus[3]+"");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
        startActivity(mapIntent);
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

    private void connectedSQLite(){
        objStatus = new Status(this);
        objMember = new Member(this);
    }
}
