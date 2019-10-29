/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase.Queries;


 import DataBase.Connection.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author USER
 */
public class ConsultasUsuarios {

    public boolean insertarUsuario(String mail, String pass, String nombre, String apellido, boolean conductor, String vehiculo) {
        Connection connection = ConnectionManager.getConnection();
        try {

            PreparedStatement statement = connection.prepareStatement("insert into usuarios values(?,?,?,?,?,?,?)");
            statement.setString(1, mail);
            statement.setString(2, pass);
            statement.setString(3, nombre);
            statement.setString(4, apellido);
            statement.setInt(5, 0);
            statement.setBoolean(6, conductor);
            statement.setString(7, vehiculo);
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
