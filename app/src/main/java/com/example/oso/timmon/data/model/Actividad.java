package com.example.oso.timmon.data.model;

import android.graphics.Color;

public class Actividad {
    private String nombreActividad;
    private int tiempoActividad;
    private String tiempoUltimaVez;
    private Boolean estadoActividad = false;
    private Boolean esRutina;
    private int color;

    public Actividad(String nombreActividad, int tiempoActividad, String tiempoUltimaVez,
                     Boolean estadoActividad, Boolean esRutina, int color) {
        this.nombreActividad = nombreActividad;
        this.tiempoActividad = tiempoActividad;
        this.tiempoUltimaVez = tiempoUltimaVez;
        this.estadoActividad = estadoActividad;
        this.esRutina = esRutina;
        this.color = color;
    }

    public void setEstadoActividad(Boolean estadoActividad) {
        this.estadoActividad = estadoActividad;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public int getTiempoActividad() {
        return tiempoActividad;
    }

    public String getTiempoUltimaVez() {
        return tiempoUltimaVez;
    }

    public Boolean getEstadoActividad() {
        return estadoActividad;
    }

    public Boolean getEsRutina() {
        return esRutina;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public void setTiempoActividad(int tiempoActividad) {
        this.tiempoActividad = tiempoActividad;
    }

    public void setTiempoUltimaVez(String tiempoUltimaVez) {
        this.tiempoUltimaVez = tiempoUltimaVez;
    }

    public void setEsRutina(Boolean esRutina) {
        this.esRutina = esRutina;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Actividad() {
    }

    public int getColor() {
        return color;
    }
}
