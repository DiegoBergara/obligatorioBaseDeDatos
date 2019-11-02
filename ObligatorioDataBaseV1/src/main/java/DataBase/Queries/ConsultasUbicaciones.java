/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase.Queries;

import Data.Classes.Ubicacion;
import Data.Classes.Usuario;
import DataBase.Connection.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author USER
 */
public class ConsultasUbicaciones {
    
     public Ubicacion insertar(Ubicacion ubicacion) {
        Connection connection = ConnectionManager.getConnection();
        try {

            PreparedStatement statement = connection.prepareStatement("insert into ubicaciones(calle,nro_puerta)"
                    + " values(?,?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, ubicacion.calle);
            statement.setInt(2, ubicacion.nroPuerta);
            statement.executeUpdate();
            ResultSet keys = statement.getGeneratedKeys();
            keys.next();
            int id = keys.getInt(1); 
            ubicacion.setIdUbicacion(id);
            return ubicacion;

        } catch (SQLException sqle) {
            System.out.println("Error: " + sqle);
            return null;
        } finally {
            ConnectionManager.closeConnection(connection);
        }
    }
     
    public Ubicacion buscarUbicacion(String calle, int numero_puerta){
        Connection connection = ConnectionManager.getConnection();
        List<Ubicacion> ubicaciones = new LinkedList<Ubicacion>();
        try {

            PreparedStatement statement = connection.prepareStatement("Select * from ubicaciones Where calle=? and nro_puerta=?");
            statement.setString(1, calle);
            statement.setInt(2, numero_puerta);
            
            ResultSet rs = statement.executeQuery();
            while ( rs.next() )
            {
                ubicaciones.add(new Ubicacion(rs.getString("calle"),
                        rs.getInt("nro_puerta")));
                ubicaciones.get(ubicaciones.size()-1).setIdUbicacion(rs.getInt("id_ubicacion"));
            }
            
            rs.close();
            statement.close();
            if(ubicaciones.size() == 1){
                return ubicaciones.get(0);
            }
            return null;
            

        } catch (SQLException sqle) {
            System.out.println("Error: " + sqle);
            return null;
        } finally {
            ConnectionManager.closeConnection(connection);
        }
     }
    
}
