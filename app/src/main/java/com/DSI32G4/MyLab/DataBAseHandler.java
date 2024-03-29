package com.DSI32G4.MyLab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;


//Classe pour manipuler la base de données
public class DataBAseHandler extends SQLiteOpenHelper {

    public DataBAseHandler(Context context, Object name,Object factory, int version) {
        // TODO Auto-generated constructor stub
        super(context,  DATABASE_NAME, null, DATABASE_VERSION);
    }


    String password;
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "Mydatabase.db";

    // Contacts table name
    private static final String TABLE_REGISTER= "register";
    public static final String KEY_ID = "id";
    public static final String KEY_FIRST_NAME = " first_name";
    public static final String KEY_lAST_NAME = "last_name";
    public static final String KEY_EMAIL_ID="email_id";
    public static final String KEY_MOB_NO = "mobile_number";
    public static final String KEY_PASSWORD = "password";
    public static final String CREATE_TABLE="CREATE TABLE " + TABLE_REGISTER + "("
            + KEY_ID + " INTEGER PRIMARY KEY," + KEY_FIRST_NAME + " TEXT,"+KEY_lAST_NAME + " TEXT,"+KEY_EMAIL_ID+ " TEXT,"
            + KEY_MOB_NO + " TEXT," + KEY_PASSWORD + " TEXT " + ")";

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(CREATE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REGISTER);

        // Create tables again
        onCreate(db);

    }

    public boolean updateData(String email,String name,String surname,String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_FIRST_NAME,name);
        contentValues.put(KEY_lAST_NAME,surname);
        contentValues.put(KEY_MOB_NO,date);
        db.update(TABLE_REGISTER, contentValues, "email_id=?",new String[] { email });
        return true;
    }

    void addregister(RegisterData registerdata)
    // code to add the new register
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_FIRST_NAME,registerdata.getfirstName()); // register first Name
        values.put(KEY_lAST_NAME, registerdata. getlastName() ); // register last name
        values.put(KEY_EMAIL_ID, registerdata.getEmailId());//register email id
        values.put(KEY_MOB_NO, registerdata.getMobNo());//register mobile no
        values.put(KEY_PASSWORD, registerdata.getPassword());
        // Inserting Row

        db.insert(TABLE_REGISTER, null, values);
        db.close(); // Closing database connection

    }

    //code to get the register
    public String getregister(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        //String selectquery="SELECT * FROM TABLE_REGISTER";
        Cursor cursor=db.query(TABLE_REGISTER,null,  "email_id=?",new String[]{username},null, null, null, null);
        if(cursor.getCount()<1){
            cursor.close();
            return "Not Exist";
        }
        else if(cursor.getCount()>=1 && cursor.moveToFirst()){

            password = cursor.getString(cursor.getColumnIndex(KEY_PASSWORD));
            cursor.close();

        }
        return password;


    }
    public String getnom(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        //String selectquery="SELECT * FROM TABLE_REGISTER";
        Cursor cursor=db.query(TABLE_REGISTER,null,  "email_id=?",new String[]{username},null, null, null, null);
        if(cursor.getCount()<1){
            cursor.close();
            return "Not Exist";
        }
        else if(cursor.getCount()>=1 && cursor.moveToFirst()){

            password = cursor.getString(cursor.getColumnIndex(KEY_FIRST_NAME));
            cursor.close();

        }
        return password;

    }
    public String getprenom(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        //String selectquery="SELECT * FROM TABLE_REGISTER";
        Cursor cursor=db.query(TABLE_REGISTER,null,  "email_id=?",new String[]{username},null, null, null, null);
        if(cursor.getCount()<1){
            cursor.close();
            return "Not Exist";
        }
        else if(cursor.getCount()>=1 && cursor.moveToFirst()){
            password = cursor.getString(cursor.getColumnIndex(KEY_lAST_NAME));
            cursor.close();

        }
        return password;
    }

    public String getDateNaissance(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        //String selectquery="SELECT * FROM TABLE_REGISTER";
        Cursor cursor=db.query(TABLE_REGISTER,null,  "email_id=?",new String[]{username},null, null, null, null);
        if(cursor.getCount()<1){
            cursor.close();
            return "Not Exist";
        }
        else if(cursor.getCount()>=1 && cursor.moveToFirst()){

            password = cursor.getString(cursor.getColumnIndex(KEY_lAST_NAME));
            cursor.close();

        }
        return password;


    }  public String gettel(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        //String selectquery="SELECT * FROM TABLE_REGISTER";
        Cursor cursor=db.query(TABLE_REGISTER,null,  "email_id=?",new String[]{username},null, null, null, null);
        if(cursor.getCount()<1){
            cursor.close();
            return "Not Exist";
        }
        else if(cursor.getCount()>=1 && cursor.moveToFirst()){
            password = cursor.getString(cursor.getColumnIndex(KEY_MOB_NO));
            cursor.close();

        }
        return password;


    }

    //code to get info
    String getinfo(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        //String selectquery="SELECT * FROM TABLE_REGISTER";
        Cursor cursor=db.query(TABLE_REGISTER,null,  "email_id=?",new String[]{username},null, null, null, null);
        if(cursor.getCount()<1){
            cursor.close();
            return "Not Exist";
        }
        else if(cursor.getCount()>=1 && cursor.moveToFirst()){

            password = cursor.getString(cursor.getColumnIndex(KEY_PASSWORD));
            cursor.close();

        }
        return password;


    }

    public String getDatabaseName() {
        return DATABASE_NAME;
    }

    public static String getKeyId() {
        return KEY_ID;
    }

    public static String getTableContacts() {
        return TABLE_REGISTER;
    }

    public static int getDatabaseVersion() {
        return DATABASE_VERSION;
    }


    public boolean Check(String fieldValue){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_REGISTER + " WHERE KEY_EMAIL_ID = " + fieldValue;
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        if (cursor.getCount()<=0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }





}