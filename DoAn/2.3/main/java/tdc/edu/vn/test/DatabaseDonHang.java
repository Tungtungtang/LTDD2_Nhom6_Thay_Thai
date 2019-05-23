//package tdc.edu.vn.test;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//import java.util.ArrayList;
//
//public class DatabaseDonHang extends SQLiteOpenHelper {
//    private static String DB_NAME = "dbDonHang.db";
//    private static int DB_VERSION = 3;
//
//    private static final String TB_DH = "tbDH";
//    private static final String BAN_ID = "ban_id";
//    private static final String HD_ID = "hd_id";
//    private static final String HD_NAME = "hd_name";
//    private static final String HD_PRICE = "hd_price";
//    private static final String HD_SL = "hd_sl";
//    public DatabaseDonHang(Context context) {
//        super(context, DB_NAME, null, DB_VERSION);
//    }
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
//        db.execSQL("DROP TABLE IF EXISTS " + TB_DH);
//        onCreate(db);
//    }
//
//
//    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        String ascriptTBMonHoc = "CREATE TABLE " + TB_DH + "(" +
//                HD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
//                HD_NAME + " TEXT," +
//                HD_PRICE + " TEXT," +
//                HD_SL + " TEXT)";
//        sqLiteDatabase.execSQL(ascriptTBMonHoc);
//    }
//    //Doc Du Lieu tu SQL
//    public void getHoaDon(ArrayList<HoaDon> monHocs) {
//        SQLiteDatabase db = getWritableDatabase();
//        Cursor cursor = db.query(TB_DH,
//                new String[]{BAN_ID,HD_NAME, HD_PRICE, HD_SL}, null, null,
//                null, null, null);
//        if (cursor.moveToFirst()) {
//            do {
//                HoaDon Monhoc = new HoaDon();
//                Monhoc.setTen(cursor.getString(cursor.getColumnIndex(HD_NAME)));
//                Monhoc.setGia(cursor.getString(cursor.getColumnIndex(HD_PRICE)));
//                Monhoc.setSoLuong(cursor.getString(cursor.getColumnIndex(HD_SL)));
//                monHocs.add(Monhoc);
//            } while (cursor.moveToNext());
//        }
//    }
//    //LUU vao SQL
//    public void saveHoaDon(HoaDon hoaDon) {
//        SQLiteDatabase db = getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(HD_NAME, hoaDon.getTen());
//        values.put(HD_PRICE, hoaDon.getGia());
//        values.put(HD_SL, hoaDon.getSoLuong());
//        db.insert(TB_DH, null, values);
//        db.close();
//    }
//}
