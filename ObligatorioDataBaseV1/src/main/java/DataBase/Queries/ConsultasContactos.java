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
 * @author Faivel
 */
public class ConsultasContactos {
    
    public ConsultasContactos() {
    
    }
    
    public boolean insertar(String mail_self, String mail_contact) {
        Connection connection = ConnectionManager.getConnection();
        try {

            PreparedStatement statement = connection.prepareStatement("insert into contactos values(?,?)");
            statement.setString(1, mail_self);
            statement.setString(2, mail_contact);
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
