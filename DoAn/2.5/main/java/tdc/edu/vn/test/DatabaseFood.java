package tdc.edu.vn.test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.Telephony;
import android.widget.Button;

import java.util.ArrayList;

import tdc.edu.vn.test.Food;

public class DatabaseFood extends SQLiteOpenHelper {
    private static String DB_NAME = "dbMonHoc.db";
    private static int DB_VERSION = 2;

    private static final String TB_FOOD = "tbFOOD";
    private static final String FOOD_ID = "food_id";
    private static final String FOOD_NAME = "food_name";
    private static final String FOOD_INTRODUCE = "food_introduce";
    private static final String FOOD_PRICE = "food_price";

    public DatabaseFood(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TB_FOOD);
        onCreate(db);
    }

    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String ascriptTBMonHoc = "CREATE TABLE " + TB_FOOD + "(" +
                FOOD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                FOOD_NAME + " TEXT," +
                FOOD_INTRODUCE + " TEXT," +
                FOOD_PRICE + " TEXT)";
        sqLiteDatabase.execSQL(ascriptTBMonHoc);
    }

    //Doc Du Lieu tu SQL
    public void getfood(ArrayList<Food> monHocs) {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query(TB_FOOD,
                new String[]{FOOD_ID,FOOD_NAME, FOOD_INTRODUCE, FOOD_PRICE}, null, null,
                null, null, null);
        if (cursor.moveToFirst()) {
            do {
                Food Monhoc = new Food();
                Monhoc.setId(cursor.getInt(cursor.getColumnIndex(FOOD_ID)));
                Monhoc.setTitle(cursor.getString(cursor.getColumnIndex(FOOD_NAME)));
                Monhoc.setMota(cursor.getString(cursor.getColumnIndex(FOOD_INTRODUCE)));
                Monhoc.setPrice(cursor.getInt(cursor.getColumnIndex(FOOD_PRICE)));
                monHocs.add(Monhoc);
            } while (cursor.moveToNext());
        }
    }
    //LUU vao SQL
    public void saveFood(Food monHoc) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FOOD_NAME, monHoc.getTitle());
        values.put(FOOD_INTRODUCE, monHoc.getMota());
        values.put(FOOD_PRICE, monHoc.getPrice());
        db.insert(TB_FOOD, null, values);
        db.close();
    }


    public boolean deleteFood(String id) {
        boolean result = false;
        String query = "Select * FROM "
                + TB_FOOD + " WHERE "
                + FOOD_ID + " = '"
                + String.valueOf(id) + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Food Account = new Food();
        if (cursor.moveToFirst()) {
            Account.setTitle(cursor.getString(cursor.getColumnIndex(FOOD_ID)));
            db.delete(TB_FOOD, FOOD_ID + "=?",
                    new String[]{
                            String.valueOf(id)
                    });
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }


    public int updateFood(Food food) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put(FOOD_NAME, food.getTitle());
        args.put(FOOD_INTRODUCE, food.getMota());
        args.put(FOOD_PRICE, food.getPrice());
        return db.update(TB_FOOD, args, FOOD_ID + " = ?",
                new String[]
                        {
                                String.valueOf(food.getId())
                        });
    }
}



