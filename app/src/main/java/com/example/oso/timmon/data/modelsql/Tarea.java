package com.example.oso.timmon.data.modelsql;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.oso.timmon.data.sqlite.Estructura.*;

public class Tarea {
    int idTarea;
    String nombreTarea;
    int idCategoria;

    public Tarea() {
    }

    public Tarea(int idTarea, String nombreTarea, int idCategoria) {
        this.idTarea = idTarea;
        this.nombreTarea = nombreTarea;
        this.idCategoria = idCategoria;
    }

    public Tarea(Cursor cursor) {
        idTarea = cursor.getInt(cursor.getColumnIndex(ColumnasTarea.ID));
        nombreTarea = cursor.getString(cursor.getColumnIndex(ColumnasTarea.NOMBRE));
        idCategoria = cursor.getInt(cursor.getColumnIndex(ColumnasTarea.ID_CATEGORIA));
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(ColumnasTarea.ID, idTarea);
        values.put(ColumnasTarea.NOMBRE, nombreTarea);
        values.put(ColumnasTarea.ID_CATEGORIA, idCategoria);

        return values;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public String getNombreTarea() {
        return nombreTarea;
    }

    public int getIdCategoria() {
        return idCategoria;
    }
}
