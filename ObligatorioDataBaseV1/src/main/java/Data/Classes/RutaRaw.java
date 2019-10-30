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
public class RutaRaw {
    
    public int idRuta;
    public int origen;
    public int destino;

    public RutaRaw(int origen, int destino) {
        this.origen = origen;
        this.destino = destino;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public void setOrigen(int origen) {
        this.origen = origen;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }
    
    
}
