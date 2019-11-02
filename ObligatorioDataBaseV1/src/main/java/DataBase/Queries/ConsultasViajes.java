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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
            
//            
//            
//            PreparedStatement statement3 = connection.prepareStatement("insert into grupo_usuario"
//                    + " values(?,?)", Statement.RETURN_GENERATED_KEYS);
//            statement2.setInt(1, id);
//            statement2.setString(2, group.admin);
//            statement2.executeUpdate();

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
    
}
