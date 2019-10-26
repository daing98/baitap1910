package com.example.baitap;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    DBHelper(Context context) {
        super(context, "BookDatabase11.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table Book(id interger primary key," + "title text," + "id_author interger)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Book");
        onCreate(db);
    }

    public boolean insertBook(Book book) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", book.getId_book());
        contentValues.put("title", book.getTitle());
        contentValues.put("id_author", book.getId_author());
        db.insert("Book", null, contentValues);
        return true;

    }



    public Book getBook(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Book where id=" + id, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        Book book = new Book(cursor.getInt(0), cursor.getString(1), cursor.getInt(2));
        cursor.close();
        db.close();
        return book;

    }



    public ArrayList<Book> getAllBook() {
        ArrayList<Book> listBook = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Book", null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        while (cursor.isAfterLast() == false) {
            listBook.add(new Book(cursor.getInt(0), cursor.getString(1), cursor.getInt(2)));
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return listBook;

    }




    public boolean deleteBook(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        int count = db.delete("Book", "id" + "=?", new String[]{String.valueOf(id)});
        db.close();
        if (count > 0)
            return true;
        return false;
    }



    public boolean updateBook(Book book) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", book.getTitle());
        contentValues.put("id_author", book.getId_author());
        int count = db.update("Book",contentValues,"id="+book.getId_book(),null);
        if (count > 0)
            return true;
        return false;
    }





}



