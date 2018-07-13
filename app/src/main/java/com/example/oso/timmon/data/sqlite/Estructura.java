package com.example.oso.timmon.data.sqlite;

import android.provider.BaseColumns;

import java.util.UUID;

public class Estructura {


    public static abstract class ColumnasCategoria implements BaseColumns {
        public static final String TABLE_NAME ="categoria";

        public static final String ID = "id_categoria";
        public static final String NOMBRE = "nombre_categoria";
        public static final String FECHA = "fecha_creacion";
        public static final String ICON = "icon";
        public static final String ID_COLOR = "color";
    }

    public static abstract class ColumnasColor implements BaseColumns{
        public static final String TABLE_NAME ="color";

        public static final String ID="id_color";
        public static final String VALOR= "valor";
    }

    public static abstract class ColumnasRutina implements BaseColumns{
        public static final String TABLE_NAME ="rutina";

        public static final String ID="id_rutina";
        public static final String DESDE= "desde";
        public static final String DIAS= "dias";
        public static final String ID_TAREA= "id_tarea";
    }

    public static abstract class ColumnasTarea implements BaseColumns{
        public static final String TABLE_NAME ="tarea";

        public static final String ID="id_tarea";
        public static final String NOMBRE="nombre_tarea";
        public static final String ID_CATEGORIA= "id_categoria";
    }

    public static abstract class ColumnasTiempo implements BaseColumns{
        public static final String TABLE_NAME ="tiempo";

        public static final String ID="id_tiempo";
        public static final String INICIO="inicio";
        public static final String FINALS="final";
        public static final String FECHA="fecha";
        public static final String TOTAL="total";
        public static final String ID_TAREA= "id_tarea";
    }
}
