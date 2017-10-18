package comsci.kalin.followgps;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Status {
    private MySQLiteOpenHelper objMySQLiteOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase, readSqLiteDatabase;

    public static final String TABLE_C = "Motorcycle";
    public static final String C_ID = "_ID";
    public static final String C_MOTOV = "Motovibrete";
    public static final String C_LONGF = "Longfirst";
    public static final String C_LATF = "Latfirst";
    public static final String C_LONGP = "Longpresent";
    public static final String C_LATP = "Latpresent";

    public Status(Context context){
        objMySQLiteOpenHelper = new MySQLiteOpenHelper(context);
        writeSqLiteDatabase = objMySQLiteOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMySQLiteOpenHelper.getReadableDatabase();
    }

    public long addNewStatus (String strId,String strMotovibrate, String strLongfirst, String strLatfirst, String strLongpresent, String strLatpresent){
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(C_ID, strId);
        objContentValues.put(C_MOTOV, strMotovibrate);
        objContentValues.put(C_LONGF, strLongfirst);
        objContentValues.put(C_LATF, strLatfirst);
        objContentValues.put(C_LONGP, strLongpresent);
        objContentValues.put(C_LATP, strLatpresent);
        return readSqLiteDatabase.insert(TABLE_C, null, objContentValues);
    }

    public String[] viewStatus(String strView){
        try {
            String[] strStatus = null;
            Cursor objCursor = readSqLiteDatabase.query(TABLE_C, new String[]{C_ID,C_MOTOV, C_LONGF, C_LATF, C_LONGP, C_LATP},C_ID+"=?",new String[]{String.valueOf(strView)},null,null,null,null);
            if (objCursor != null){
                if (objCursor.moveToFirst()){
                    strStatus = new String[6];
                    strStatus[0] = objCursor.getString(0);
                    strStatus[1] = objCursor.getString(1);
                    strStatus[2] = objCursor.getString(2);
                    strStatus[3] = objCursor.getString(3);
                    strStatus[4] = objCursor.getString(4);
                    strStatus[5] = objCursor.getString(5);


                }
            }
            objCursor.close();
            return strStatus;
        }catch (Exception e){
            return null;
        }
    }
}
