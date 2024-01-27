/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

/**
 *
 * @author Usuario
 */
public class URL {
    private String direccionUrl;
    private boolean estado;

    public URL(String direccionUrl, boolean estado) {
        this.direccionUrl = direccionUrl;
        this.estado = estado;
    }

    public String getDireccionUrl() {
        return direccionUrl;
    }

    public void setDireccionUrl(String direccionUrl) {
        this.direccionUrl = direccionUrl;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "URL{" + "direccionUrl=" + direccionUrl + ", estado=" + estado + '}';
    }
    
    
}
