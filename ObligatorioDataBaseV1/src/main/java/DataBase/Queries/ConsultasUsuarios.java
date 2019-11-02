/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase.Queries;


import Data.Classes.Grupo;
import Data.Classes.Usuario;
import DataBase.Connection.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
                        rs.getString("vehiculo"),
                        Integer.parseInt(rs.getString("estado"))));
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
    
    public List<String> getUserContacts(String user_mail) {
        Connection connection = ConnectionManager.getConnection();
        ArrayList<String> users = new ArrayList<String>();
        try {

            PreparedStatement statement = connection.prepareStatement("Select usuario2 from contactos Where usuario1=?");
            statement.setString(1, user_mail);
            
            ResultSet rs = statement.executeQuery();
            while ( rs.next() )
            {
                users.add(rs.getString("usuario2"));
            }
            
            rs.close();
            statement.close();

            return users;

        } catch (SQLException sqle) {
            System.out.println("Error: " + sqle);
            return null;
        } finally {
            ConnectionManager.closeConnection(connection);
        }
    }
    
    public boolean cambiarEstado(String usuario, int estado){
         Connection connection = ConnectionManager.getConnection();
          try {

            PreparedStatement statement = connection.prepareStatement("update usuarios set estado=? where usuario=?");
            statement.setInt(1, estado);
            statement.setString(2,usuario);
            statement.executeQuery();
           
            
            statement.close();

            return true;

        } catch (SQLException sqle) {
            System.out.println("Error: " + sqle);
            return false;
        } finally {
            ConnectionManager.closeConnection(connection);
        }
    }
    
    public List<Integer> getUserGroups(String user_mail) {
        Connection connection = ConnectionManager.getConnection();
        ArrayList<Integer> grupos = new ArrayList<Integer>();
        try {

            PreparedStatement statement = connection.prepareStatement("Select grupo from grupo_usuario Where usuario=?");
            statement.setString(1, user_mail);
            
            ResultSet rs = statement.executeQuery();
            while ( rs.next() )
            {
                grupos.add(rs.getInt("grupo"));
            }
            
            rs.close();
            statement.close();

            return grupos;

        } catch (SQLException sqle) {
            System.out.println("Error: " + sqle);
            return null;
        } finally {
            ConnectionManager.closeConnection(connection);
        }
    }
}
