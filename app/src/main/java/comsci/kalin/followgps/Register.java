package comsci.kalin.followgps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText editText;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    EditText editText5;
    EditText editText6;
    EditText editText7;
    EditText editText8;
    EditText editText9;
    String a,b,c,d,e,f,g,h,i;
    private Member objMember;
    private Motorcycle objMotorcycle;
    private Status objStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        connectedSQLite();
    }

    public void btnRE(View view){
        editText = (EditText) findViewById(R.id.editText3);
        editText2 = (EditText) findViewById(R.id.editText4);
        editText3 = (EditText) findViewById(R.id.editText5);
        editText4 = (EditText) findViewById(R.id.editText6);
        editText5 = (EditText) findViewById(R.id.editText7);
        editText6 = (EditText) findViewById(R.id.editText8);
        editText7 = (EditText) findViewById(R.id.editText9);
        editText8 = (EditText) findViewById(R.id.editText10);
        editText9 = (EditText) findViewById(R.id.editText11);
        a = editText.getText().toString();
        b = editText2.getText().toString();
        c = editText3.getText().toString();
        d = editText4.getText().toString();
        e = editText5.getText().toString();
        f = editText6.getText().toString();
        g = editText7.getText().toString();
        h = editText8.getText().toString();
        i = editText9.getText().toString();


        objMember.addNewMember(a,b,c,d,e,g,f,h,i);
        objMotorcycle.addNewMoto(g,"-","-");
        objStatus.addNewStatus(g,"-","13.765072","100.538479","-","-");

        Toast.makeText(getApplicationContext(), "Register Complete", Toast.LENGTH_LONG).show();


        Intent intent = new Intent(Register.this, MainActivity.class);
        startActivity(intent);


    }

    private void connectedSQLite(){
        objMember = new Member(this);
        objMotorcycle = new Motorcycle(this);
        objStatus = new Status(this);
    }

}