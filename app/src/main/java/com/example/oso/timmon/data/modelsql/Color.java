package com.example.oso.timmon.data.modelsql;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.oso.timmon.data.sqlite.Estructura.*;

public class Color {
    String idColor;
    String valor;

    public Color(String idColor, String valor) {
        this.idColor = idColor;
        this.valor = valor;
    }

    public Color(Cursor cursor) {
        idColor = cursor.getString(cursor.getColumnIndex(ColumnasColor.ID));
        valor = cursor.getString(cursor.getColumnIndex(ColumnasColor.VALOR));
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(ColumnasColor.ID, idColor);
        values.put(ColumnasColor.VALOR, valor);
        return values;
    }

    public String getIdColor() {
        return idColor;
    }

    public String getValor() {
        return valor;
    }
}
