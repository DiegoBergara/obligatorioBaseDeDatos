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
public class Participacion {
    public String solicitante;
    //public boolean estado_persona, estado_parada;
    public int parada, viaje, estado_persona, estado_parada;

    public Participacion(int parada, String solicitante, int viaje, int estado_persona, int estado_parada) {
        this.parada = parada;
        this.solicitante = solicitante;
        this.estado_persona = estado_persona;
        this.estado_parada = estado_parada;
        this.viaje = viaje;
    }

    public int getParada() {
        return parada;
    }

    public void setParada(int parada) {
        this.parada = parada;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public int getViaje() {
        return viaje;
    }

    public void setViaje(int viaje) {
        this.viaje = viaje;
    }
    
    
    public int getEstado_persona() {
        return estado_persona;
    }

    public void setEstado_persona(int estado_persona) {
        this.estado_persona = estado_persona;
    }

    public int getEstado_parada() {
        return estado_parada;
    }

    public void setEstado_parada(int estado_parada) {
        this.estado_parada = estado_parada;
    }
    


    
}
