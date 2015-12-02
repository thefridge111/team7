package com.nuteam7.www.vicidapp;

/**
 * Created by Jesse on 11/19/2015.
 */
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "CarsDB.db";
    public static final String TABLE_MODELS = "models";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_MODELNAME = "modelname";
    public static final String COLUMN_GENERATION = "gen";
    public static final String COLUMN_YEARS = "year";
    public static final String COLUMN_WikiLink = "Wiki";
    public static final String COLUMN_BRAND = "brand";
    public static final String COLUMN_TYPE = "type";


    //We need to pass database information along to superclass
    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_MODELS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_MODELNAME + " TEXT " +
                COLUMN_GENERATION + " INTEGER " +
                COLUMN_YEARS + " TEXT " +
                COLUMN_WikiLink + " TEXT " +
                COLUMN_BRAND + " INTEGER " +
                COLUMN_TYPE + "INTEGER "+
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MODELS);
        onCreate(db);
    }

    //Add a new row to the database
    public void addModel(Model model){
        ContentValues values = new ContentValues();
        values.put(COLUMN_MODELNAME, model.get_modelname());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_MODELS, null, values);
        db.close();
    }

    //Delete a product from the database
    public void deleteModel(String modelName){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_MODELS + " WHERE " + COLUMN_MODELNAME + "=\"" + modelName + "\";");
    }

    public String databaseToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_MODELS + " WHERE 1";

        //Cursor points to a location in your results
        Cursor c = db.rawQuery(query, null);
        //Move to the first row in your results
        c.moveToFirst();

        //Position after the last row means the end of the results
        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("modelname")) != null) {
                dbString += c.getString(c.getColumnIndex("modelname"));
                dbString += "\n";
            }
            c.moveToNext();
        }
        db.close();
        return dbString;
    }

}
