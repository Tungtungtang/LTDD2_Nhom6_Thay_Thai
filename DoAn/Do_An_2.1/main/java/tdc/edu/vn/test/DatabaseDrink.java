package tdc.edu.vn.test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseDrink extends SQLiteOpenHelper {
    private static String DB_NAME = "dbDrink.db";
    private static int DB_VERSION = 1;

    private static final String TB_DRINK = "tbDRINK";
    private static final String DRINK_ID = "drink_id";
    private static final String DRINK_NAME = "drink_name";
    private static final String DRINK_INTRODUCE = "drink_introduce";
    private static final String DRINK_PRICE = "drink_price";
    public DatabaseDrink(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TB_DRINK);
        onCreate(db);
    }

    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String ascriptTBMonHoc = "CREATE TABLE " + TB_DRINK + "(" +
                DRINK_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                DRINK_NAME + " TEXT," +
                DRINK_INTRODUCE + " TEXT," +
                DRINK_PRICE + " TEXT)";
        sqLiteDatabase.execSQL(ascriptTBMonHoc);
    }
    //Doc Du Lieu tu SQL
    public void getDrink(ArrayList<Drink> monHocs) {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query(TB_DRINK,
                new String[]{DRINK_NAME, DRINK_INTRODUCE, DRINK_PRICE}, null, null,
                null, null, null);
        if (cursor.moveToFirst()) {
            do {
                Drink Monhoc = new Drink();
                Monhoc.setTitle1(cursor.getString(cursor.getColumnIndex(DRINK_NAME)));
                Monhoc.setMota(cursor.getString(cursor.getColumnIndex(DRINK_INTRODUCE)));
                Monhoc.setPrice(cursor.getString(cursor.getColumnIndex(DRINK_PRICE)));

                monHocs.add(Monhoc);
            } while (cursor.moveToNext());
        }
    }

    //LUU vao SQL
    public void saveDrink(Drink drink) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DRINK_NAME, drink.getTitle1());
        values.put(DRINK_INTRODUCE, drink.getMota());
        values.put(DRINK_PRICE, drink.getPrice());
        db.insert(TB_DRINK, null, values);
        db.close();
    }
    public boolean deleteDrink(String id) {
        boolean result = false;
        String query = "Select * FROM "
                + TB_DRINK + " WHERE "
                + DRINK_NAME+ " = '"
                + String.valueOf(id) + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Drink Account = new Drink();
        if (cursor.moveToFirst()) {
            Account.setTitle1(cursor.getString(cursor.getColumnIndex(DRINK_NAME)));
            db.delete(TB_DRINK, DRINK_NAME + "=?",
                    new String[]{
                            String.valueOf(Account.getTitle1())
                    });
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }

    public int updateDrink(Drink drink) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put(DRINK_NAME, drink.getTitle1());
        args.put(DRINK_INTRODUCE, drink.getMota());
        args.put(DRINK_PRICE, drink.getPrice());
        return db.update(TB_DRINK, args, DRINK_NAME + " = ?",
                new String[]
                        {
                                String.valueOf(drink.getTitle1())
                        });
    }
}
