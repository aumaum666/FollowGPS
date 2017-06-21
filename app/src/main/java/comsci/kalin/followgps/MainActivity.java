package comsci.kalin.followgps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Member objMember;
    private Motorcycle objMotorcycle;
    private Status objStatus;

    String strUser,strPassword ;

    EditText userEditText,passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connectedSQLite();
        initialWidget();
    }

    private void connectedSQLite(){
        objMember = new Member(this);
        objMotorcycle = new Motorcycle(this);
        objStatus = new Status(this);
    }

    private void initialWidget(){
        userEditText = (EditText) findViewById(R.id.editText);
        passwordEditText = (EditText) findViewById(R.id.editText2);
    }

    public void btnLogin(View view) {
        strUser = userEditText.getText().toString().trim();
        strPassword = passwordEditText.getText().toString().trim();

        if (strUser.equals("") || strPassword.equals("")){

            Toast.makeText(getApplicationContext(), "กรุณากรอกให้ครบทุกช่อง", Toast.LENGTH_SHORT).show();

        } else  {
            checkUserPassword(strUser,strPassword);
        }
    }

    private void checkUserPassword(String strUser, String strPassword){
        try {

            String[] strMyResult = objMember.searchUserPassword(strUser);
            if (strPassword.equals(strMyResult[2])){
                Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_LONG).show();
                Intent startIntent = new Intent(MainActivity.this, MainMenu.class);
                startIntent.putExtra("userN",strUser);
                startActivity(startIntent);


            }else {
                Toast.makeText(getApplicationContext(), "Wrong Password", Toast.LENGTH_LONG).show();
            }

        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Wrong Username", Toast.LENGTH_LONG).show();
        }
    }

    public void onClickRegister (View view) {
        Intent intent = new Intent(MainActivity.this, Register.class);
        startActivity(intent);
    }

}
