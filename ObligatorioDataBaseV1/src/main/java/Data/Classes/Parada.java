/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Classes;

import java.sql.Time;
import java.time.LocalTime;

/**
 *
 * @author USER
 */
public class Parada {
    
   public int idParada;
    public int idUbicacion;
    public Time hora;

    public Parada(int idUbicacion, Time hora) {
        this.idUbicacion = idUbicacion;
        this.hora = hora;
    }
   
    
    public void setIdParada(int idParada) {
        this.idParada = idParada;
    }

    public void setIdUbicacion(int idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }
    
}
