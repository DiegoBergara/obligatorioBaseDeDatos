/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase.Queries;

import Data.Classes.Valoracion;
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
public class ConsultasValoraciones {

    public boolean insertar(Valoracion valoracion) {
        Connection connection = ConnectionManager.getConnection();
        try {

            PreparedStatement statement = connection.prepareStatement(
                    "insert into valoraciones(calificador, calificado, calificacion, observaciones)"
                    + " values(?,?,?,?)");
            statement.setString(1, valoracion.calificador);
            statement.setString(2, valoracion.calificado);
            statement.setInt(3, valoracion.calificacion);
            statement.setString(4, valoracion.observaciones);
            statement.executeUpdate();
//            ResultSet keys = statement.getGeneratedKeys();
//            keys.next();
            return true;

        } catch (SQLException sqle) {
            System.out.println("Error: " + sqle);
            return false;
        } finally {
            ConnectionManager.closeConnection(connection);
        }
    }
    
}
