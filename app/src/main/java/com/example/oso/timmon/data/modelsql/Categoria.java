package com.example.oso.timmon.data.modelsql;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.oso.timmon.data.sqlite.Estructura.*;

public class Categoria {
    int idCategoria;
    String nombreCat;
    String fechaCreacion;
    String icon;
    int idColor;

    public Categoria(int idCategoria, String nombreCat, String fechaCreacion, String icon, int idColor) {
        this.idCategoria = idCategoria;
        this.nombreCat = nombreCat;
        this.fechaCreacion = fechaCreacion;
        this.icon = icon;
        this.idColor = idColor;
    }

    public  Categoria(Cursor cursor){
        idCategoria=cursor.getInt(cursor.getColumnIndex(ColumnasCategoria.ID));
        nombreCat=cursor.getString(cursor.getColumnIndex(ColumnasCategoria.NOMBRE));
        fechaCreacion=cursor.getString(cursor.getColumnIndex(ColumnasCategoria.FECHA));
        icon=cursor.getString(cursor.getColumnIndex(ColumnasCategoria.ICON));
        idColor=cursor.getInt(cursor.getColumnIndex(ColumnasCategoria.ID_COLOR));
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(ColumnasCategoria.ID, idCategoria);
        values.put(ColumnasCategoria.NOMBRE, nombreCat);
        values.put(ColumnasCategoria.FECHA, fechaCreacion);
        values.put(ColumnasCategoria.ICON, icon);
        values.put(ColumnasCategoria.ID_COLOR, idColor);
        return values;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public String getNombreCat() {
        return nombreCat;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public String getIcon() {
        return icon;
    }

    public int getIdColor() {
        return idColor;
    }
}
