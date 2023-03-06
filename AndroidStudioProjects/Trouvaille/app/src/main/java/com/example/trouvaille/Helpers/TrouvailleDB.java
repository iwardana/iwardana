package com.example.trouvaille.Helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class TrouvailleDB extends SQLiteOpenHelper {

    private static int DB_VERSION = 1;
    private static String DATABASE_NAME = "TrouvailleDB";
    private static String TABLE_NAME = "favoriteTable";
    public static String KEY_ID = "id";
    public static String ITEM_TITLE = "itemTitle";
    public static String ITEM_IMAGE = "itemImage";
    public static String FAVORITE_STATUS = "fStatus";
    public static String PROVINCE_DESC = "provinceDesc";
    public static String CAPITAL = "capitalCity";
    public static String OTHER = "otherCity";

    private static String TABLE_NAME1 = "cityTable";
    public static String KEY_ID1 = "id";
    public static String ITEM_TITLE1 = "itemTitle1";
    public static String ITEM_IMAGE1 = "itemImage1";
    public static String POPULATION_TITLE = "populationTitle";
    public static String CITY_DESC = "cityDescription";
    public static String AIRPORT_TITLE = "airportTitle";
    public static String PROVINCE_NAME = "provinceName";



    private static String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + KEY_ID + " TEXT," + ITEM_TITLE+ " TEXT,"
            + ITEM_IMAGE + " TEXT," + FAVORITE_STATUS+" TEXT,"
            + PROVINCE_DESC+" TEXT," + CAPITAL+" TEXT," + OTHER+" TEXT)";

    private static String CREATE_TABLE1 = "CREATE TABLE " + TABLE_NAME1 + "("
            + KEY_ID1 + " TEXT," + ITEM_TITLE1+ " TEXT," +PROVINCE_NAME+ " TEXT,"
            + ITEM_IMAGE1 + " TEXT," + POPULATION_TITLE +" TEXT," +CITY_DESC+" TEXT,"
            + AIRPORT_TITLE +" TEXT)";

    public TrouvailleDB(Context context) {super(context,DATABASE_NAME,null,DB_VERSION);}

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL(CREATE_TABLE);
        sqLiteDatabase.execSQL(CREATE_TABLE1);
        sqLiteDatabase.execSQL("CREATE TABLE registeruser (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "username TEXT, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME1);
        onCreate(sqLiteDatabase);
    }

    //create empty table
    public void insertEmpty(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        //enter value
        for (int x = 1; x < 60; x++) {
            cv.put(KEY_ID, x);
            cv.put(FAVORITE_STATUS, "0");

            cv.put(KEY_ID1, x);

            db.insert(TABLE_NAME,null, cv);
            db.insert(TABLE_NAME1,null, cv);
        }
    }

    //insert data to database
    public void insertIntoTheDatabase(String item_title, int item_image, String id,
                                      String fav_status, String province_desc,
                                      String capital_des, String other_des) {
        SQLiteDatabase db;
        db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(ITEM_TITLE, item_title);
        cv.put(ITEM_IMAGE, item_image);
        cv.put(KEY_ID, id);
        cv.put(FAVORITE_STATUS, fav_status);
        cv.put(PROVINCE_DESC,province_desc);
        cv.put(CAPITAL,capital_des);
        cv.put(OTHER,other_des);
        db.insert(TABLE_NAME,null, cv);
        Log.d("FavDB Status", item_title + ", favstatus - "+fav_status+" - . " + cv);
    }

    public void insertIntoTheDatabase(String item_title1,String province_title, int item_image1,
                                      String id, String population_title, String city_desc,
                                      String airport_title) {
        SQLiteDatabase db;
        db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(ITEM_TITLE1, item_title1);
        cv.put(PROVINCE_NAME,province_title);
        cv.put(ITEM_IMAGE1, item_image1);
        cv.put(KEY_ID1, id);
        cv.put(POPULATION_TITLE, population_title);
        cv.put(CITY_DESC,city_desc);
        cv.put(AIRPORT_TITLE,airport_title);
        db.insert(TABLE_NAME1,null, cv);
        Log.d("TrouvailleDB Status", item_title1 + ", city - "+population_title+" - . " + cv);
    }

    //read all fav data
    public Cursor read_all_data(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "select * from " + TABLE_NAME + " where " + KEY_ID+"="+id+"";
        return db.rawQuery(sql,null,null);

    }

    // read all city data
    public Cursor read_all_city_data(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "select * from " + TABLE_NAME1 + " where " + KEY_ID1+"="+id+"";
        return db.rawQuery(sql,null,null);
    }

    //remove line from database
    public void remove_fav(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "UPDATE " + TABLE_NAME + " SET  "+ FAVORITE_STATUS+" ='0' WHERE "+KEY_ID+"="+id+"";
        db.execSQL(sql);
        Log.d("remove", id.toString());
    }

    //select all favourite list
    public Cursor select_all_favourite_list(){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM "+TABLE_NAME+" WHERE "+FAVORITE_STATUS+" ='1'";
        return db.rawQuery(sql,null,null);
    }

}
