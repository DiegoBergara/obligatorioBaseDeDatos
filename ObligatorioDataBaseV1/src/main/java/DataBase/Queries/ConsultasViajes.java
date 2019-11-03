/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase.Queries;

import Data.Classes.Grupo;
import Data.Classes.Viaje;
import DataBase.Connection.ConnectionManager;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class ConsultasViajes {
    
    public ConsultasViajes() {
    
    }
    
    public int insertar(Viaje viaje, int visibility, int group_id) {
        Connection connection = ConnectionManager.getConnection();
        try {

            PreparedStatement statement = connection.prepareStatement("insert into viajes(id_ruta, conductor, estado, fecha, partida, lugares_disponibles)"
                    + " values(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, viaje.id_ruta);
            statement.setString(2, viaje.mail_publicante);
            statement.setInt(3, viaje.estado);
            statement.setDate(4, viaje.fecha);
            statement.setTime(5, viaje.hora);
            statement.setInt(6, viaje.lugares_disponibles);
            statement.executeUpdate();
            ResultSet keys = statement.getGeneratedKeys();
            keys.next();
            int id = keys.getInt(1); 
            viaje.setID(id);
            
            int group=-1;
            if(visibility == 1){
                group = group_id;
            }
            
            PreparedStatement statement2 = connection.prepareStatement("insert into grupo_viaje"
                    + " values(?,?)", Statement.RETURN_GENERATED_KEYS);
            statement2.setInt(1, group);
            statement2.setInt(2, id);
            statement2.executeUpdate();
            return id;

        } catch (SQLException sqle) {
            System.out.println("Error: " + sqle);
            return -1;
        } finally {
            ConnectionManager.closeConnection(connection);
        }
    }
    
    
    public boolean cambiarEstadoViaje(int id_viaje, int estado) {
        Connection connection = ConnectionManager.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE public.viajes SET estado= ? "
                            + "WHERE (id_viaje='"+id_viaje+"');");
            statement.setInt(1,estado);
            statement.executeUpdate();
            return true;

        } catch (SQLException sqle) {
            System.out.println("Error: " + sqle);
            return false;
        } finally {
            ConnectionManager.closeConnection(connection);
        }
    }
    
     
    public List<Viaje> getViajesGroups(int grupo_id) {
        Connection connection = ConnectionManager.getConnection();
        ArrayList<Viaje> viajes = new ArrayList<Viaje>();
        try {

            PreparedStatement statement = connection.prepareStatement("select v.id_viaje as id_viaje, \n" +
            "	   r.id_ruta as id_ruta, \n" +
            "	   v.conductor as conductor, \n" +
            "	   v.fecha as fecha, \n" +
            "	   v.partida as hora, \n" +
            "	   v.lugares_disponibles as lg,\n" +
            "      v.estado as estado,\n" +
            "	   uo.calle as ocalle,\n" +
            "	   uo.nro_puerta as onumero,\n" +
            "	   ud.calle as dcalle,\n" +
            "	   ud.nro_puerta as dnumero\n" +
            "from grupo_viaje gv \n" +
            "join viajes v on gv.viaje = v.id_viaje\n" +
            "join rutas r on v.id_ruta = r.id_ruta\n" +
            "join ubicaciones uo on uo.id_ubicacion = r.origen  \n" +
            "join ubicaciones ud on ud.id_ubicacion = r.destino\n" +
            "where gv.grupo = ? ");
            statement.setInt(1, grupo_id);
            
            ResultSet rs = statement.executeQuery();
            while ( rs.next() )
            {
                viajes.add(new Viaje(rs.getInt("id_ruta"), rs.getString("conductor"), rs.getInt("estado"),rs.getTime("hora"), rs.getDate("fecha"), rs.getInt("lg")));
                viajes.get(viajes.size()-1).setUbicaciones(rs.getString("ocalle"), rs.getInt("onumero"), rs.getString("dcalle"), rs.getInt("dnumero"));
                viajes.get(viajes.size()-1).setID(rs.getInt("id_viaje"));
            }
            
            rs.close();
            statement.close();

            return viajes;

        } catch (SQLException sqle) {
            System.out.println("Error: " + sqle);
            return null;
        } finally {
            ConnectionManager.closeConnection(connection);
        }
    }
    
    
}
