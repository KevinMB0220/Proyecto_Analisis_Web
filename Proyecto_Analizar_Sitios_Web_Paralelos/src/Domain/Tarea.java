/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Tarea {
    private String tarea;
    private ArrayList<URL> urls;

    public Tarea(String tarea, ArrayList<URL> urls) {
        this.tarea = tarea;
        this.urls = urls;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public ArrayList<URL> getUrls() {
        return urls;
    }

    public void setUrls(ArrayList<URL> urls) {
        this.urls = urls;
    }

    @Override
    public String toString() {
        return "Tarea{" + "tarea=" + tarea + ", urls=" + urls + '}';
    }
    
    
}
