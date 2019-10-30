/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase.Queries;

import Data.Classes.Ubicacion;
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
    
}
