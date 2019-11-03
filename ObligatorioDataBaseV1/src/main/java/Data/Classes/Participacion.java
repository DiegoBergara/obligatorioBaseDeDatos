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
    public String solicitante, calle, conductor;
    
    public int parada, viaje, estado, numero_calle;
    

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
    
    public void setUbicacion(String calle, int nro){
        this.calle = calle;
        this.numero_calle = nro;
    }
    
    public void setConductor(String conductor) {
        this.conductor = conductor;
    }
    
}
