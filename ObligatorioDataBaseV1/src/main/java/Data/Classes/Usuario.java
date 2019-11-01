/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Classes;

/**
 *
 * @author USER
 */
public class Usuario {
    
    public String mail;
    public String password;
    public String nombre;
    public String apellido;
    public int valoracion;
    public boolean conductor;
    public String vehiculo;
    public int estado;
    
    public Usuario(String mail, String password, String nombre, String apellido,  boolean conductor, String vehiculo, int estado) {
        this.mail = mail;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.valoracion = 0;
        this.conductor = conductor;
        this.vehiculo = vehiculo;
        this.estado=estado;
    }
    
    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public void setConductor(boolean conductor) {
        this.conductor = conductor;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }


    
    
    
}
