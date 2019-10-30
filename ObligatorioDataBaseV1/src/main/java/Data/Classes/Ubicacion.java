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
public class Ubicacion {
    
    public int idUbicacion;
    public String calle;
    public int nroPuerta;

    public Ubicacion(String calle, int nroPuerta) {
        this.calle = calle;
        this.nroPuerta = nroPuerta;
    }
    
    public void setIdUbicacion(int idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setNroPuerta(int nroPuerta) {
        this.nroPuerta = nroPuerta;
    }
    
}
