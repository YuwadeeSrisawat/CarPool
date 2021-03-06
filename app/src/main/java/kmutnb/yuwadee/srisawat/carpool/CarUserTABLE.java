package kmutnb.yuwadee.srisawat.carpool;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Adminn on 10/8/2558.
 */
public class CarUserTABLE {

    //Explicit
    private MyOpenHelper objMyOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase, readSqLiteDatabase;

    public static final String CAR_USER_TABLE = "carUserTABLE";
    public static final String COLUMN_ID_CAR = "_id";
    public static final String COLUMN_USER_CAR = "User";
    public static final String COLUMN_PASSWORD_CAR = "Password";
    public static final String COLUMN_NAME_CAR = "Name";
    public static final String COLUMN_SURNAME_CAR = "Surname";
    public static final String COLUMN_CARID = "CarID";
    public static final String COLUMN_PICTURE = "Picture";
    public static final String COLUMN_ID_OFFICE = "id_office";

    public CarUserTABLE(Context context) {
        objMyOpenHelper = new MyOpenHelper(context);
        writeSqLiteDatabase = objMyOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMyOpenHelper.getReadableDatabase();
    }   //Constructor

    //Read All Car
    public String[] readAllCar() {
        String[] strName = null;
        Cursor objCursor = readSqLiteDatabase.query(CAR_USER_TABLE,
                new String[]{COLUMN_ID_CAR,COLUMN_NAME_CAR},
                null,null,null,null,null);
        if (objCursor != null) {
            objCursor.moveToFirst();
            strName = new String[objCursor.getCount()];
            for (int i=0; i<objCursor.getCount(); i++){
                strName[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_NAME_CAR));

            }
        }   //if
        objCursor.close();
        return strName;
    }


    //Search User
    public String[] searchUserCar(String strUser) {

        try {

            String[] strResult = null;
            Cursor objCursor = readSqLiteDatabase.query(CAR_USER_TABLE,
                    new String[]{COLUMN_ID_CAR, COLUMN_USER_CAR, COLUMN_PASSWORD_CAR, COLUMN_NAME_CAR, COLUMN_SURNAME_CAR},
                            COLUMN_USER_CAR + "=?",
                            new String[]{String.valueOf(strUser)},
                            null, null, null, null);

            if (objCursor !=null) {
                if (objCursor.moveToFirst()) {
                    strResult = new String[5];
                    strResult[0] = objCursor.getString(0);
                    strResult[1] = objCursor.getString(1);
                    strResult[2] = objCursor.getString(2);
                    strResult[3] = objCursor.getString(3);
                    strResult[4] = objCursor.getString(4);
                }   //if2
            }//if1

            objCursor.close();
            return strResult;


        } catch (Exception e) {
            return null;
        }

        //return new String[0];
        //searUserCar
    }

        //Add New User
    public long addNewUserCar(String strUser,
                              String strPassword,
                              String strName,
                              String strSurname,
                              String strCarID,
                              String strPicture,
                              String strID_office) {

        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_USER_CAR, strUser);
        objContentValues.put(COLUMN_PASSWORD_CAR, strPassword);
        objContentValues.put(COLUMN_NAME_CAR, strName);
        objContentValues.put(COLUMN_SURNAME_CAR, strSurname);
        objContentValues.put(COLUMN_CARID, strCarID);
        objContentValues.put(COLUMN_PICTURE, strPicture);
        objContentValues.put(COLUMN_ID_OFFICE,strID_office);
        return writeSqLiteDatabase.insert(CAR_USER_TABLE, null, objContentValues);
    }

}   // Main Class
