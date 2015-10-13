package kmutnb.yuwadee.srisawat.carpool;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Adminn on 18/9/2558.
 */
public class MapsTABLE {

    //Explicit
    private MyOpenHelper objMyOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase, readSqLiteDatabase;

    public static final String MAPS_TABLE = "mapsTABLE";
    public static final String COLUMN_ID_MAPS = "_id";
    public static final String COLUMN_NAME_MAPS = "Name";
    public static final String COLUMN_SERNAME_MAPS = "Surname";
    public static final String COLUMN_ICON  = "Icon";
    public static final String COLUMN_Lat = "Lat";
    public static final String COLUMN_LNG = "Lng";
    public static final String COLUMN_DATE = "Date";

    public MapsTABLE(Context context) {
        objMyOpenHelper = new MyOpenHelper(context);
        writeSqLiteDatabase = objMyOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMyOpenHelper.getReadableDatabase();
    }   //Constructor

    //Query Special Name
    public String[] lastPositionCar(String strName) {
        String[] strResult = null;
        //Cursor objCursor = readSqLiteDatabase.rawQuery();

        return new String[0];
    }

    public Long addValeToMap(String strName, String strSername, String strIcon, String strLat, String strLng, String strDate) {
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_NAME_MAPS, strName);
        objContentValues.put(COLUMN_SERNAME_MAPS, strSername);
        objContentValues.put(COLUMN_ICON, strIcon);
        objContentValues.put(COLUMN_Lat, strLat);
        objContentValues.put(COLUMN_LNG, strLng);
        objContentValues.put(COLUMN_DATE, strDate);

        return writeSqLiteDatabase.insert(MAPS_TABLE,null,objContentValues);
    }
}   //Main class
