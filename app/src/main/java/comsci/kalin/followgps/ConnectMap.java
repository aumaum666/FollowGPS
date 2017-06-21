package comsci.kalin.followgps;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ConnectMap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_map);
    }

    public void runCallMap(View view){

        //Initial View
        EditText latitude = (EditText) findViewById(R.id.mapLat);
        EditText longtitude = (EditText) findViewById(R.id.mapLong);

        String lat = latitude.getText().toString().trim();
        String lng = longtitude.getText().toString().trim();

        Uri location = Uri.parse("http://maps.google.com/maps?q=loc:"+lat+","+lng+"");

        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
        //mapIntent.setPackage("com.google.android.apps.maps");  // ใช้ไม่ได้กับ GenyMotion
        startActivity(mapIntent);

    }  //runCallMap

}
