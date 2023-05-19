package com.example.studentsdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.LinkedList;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "studentsDb";
    public static final String TABLE_STUDENTS = "students";

    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_LAST_NAME = "last_name";
    public static final String KEY_PATRONYMIC = "patronymic";
    public static final String KEY_DATE = "date";
    public static final String KEY_GR = "gr";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_STUDENTS + "(" + KEY_ID
                + " integer primary key," + KEY_NAME + " text," + KEY_LAST_NAME
                + " text," + KEY_PATRONYMIC + " text," + KEY_DATE + " date," + KEY_GR + " integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_STUDENTS);

        onCreate(db);
    }

    public void addStudent(Student student){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(KEY_NAME, student.getName());
        contentValues.put(KEY_LAST_NAME, student.getLastName());
        contentValues.put(KEY_PATRONYMIC, student.getPatronymic());
        contentValues.put(KEY_DATE, student.getDate());
        contentValues.put(KEY_GR, student.getGroup());

        database.insert(TABLE_STUDENTS, null, contentValues);
        database.close();
    }

    public LinkedList<Student> getAll(){
        LinkedList<Student> list = new LinkedList<>();
        SQLiteDatabase database = this.getWritableDatabase();

        Cursor cursor = database.query(TABLE_STUDENTS, null, null, null, null, null, KEY_LAST_NAME);

        if (cursor.moveToFirst())
            do {
                int id_name = cursor.getColumnIndex(KEY_NAME);
                int id_last_name = cursor.getColumnIndex(KEY_LAST_NAME);
                int id_patronymic = cursor.getColumnIndex(KEY_PATRONYMIC);
                int id_date = cursor.getColumnIndex(KEY_DATE);
                int id_group = cursor.getColumnIndex(KEY_GR);

                Student student = new Student(cursor.getString(id_name), cursor.getString(id_last_name), cursor.getString(id_patronymic),
                        cursor.getString(id_date), cursor.getString(id_group));
                list.add(student);
            } while (cursor.moveToNext());

        database.close();
        return list;
    }

    public LinkedList<Student> getGroupSorted(){
        LinkedList<Student> list = new LinkedList<>();
        SQLiteDatabase database = this.getWritableDatabase();

        Cursor cursor = database.query(TABLE_STUDENTS, null, null, null, null, null, KEY_GR);

        if (cursor.moveToFirst())
            do {
                int id_name = cursor.getColumnIndex(KEY_NAME);
                int id_last_name = cursor.getColumnIndex(KEY_LAST_NAME);
                int id_patronymic = cursor.getColumnIndex(KEY_PATRONYMIC);
                int id_date = cursor.getColumnIndex(KEY_DATE);
                int id_group = cursor.getColumnIndex(KEY_GR);

                Student student = new Student(cursor.getString(id_name), cursor.getString(id_last_name), cursor.getString(id_patronymic),
                        cursor.getString(id_date), cursor.getString(id_group));
                list.add(student);
            } while (cursor.moveToNext());

        database.close();
        return list;
    }
}
