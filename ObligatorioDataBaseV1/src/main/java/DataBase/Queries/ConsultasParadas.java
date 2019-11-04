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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

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
     
     public List<Map<String, String>> paradasByViajeId(int viaje){
         Connection connection = ConnectionManager.getConnection();
         List<Map<String, String>> result = new LinkedList<>();
         try {
             PreparedStatement statement = connection.prepareStatement("select "
                     + "x.parada, x.solicitante, x.viaje, x.estado_persona, x.estado_parada, u.calle, u.nro_puerta, y.hora\n"
                     + "from participaciones x \n"
                     + "join paradas y on y.num_parada = x.parada\n"
                     + "join ubicaciones u on y.ubicacion=u.id_ubicacion\n"
                     + "where x.viaje=?");
             statement.setInt(1, viaje);

             ResultSet rs = statement.executeQuery();
             while (rs.next()) {

                 Map<String, String> aux = new HashMap<>();
                 aux.put("parada", Integer.toString(rs.getInt("parada")));
                 aux.put("solicitante", rs.getString("solicitante"));
                 aux.put("viaje", Integer.toString(rs.getInt("viaje")));
                 aux.put("estado_persona", Integer.toString(rs.getInt("estado_persona")));
                 aux.put("estado_parada", Integer.toString(rs.getInt("estado_parada")));
                 aux.put("calle", rs.getString("calle"));
                 aux.put("nro_puerta", Integer.toString(rs.getInt("nro_puerta")));
                 aux.put("hora", rs.getString("hora"));
                 
             }
              rs.close();
            statement.close();
             return result;
         } catch (SQLException ex) {
             System.out.println("Error: " + ex);
             return result;
         }finally {
            ConnectionManager.closeConnection(connection);
        }
     }
    
    
}
