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
public class Grupo {
    public int idGrupo;
    public String name;
    public boolean priavate;
    public String admin;
    public int estado;
    
    public Grupo(String _name, boolean _private, String _admin,int estado){
        this.name = _name;
        this.priavate = _private;
        this.admin = _admin;
        this.estado=estado;
    }
    
    public void setIdGroup(int idGroup) {
        this.idGrupo = idGroup;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
