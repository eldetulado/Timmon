package com.example.oso.timmon.data.modelsql;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.oso.timmon.data.sqlite.Estructura.*;

public class Tiempo {
    int idTiempo;
    String inicio;
    String finals;
    String fecha;
    int total;
    int idTarea;

    public Tiempo(int idTiempo, String inicio, String finals, String fecha,int total, int idTarea) {
        this.idTiempo = idTiempo;
        this.inicio = inicio;
        this.finals = finals;
        this.fecha = fecha;
        this.total=total;
        this.idTarea = idTarea;
    }

    public Tiempo(Cursor cursor) {
        idTiempo = cursor.getInt(cursor.getColumnIndex(ColumnasTiempo.ID));
        inicio = cursor.getString(cursor.getColumnIndex(ColumnasTiempo.INICIO));
        finals = cursor.getString(cursor.getColumnIndex(ColumnasTiempo.FINALS));
        total = cursor.getInt(cursor.getColumnIndex(ColumnasTiempo.TOTAL));
        idTarea = cursor.getInt(cursor.getColumnIndex(ColumnasTiempo.ID_TAREA));
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(ColumnasTiempo.ID, idTarea);
        values.put(ColumnasTiempo.INICIO, inicio);
        values.put(ColumnasTiempo.FINALS, finals);
        values.put(ColumnasTiempo.FECHA, fecha);
        values.put(ColumnasTiempo.TOTAL, total);
        values.put(ColumnasTiempo.ID_TAREA, idTarea);

        return values;
    }

    public int getIdTiempo() {
        return idTiempo;
    }

    public String getInicio() {
        return inicio;
    }

    public String getFinals() {
        return finals;
    }

    public String getFecha() {
        return fecha;
    }

    public int getTotal() {
        return total;
    }

    public int getIdTarea() {
        return idTarea;
    }
}
