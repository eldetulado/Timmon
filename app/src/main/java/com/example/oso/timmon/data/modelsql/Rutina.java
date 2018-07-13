package com.example.oso.timmon.data.modelsql;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.oso.timmon.data.sqlite.Estructura.*;

public class Rutina {
    int idRutina;
    String desde;
    String dias;
    int idTarea;

    public Rutina(int idRutina, String desde, String dias, int idTarea) {
        this.idRutina = idRutina;
        this.desde = desde;
        this.dias = dias;
        this.idTarea = idTarea;
    }

    public Rutina(Cursor cursor) {
        idRutina = cursor.getInt(cursor.getColumnIndex(ColumnasRutina.ID));
        desde = cursor.getString(cursor.getColumnIndex(ColumnasRutina.DESDE));
        dias = cursor.getString(cursor.getColumnIndex(ColumnasRutina.DIAS));
        idTarea = cursor.getInt(cursor.getColumnIndex(ColumnasRutina.ID_TAREA));
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(ColumnasRutina.ID, idRutina);
        values.put(ColumnasRutina.DESDE, desde);
        values.put(ColumnasRutina.DIAS, dias);
        values.put(ColumnasRutina.ID_TAREA, idTarea);

        return values;
    }

    public int getIdRutina() {
        return idRutina;
    }

    public String getDesde() {
        return desde;
    }

    public String getDias() {
        return dias;
    }

    public int getIdTarea() {
        return idTarea;
    }
}
