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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_info);
        String strView = getIntent().getStringExtra("userN2").trim();

        view(strView);
        connectedSQLite();

        TextView titleTextView = (TextView) findViewById(R.id.textView13);
        titleTextView.setText(strView +" กำลังใช้งานอยู่");

    }

    public void view(String strView){
        try{
            String[] strviewMAll = objMember.viewinfoMember(strView);
            String[] strviewMoAll = objMotorcycle.viewinfoMoto(strviewMAll[7]);

            TextView titleTextView = (TextView) findViewById(R.id.textView2);
            titleTextView.setText(strviewMAll[1]);
            TextView titleTextView1 = (TextView) findViewById(R.id.textView4);
            titleTextView1.setText(strviewMAll[2]);
            TextView titleTextView2 = (TextView) findViewById(R.id.textView5);
            titleTextView2.setText(strviewMAll[3]);
            TextView titleTextView3 = (TextView) findViewById(R.id.textView6);
            titleTextView3.setText(strviewMAll[4]);
            TextView titleTextView4 = (TextView) findViewById(R.id.textView7);
            titleTextView4.setText(strviewMAll[5]);
            TextView titleTextView5 = (TextView) findViewById(R.id.textView8);
            titleTextView5.setText(strviewMAll[6]);
            TextView titleTextView6 = (TextView) findViewById(R.id.textView9);
            titleTextView6.setText(strviewMAll[7]);
            TextView titleTextView7 = (TextView) findViewById(R.id.textView10);
            titleTextView7.setText(strviewMAll[8]);
            TextView titleTextView8 = (TextView) findViewById(R.id.textView11);
            titleTextView8.setText(strviewMoAll[1]);
            TextView titleTextView9 = (TextView) findViewById(R.id.textView12);
            titleTextView9.setText(strviewMoAll[2]);
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
        }
    }

    public void btnB(View view){
        Intent intent = new Intent(ViewInfo.this, MainActivity.class);
        startActivity(intent);
    }

    private void connectedSQLite(){
        objMember = new Member(this);
        objMotorcycle = new Motorcycle(this);
    }

}
