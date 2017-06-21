package comsci.kalin.followgps;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Motorcycle {
    private MySQLiteOpenHelper objMySQLiteOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase, readSqLiteDatabase;

    public static final String TABLE_B = "Motorcycle";
    public static final String B_ID = "_ID";
    public static final String B_MOTOB = "Motobrand";
    public static final String B_MOTOC = "Motocolor";

    public Motorcycle(Context context){
        objMySQLiteOpenHelper = new MySQLiteOpenHelper(context);
        writeSqLiteDatabase = objMySQLiteOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMySQLiteOpenHelper.getReadableDatabase();
    }

    public long addNewMoto (String strId,String strMotocolor, String strMotobrand){
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(B_ID, strId);
        objContentValues.put(B_MOTOB, strMotobrand);
        objContentValues.put(B_MOTOC, strMotocolor);
        return readSqLiteDatabase.insert(TABLE_B, null, objContentValues);
    }

    public String[] viewinfoMoto(String strView){
        try {
            String[] strviewMoAll = null;
            Cursor objCursor = readSqLiteDatabase.query(TABLE_B, new String[]{B_ID, B_MOTOB, B_MOTOC},B_ID+"=?",new String[]{String.valueOf(strView)},null,null,null,null);
            if (objCursor != null){
                if (objCursor.moveToFirst()){
                    strviewMoAll = new String[3];
                    strviewMoAll[0] = objCursor.getString(objCursor.getColumnIndex(B_ID));
                    strviewMoAll[1] = objCursor.getString(objCursor.getColumnIndex(B_MOTOB));
                    strviewMoAll[2] = objCursor.getString(objCursor.getColumnIndex(B_MOTOC));

                }
            }
            objCursor.close();
            return strviewMoAll;
        }catch (Exception e){
            return null;
        }
    }

}
