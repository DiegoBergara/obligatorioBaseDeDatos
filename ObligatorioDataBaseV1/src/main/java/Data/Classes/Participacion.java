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
    public int parada, viaje, estado;

    public Participacion(int parada, String solicitante, int viaje, int estado) {
        this.parada = parada;
        this.solicitante = solicitante;
        this.estado = estado;
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
    
    
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    


    
}
