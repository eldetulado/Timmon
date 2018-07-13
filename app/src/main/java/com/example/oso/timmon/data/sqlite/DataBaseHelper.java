package com.example.oso.timmon.data.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.provider.BaseColumns;

import com.example.oso.timmon.data.modelsql.Categoria;
import com.example.oso.timmon.data.modelsql.Tarea;
import com.example.oso.timmon.data.sqlite.Estructura.*;

public class DataBaseHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "data.db";
    static final int DATABASE_VERSION = 1;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + ColumnasCategoria.TABLE_NAME + " ("
                + ColumnasCategoria._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ColumnasCategoria.ID + " TEXT NOT NULL,"
                + ColumnasCategoria.NOMBRE + " TEXT NOT NULL,"
                + ColumnasCategoria.FECHA + " TEXT NOT NULL,"
                + ColumnasCategoria.ICON + " TEXT NOT NULL,"
                + ColumnasCategoria.ID_COLOR + " INTEGER NOT NULL,"
                + "FOREIGN KEY(" + ColumnasCategoria.ID_COLOR + ") REFERENCES "+ ColumnasColor.TABLE_NAME+"("+ColumnasColor.ID+"),"
                + "UNIQUE (" + ColumnasCategoria.ID + "))");

        db.execSQL("CREATE TABLE " + ColumnasColor.TABLE_NAME + " ("
                + ColumnasColor._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ColumnasColor.ID + " TEXT NOT NULL,"
                + ColumnasColor.VALOR + " TEXT NOT NULL,"
                + "UNIQUE (" + ColumnasColor.ID + "))");

        db.execSQL("CREATE TABLE " + ColumnasRutina.TABLE_NAME + " ("
                + ColumnasRutina._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ColumnasRutina.ID + " TEXT NOT NULL,"
                + ColumnasRutina.DESDE + " TEXT NOT NULL,"
                + ColumnasRutina.DIAS + " TEXT NOT NULL,"
                + ColumnasRutina.ID_TAREA + " INTEGER NOT NULL,"
                + "FOREIGN KEY(" + ColumnasRutina.ID_TAREA + ") REFERENCES "+ ColumnasTarea.TABLE_NAME+"("+ColumnasTarea.ID+"),"
                + "UNIQUE (" + ColumnasRutina.ID + "))");

        db.execSQL("CREATE TABLE " + ColumnasTarea.TABLE_NAME + " ("
                + ColumnasTarea._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ColumnasTarea.NOMBRE + " TEXT NOT NULL,"
                + ColumnasTarea.ID_CATEGORIA + " INTEGER NOT NULL,"
                + "FOREIGN KEY(" + ColumnasTarea.ID_CATEGORIA + ") REFERENCES "+ ColumnasCategoria.TABLE_NAME+"("+ColumnasCategoria.ID+"))"
                 );

        db.execSQL("CREATE TABLE " + ColumnasTiempo.TABLE_NAME + " ("
                + ColumnasTiempo._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ColumnasTiempo.ID + " TEXT NOT NULL,"
                + ColumnasTiempo.INICIO + " TEXT NOT NULL,"
                + ColumnasTiempo.FINALS + " TEXT NOT NULL,"
                + ColumnasTiempo.FECHA + " TEXT NOT NULL,"
                + ColumnasTiempo.TOTAL + " INTEGER NOT NULL,"
                + ColumnasTiempo.ID_TAREA + " INTEGER NOT NULL,"

                + "FOREIGN KEY(" + ColumnasTiempo.ID_TAREA + ") REFERENCES "+ ColumnasTarea.TABLE_NAME+"("+ColumnasTarea.ID+"),"
                + "UNIQUE (" + ColumnasTarea.ID + "))");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ ColumnasTarea.TABLE_NAME);
        onCreate(db);
    }
}
