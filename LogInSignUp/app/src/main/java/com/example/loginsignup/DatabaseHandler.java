package com.example.loginsignup;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "mydatabase";
    private static final String TABLE_NAME = "Users";
    private static final String COLUMN_ID  = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD = "password";
    private Connection conn;

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
//        String CREATE_TABLE_MESSAGE = "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_ID +"TEXT PRIMARY KEY"+ COLUMN_NAME +
//                " TEXT," + COLUMN_EMAIL + " TEXT" + COLUMN_PASSWORD+ "TEXT" + ")";
        String CREATE_TABLE_MESSAGE = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NAME + " TEXT, "
                + COLUMN_EMAIL + " TEXT, "
                + COLUMN_PASSWORD + " TEXT);";

        db.execSQL(CREATE_TABLE_MESSAGE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        onCreate(db);
    }

    public void insertUser(User user) throws Exception {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, user.getName());
        values.put(COLUMN_EMAIL, user.getEmail());
        values.put(COLUMN_PASSWORD, user.getPassword());

        long result = db.insert(TABLE_NAME, null, values);

        if (result == -1) {
            throw new Exception("Email already exists");
        }

        db.close();
    }

    public User getUserDetails(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[] { COLUMN_ID, COLUMN_NAME, COLUMN_PASSWORD },
                COLUMN_EMAIL + "=?", new String[] { email },
                null, null, null, null);

        User user = null;
        if (cursor != null && cursor.moveToFirst()) {
            String name = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME));
            String password = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PASSWORD));

            user = new User(name, email, password); // Assuming you have a User class to hold these values
            cursor.close();
        }
        db.close();
        return user;
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        String selectQuery = "SELECT " + COLUMN_NAME + ", " + COLUMN_PASSWORD + " FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setName(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME)));
                user.setPassword(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PASSWORD)));
                userList.add(user);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return userList;
    }


    public void updateUserPassword(User user) {
    SQLiteDatabase db = this.getWritableDatabase();

    ContentValues values = new ContentValues();
    values.put(COLUMN_PASSWORD, user.getPassword());

    db.update(TABLE_NAME, values, COLUMN_EMAIL + " = ?", new String[]{user.getEmail()});
    db.close();
    }

}