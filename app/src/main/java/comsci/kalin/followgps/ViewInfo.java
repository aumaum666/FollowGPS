package comsci.kalin.followgps;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ViewInfo extends AppCompatActivity {

    private Member objMember;
    private Motorcycle objMotorcycle;
    String[] infoMo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_info);
        String strView = getIntent().getStringExtra("userN2").trim();

        connectedSQLite();
        view(strView);


        TextView titleTextView = (TextView) findViewById(R.id.textView13);
        titleTextView.setText(strView +" กำลังใช้งานอยู่");

    }

    public void view(String strView){
        String[] strviewMAll = objMember.viewinfoMember(strView);
        String[] strviewMoAll = objMotorcycle.viewinfoMoto(strviewMAll[7]);


        TextView titleTextView = (TextView) findViewById(R.id.textView2);
        titleTextView.setText("Username     : "+strviewMAll[1]);
        TextView titleTextView1 = (TextView) findViewById(R.id.textView4);
        titleTextView1.setText("Password    : "+strviewMAll[2]);
        TextView titleTextView2 = (TextView) findViewById(R.id.textView5);
        titleTextView2.setText("ชื่อจริง         : "+strviewMAll[3]);
        TextView titleTextView3 = (TextView) findViewById(R.id.textView6);
        titleTextView3.setText("นามสกุล        : "+strviewMAll[4]);
        TextView titleTextView4 = (TextView) findViewById(R.id.textView7);
        titleTextView4.setText("เพศ          : "+strviewMAll[5]);
        TextView titleTextView5 = (TextView) findViewById(R.id.textView8);
        titleTextView5.setText("รหัสบัตรประชาชน   : "+strviewMAll[6]);
        TextView titleTextView6 = (TextView) findViewById(R.id.textView9);
        titleTextView6.setText("ทะเบียนรถจักรยานยนต์ : "+strviewMAll[7]);
        TextView titleTextView7 = (TextView) findViewById(R.id.textView10);
        titleTextView7.setText("เบอร์โทรศัพท์      : "+strviewMAll[8]);
        TextView titleTextView8 = (TextView) findViewById(R.id.textView11);
        titleTextView8.setText("เบอร์ GPS    : "+strviewMAll[9]);
        TextView titleTextView9 = (TextView) findViewById(R.id.textView12);
        titleTextView9.setText("ยี่ห้อรถจักยานยนต์     : "+strviewMoAll[1]);
        TextView titleTextView10 = (TextView) findViewById(R.id.textView14);
        titleTextView10.setText("สีรถจักรยานยนต์     : "+strviewMoAll[2]);

    }


    public void btnB(View view){
        String name = getIntent().getStringExtra("userN2");
        Intent intent = new Intent(ViewInfo.this, MainMenu.class);
        intent.putExtra("userN", name);
        startActivity(intent);
    }

    public void onClickEdit (View view) {
        String name = getIntent().getStringExtra("userN");
        Intent intent = new Intent(ViewInfo.this, EditInfo.class);
        intent.putExtra("userN2", name);
        startActivity(intent);
    }

    private void connectedSQLite(){
        objMember = new Member(this);
        objMotorcycle = new Motorcycle(this);
    }

}
