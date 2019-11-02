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
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author USER
 */
public class ConsultasRutas {
    
     public RutaRaw insertar(RutaRaw ruta) {
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
            return ruta;

        } catch (SQLException sqle) {
            System.out.println("Error: " + sqle);
            return null;
        } finally {
            ConnectionManager.closeConnection(connection);
        }
    }
    
     public RutaRaw buscarRuta(int origen, int destino){
        Connection connection = ConnectionManager.getConnection();
        List<RutaRaw> rutas = new LinkedList<RutaRaw>();
        try {

            PreparedStatement statement = connection.prepareStatement("Select * from rutas Where origen=? and destino=?");
            statement.setInt(1, origen);
            statement.setInt(2, destino);
            
            ResultSet rs = statement.executeQuery();
            while ( rs.next() )
            {
                rutas.add(new RutaRaw(rs.getInt("origen"),
                        rs.getInt("destino")));
                rutas.get(rutas.size()-1).setIdRuta(rs.getInt("id_ruta"));
            }
            
            rs.close();
            statement.close();
            if(rutas.size() == 1){
                return rutas.get(0);
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
