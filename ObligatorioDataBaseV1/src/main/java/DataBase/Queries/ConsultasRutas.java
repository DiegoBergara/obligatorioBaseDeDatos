/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase.Queries;

import Data.Classes.RutaRaw;
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
public class ConsultasRutas {
    
     public int insertar(RutaRaw ruta) {
        Connection connection = ConnectionManager.getConnection();
        try {

            PreparedStatement statement = connection.prepareStatement("insert into rutas(origen,destino)"
                    + " values(?,?)", Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, ruta.origen);
            statement.setInt(2, ruta.destino);
            statement.executeUpdate();
            ResultSet keys = statement.getGeneratedKeys();
            keys.next();
            int id = keys.getInt(1); 
            ruta.setIdRuta(id);
            return id;

        } catch (SQLException sqle) {
            System.out.println("Error: " + sqle);
            return -1;
        } finally {
            ConnectionManager.closeConnection(connection);
        }
    }
    
}
