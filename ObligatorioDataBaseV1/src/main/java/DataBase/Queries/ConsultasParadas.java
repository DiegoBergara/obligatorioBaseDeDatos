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
import java.sql.Time;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

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
            parada.setIdParada(id);
            return id;

        } catch (SQLException sqle) {
            System.out.println("Error: " + sqle);
            return -1;
        } finally {
            ConnectionManager.closeConnection(connection);
        }
    }
     
     public Parada buscarParada(int ubic, Time hora){
        Connection connection = ConnectionManager.getConnection();
        List<Parada> paradas = new LinkedList<Parada>();
        try {

            PreparedStatement statement = connection.prepareStatement("Select * from paradas Where ubicacion=? and hora=?");
            statement.setInt(1, ubic);
            statement.setTime(2, hora);
            
            ResultSet rs = statement.executeQuery();
            while ( rs.next() )
            {
                paradas.add(new Parada(rs.getInt("ubicacion"),
                        rs.getTime("hora")));
                paradas.get(paradas.size()-1).setIdParada(rs.getInt("num_parada"));
            }
            
            rs.close();
            statement.close();
            if(paradas.size() == 1){
                return paradas.get(0);
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
