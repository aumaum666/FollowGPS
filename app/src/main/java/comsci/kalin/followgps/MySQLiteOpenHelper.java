package comsci.kalin.followgps;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    private final String TAG = getClass().getSimpleName();
    private SQLiteDatabase sqLiteDatabase;


    public static final String DataBase_Name = "FollowGPS.db";
    public static final int DataBase_Version = 1;

    public static final String TABLE = "Member";
    public static final String U_ID = BaseColumns._ID;
    public static final String U_USER = "Username";
    public static final String U_PASSWORD = "Password";
    public static final String U_FNAME = "Firstname";
    public static final String U_LNAME = "Lastname";
    public static final String U_GENDER = "Gender";
    public static final String U_IDCARD = "Idcard";
    public static final String U_IDMOTO = "Idmoto";
    public static final String U_PHONE = "Phone";
    public String CREATE_MEMBER ="create table "+TABLE+" ("+U_ID+" integer primary key autoincrement, "+U_USER+" text, "+U_PASSWORD+" text, "+U_FNAME+" text, "+U_LNAME+" text, "+U_GENDER+" text, "+U_IDCARD+" text, "+U_IDMOTO+" text, "+U_PHONE+" text);";

    public static final String TABLE_B = "Motorcycle";
    public static final String B_ID = "_ID";
    public static final String B_MOTOB = "Motobrand";
    public static final String B_MOTOC = "Motocolor";
    public String CREATE_MOTORCYCLE = "create table "+TABLE_B+" ("+B_ID+" integer primary key autoincrement, "+B_MOTOB+" text, "+B_MOTOC+" text);";

    public static final String TABLE_C = "Status";
    public static final String C_ID = "_ID";
    public static final String C_MOTOV = "Motovibrate";
    public static final String C_LONGF = "Longfirst";
    public static final String C_LATF = "Latfirst";
    public static final String C_LONGP = "Longpresent";
    public static final String C_LATP = "Latpresent";
    public String CREATE_STATUS = "create table "+TABLE_C+" ("+C_ID+" integer primary key autoincrement, "+C_MOTOV+" text, "+C_LONGF+" text, "+C_LATF+" text, "+C_LONGP+" text, "+C_LATP+" text);";

    public MySQLiteOpenHelper(Context context) {
        super(context, DataBase_Name, null, DataBase_Version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, CREATE_MEMBER);
        Log.i(TAG, CREATE_MOTORCYCLE);
        Log.i(TAG, CREATE_STATUS);
        db.execSQL(CREATE_MEMBER);
        db.execSQL(CREATE_MOTORCYCLE);
        db.execSQL(CREATE_STATUS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // copy เค้ามา อย่าสงสับ
        String DROP_FRIEND_TABLE = "DROP TABLE IF EXISTS " + TABLE;

        db.execSQL(DROP_FRIEND_TABLE);

        Log.i(TAG, "Upgrade Database from " + oldVersion + " to " + newVersion);

        onCreate(db);
    }
    //ยังติดปัญหาเรื่อง method
    public List<String> getFriendList() {
        List<String> ALLUSER = new ArrayList<String>();

        sqLiteDatabase = this.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.query
                (TABLE, null, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        while(!cursor.isAfterLast()) {

            ALLUSER.add(cursor.getLong(0) + " " +
                    cursor.getString(1) + " " +
                    cursor.getString(2));

            cursor.moveToNext();
        }

        sqLiteDatabase.close();

        return ALLUSER;
    }
    //
}
