/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase.Queries;

import Data.Classes.Participacion;
import Data.Classes.Valoracion;
import Data.Classes.Viaje;
import DataBase.Connection.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class ConsultasParticipaciones {

    public boolean insertar(Participacion participacion) {
        Connection connection = ConnectionManager.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "insert into participaciones(parada, solicitante, viaje, estado)"
                    + "VALUES (?, ?, ?, ?)");
            statement.setInt(1, participacion.parada);
            statement.setString(2, participacion.solicitante);
            statement.setInt(3, participacion.viaje);
            statement.setInt(4, participacion.estado);
          
            statement.executeUpdate();
            return true;

        } catch (SQLException sqle) {
            System.out.println("Error: " + sqle);
            return false;
        } finally {
            ConnectionManager.closeConnection(connection);
        }
    }
    
    //UPDATE ESTADO (Cambia el estado al parametro recibido, no a un estado específico)
    public boolean updateEstadoParticipacion(String solicitante, int parada, int nuevo_estado, int viaje) {
        Connection connection = ConnectionManager.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE participaciones SET estado=?" +
                    "WHERE solicitante='"+solicitante+"' and viaje="+viaje+" and parada="+parada);
            statement.setInt(1, nuevo_estado);
            statement.executeUpdate();
            return true;

        } catch (SQLException sqle) {
            System.out.println("Error: " + sqle);
            return false;
        } finally {
            ConnectionManager.closeConnection(connection);
        }
    }
    
    /*//UPDATE PARADA (Cambia el estado al parametro recibido, no a un estado específico)
    public boolean updateParadaEnParticipacion(String solicitante, int parada, int nuevo_estado) {
        Connection connection = ConnectionManager.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE public.participaciones SET estado_parada=?" +
                    "WHERE (solicitante='"+solicitante+"' and parada='"+parada+"');");
            statement.setInt(1, nuevo_estado);
            statement.executeUpdate();
            return true;
v
        } catch (SQLException sqle) {
            System.out.println("Error: " + sqle);
            return false;
        } finally {
            ConnectionManager.closeConnection(connection);
        }
    }*/
    
    
    public List<Participacion> getParticipacionesUsuario(String userMail) {
        Connection connection = ConnectionManager.getConnection();
        ArrayList<Participacion> participaciones = new ArrayList<>();
        try {

            PreparedStatement statement = connection.prepareStatement("select distinct part.parada as parada, part.solicitante as mail_soli, part.estado as estado, v.id_viaje as viajeid, v.conductor as conductor, u.calle as calle, u.nro_puerta as numero\n" +
                "from participaciones part\n" +
                "join paradas para on part.parada = para.num_parada\n" +
                "join ubicaciones u on para.ubicacion = u.id_ubicacion\n" +
                "join viajes v on v.id_viaje = part.viaje\n" +
                "where v.estado != -1 and part.solicitante = ? and v.conductor != ?");
            statement.setString(1, userMail);
            statement.setString(2, userMail);
            
            ResultSet rs = statement.executeQuery();
            while ( rs.next() )
            {
                participaciones.add(new Participacion(rs.getInt("parada"), rs.getString("mail_soli"), rs.getInt("viajeid"), rs.getInt("estado")));
                participaciones.get(participaciones.size()-1).setUbicacion(rs.getString("calle"), rs.getInt("numero"));
                participaciones.get(participaciones.size()-1).setConductor(rs.getString("conductor"));
            }
            
            rs.close();
            statement.close();

            return participaciones;

        } catch (SQLException sqle) {
            System.out.println("Error: " + sqle);
            return null;
        } finally {
            ConnectionManager.closeConnection(connection);
        }
    }
    
    public List<Participacion> getSolicitudesAMisViajes(String userMail) {
        Connection connection = ConnectionManager.getConnection();
        ArrayList<Participacion> participaciones = new ArrayList<>();
        try {

            PreparedStatement statement = connection.prepareStatement("select distinct part.parada as parada, part.solicitante as mail_soli, part.estado as estado, v.id_viaje as viajeid, v.conductor as conductor, u.calle as calle, u.nro_puerta as numero\n" +
                "from participaciones part\n" +
                "join paradas para on part.parada = para.num_parada\n" +
                "join ubicaciones u on para.ubicacion = u.id_ubicacion\n" +
                "join viajes v on v.id_viaje = part.viaje\n" +
                "where part.estado = 0 and v.conductor = ?");
            statement.setString(1, userMail);
            
            ResultSet rs = statement.executeQuery();
            while ( rs.next() )
            {
                participaciones.add(new Participacion(rs.getInt("parada"), rs.getString("mail_soli"), rs.getInt("viajeid"), rs.getInt("estado")));
                participaciones.get(participaciones.size()-1).setUbicacion(rs.getString("calle"), rs.getInt("numero"));
                participaciones.get(participaciones.size()-1).setConductor(rs.getString("conductor"));
            }
            
            rs.close();
            statement.close();

            return participaciones;

        } catch (SQLException sqle) {
            System.out.println("Error: " + sqle);
            return null;
        } finally {
            ConnectionManager.closeConnection(connection);
        }
    }
    
}
