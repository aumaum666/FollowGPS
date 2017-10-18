package comsci.kalin.followgps;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class Member {
    private MySQLiteOpenHelper objMySQLiteOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase, readSqLiteDatabase;

    public static final String TABLE = "Member";
    public static final String U_ID = "_ID";
    public static final String U_USER = "Username";
    public static final String U_PASSWORD = "Password";
    public static final String U_FNAME = "Firstname";
    public static final String U_LNAME = "Lastname";
    public static final String U_GENDER = "Gender";
    public static final String U_IDCARD = "Idcard";
    public static final String U_IDMOTO = "Idmoto";
    public static final String U_PHONE = "Phone";
    public static final String U_GPSPHONE = "Gpsphone";

    public Member(Context context){
        objMySQLiteOpenHelper = new MySQLiteOpenHelper(context);
        writeSqLiteDatabase = objMySQLiteOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMySQLiteOpenHelper.getReadableDatabase();
    }

    public long addNewMember (String strUser, String strPassword, String strFirstname, String strLastname, String strGender, String strIdmoto, String strIdcard, String strPhone, String strGpsphone){
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(U_USER, strUser);
        objContentValues.put(U_PASSWORD, strPassword);
        objContentValues.put(U_FNAME, strFirstname);
        objContentValues.put(U_LNAME, strLastname);
        objContentValues.put(U_GENDER, strGender);
        objContentValues.put(U_IDCARD, strIdcard);
        objContentValues.put(U_IDMOTO, strIdmoto);
        objContentValues.put(U_PHONE, strPhone);
        objContentValues.put(U_GPSPHONE, strGpsphone);
        return readSqLiteDatabase.insert(TABLE, null, objContentValues);
    }

    public String[] viewinfoMember(String strView){
        try {
            String[] strviewMAll = null;
            Cursor objCursor = readSqLiteDatabase.query(TABLE, new String[]{U_ID,U_USER, U_PASSWORD, U_FNAME, U_LNAME, U_GENDER, U_IDCARD, U_IDMOTO, U_PHONE, U_GPSPHONE},U_USER+"=?",new String[]{String.valueOf(strView)},null,null,null,null);
            if (objCursor != null){
                if (objCursor.moveToFirst()){
                    strviewMAll = new String[10];
                    strviewMAll[0] = objCursor.getString(0);
                    strviewMAll[1] = objCursor.getString(1);
                    strviewMAll[2] = objCursor.getString(2);
                    strviewMAll[3] = objCursor.getString(3);
                    strviewMAll[4] = objCursor.getString(4);
                    strviewMAll[5] = objCursor.getString(5);
                    strviewMAll[6] = objCursor.getString(6);
                    strviewMAll[7] = objCursor.getString(7);
                    strviewMAll[8] = objCursor.getString(8);
                    strviewMAll[9] = objCursor.getString(9);

                }
            }
            objCursor.close();
            return strviewMAll;
        }catch (Exception e){
            return null;
        }
    }


    public String[] searchUserPassword(String strUser){
        try{
            String[] strResult = null;
            Cursor objCursor = readSqLiteDatabase.query(TABLE, new String[]{U_ID, U_USER, U_PASSWORD, U_FNAME, U_LNAME},U_USER+"=?",new String[]{String.valueOf(strUser)},null,null,null,null);
            if (objCursor != null){
                if (objCursor.moveToFirst()){
                    strResult = new String[5];
                    strResult[0] = objCursor.getString(0);
                    strResult[1] = objCursor.getString(1);
                    strResult[2] = objCursor.getString(2);
                    strResult[3] = objCursor.getString(3);
                    strResult[4] = objCursor.getString(4);

                }
            }
            objCursor.close();
            return strResult;
        }catch (Exception e){
            return null;
        }
    }
}
