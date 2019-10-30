/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase.Queries;


import Data.Classes.Usuario;
 import DataBase.Connection.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author USER
 */
public class ConsultasUsuarios {

    public ConsultasUsuarios() {
    }
    
    public boolean insertar(Usuario user) {
        Connection connection = ConnectionManager.getConnection();
        try {

            PreparedStatement statement = connection.prepareStatement("insert into usuarios values(?,?,?,?,?,?,?)");
            statement.setString(1, user.mail);
            statement.setString(2, user.password);
            statement.setString(3, user.nombre);
            statement.setString(4, user.apellido);
            statement.setInt(5, user.valoracion);
            statement.setBoolean(6, user.conductor);
            statement.setString(7, user.vehiculo);
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
