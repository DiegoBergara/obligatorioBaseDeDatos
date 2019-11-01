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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
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

            PreparedStatement statement = connection.prepareStatement("insert into usuarios values(?,?,?,?,?,?,?,?)");
            statement.setString(1, user.mail);
            statement.setString(2, user.password);
            statement.setString(3, user.nombre);
            statement.setString(4, user.apellido);
            statement.setInt(5, user.valoracion);
            statement.setBoolean(6, user.conductor);
            statement.setString(7, user.vehiculo);
            statement.setInt(8, 1);
            statement.executeUpdate();

            return true;

        } catch (SQLException sqle) {
            System.out.println("Error: " + sqle);
            return false;
        } finally {
            ConnectionManager.closeConnection(connection);
        }
    }
    
    public Usuario getUser(String mail, String pass) {
        Connection connection = ConnectionManager.getConnection();
        List<Usuario> users = new LinkedList<Usuario>();
        try {

            PreparedStatement statement = connection.prepareStatement("Select * from usuarios Where mail=? and contraseña=?");
            statement.setString(1, mail);
            statement.setString(2, pass);
            
            ResultSet rs = statement.executeQuery();
            while ( rs.next() )
            {
                users.add(new Usuario(rs.getString("mail"),
                        rs.getString("contraseña"),
                        rs.getString("nombre"), 
                        rs.getString("apellido"), 
                        rs.getBoolean("esConductor"),
                        rs.getString("vehiculo")));
            }
            
            rs.close();
            statement.close();
            if(users.size() == 1){
                return users.get(0);
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
