/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase.Queries;

import Data.Classes.Grupo;
import Data.Classes.RutaRaw;
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
public class ConsultasGrupos {
    
    public ConsultasGrupos() {
    
    }
    
    public int insertar(Grupo group) {
        Connection connection = ConnectionManager.getConnection();
        try {

            PreparedStatement statement = connection.prepareStatement("insert into grupos(nombre, privado, admin)"
                    + " values(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, group.name);
            statement.setBoolean(2, group.priavate);
            statement.setString(3, group.admin);
            statement.executeUpdate();
            ResultSet keys = statement.getGeneratedKeys();
            keys.next();
            int id = keys.getInt(1); 
            group.setIdGroup(id);
            
            PreparedStatement statement2 = connection.prepareStatement("insert into grupo_usuario"
                    + " values(?,?)", Statement.RETURN_GENERATED_KEYS);
            statement2.setInt(1, id);
            statement2.setString(2, group.admin);
            statement2.executeUpdate();

            return id;

        } catch (SQLException sqle) {
            System.out.println("Error: " + sqle);
            return -1;
        } finally {
            ConnectionManager.closeConnection(connection);
        }
    }
}
