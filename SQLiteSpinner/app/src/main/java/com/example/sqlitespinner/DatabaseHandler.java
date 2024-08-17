package com.example.sqlitespinner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "mydatabase";
    private static final String TABLE_NAME = "Users";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD = "password";
    private Connection conn;

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    // Method to create the users table if it doesn't exist
    private void createTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                + COLUMN_NAME + " TEXT NOT NULL, "
                + COLUMN_EMAIL + "TEXT NOT NULL,"
                + COLUMN_PASSWORD + " TEXT NOT NULL);";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
            System.out.println("Table " + TABLE_NAME + " is ready.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Method to insert a new record into the users table
    public void insertUser( User obj ){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME,obj.getName());
        values.put(COLUMN_EMAIL,obj.getPassword());
        values.put(COLUMN_PASSWORD,obj.getPassword());

        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    public User getUserByEmail(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        User user = null;

        String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_EMAIL + " = ?";
        Cursor cursor = db.rawQuery(selectQuery, new String[]{email});

        if (cursor.moveToFirst()) {
            String name = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME));
            String password = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PASSWORD));

            user = new User(name, email, password);
        }

        cursor.close();
        db.close();

        return user;
    }



    // Method to query all users from the users table
    public ResultSet getAllUsers() {
        String selectSQL = "SELECT * FROM " + TABLE_NAME;
        ResultSet rs = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement(selectSQL);
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

    // Method to close the connection to the database
    public void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Connection to SQLite has been closed.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
