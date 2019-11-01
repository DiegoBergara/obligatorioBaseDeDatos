/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Classes;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author USER
 */
public class Viaje {
    public int viaje_id;
    public int id_ruta;
    public String mail_publicante;
    public int estado;
    public Time hora;
    public Date fecha;
    public int lugares_disponibles;
    
    public Viaje(int rutaID, String mail_publicante, int estado, Time hora, Date fecha, int lugares_disponibles){
        this.id_ruta = rutaID;
        this.mail_publicante = mail_publicante;
        this.estado = estado; 
        this.fecha = fecha;
        this.hora = hora;
        this.lugares_disponibles = lugares_disponibles;
    }
    
    public void setID(int id){
        this.viaje_id = id;
    }

        
    
}
