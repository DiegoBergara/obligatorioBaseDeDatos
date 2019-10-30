/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase.Queries;

import Data.Classes.Parada;
import Data.Classes.Ubicacion;
import Data.Classes.Usuario;
import DataBase.Connection.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;

/**
 *
 * @author USER
 */
public class ConsultasParadas {
    
     public int insertar(Parada parada) {
        Connection connection = ConnectionManager.getConnection();
        try {

            PreparedStatement statement = connection.prepareStatement("insert into paradas(ubicacion,hora)"
                    + " values(?,?)", Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, parada.idUbicacion);
            statement.setTime(2, parada.hora);
            statement.executeUpdate();
            ResultSet keys = statement.getGeneratedKeys();
            keys.next();
            int id = keys.getInt(1); 
            parada.setIdUbicacion(id);
            return id;

        } catch (SQLException sqle) {
            System.out.println("Error: " + sqle);
            return -1;
        } finally {
            ConnectionManager.closeConnection(connection);
        }
    }
    
    
}
