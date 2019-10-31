/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase.Queries;

import Data.Classes.Participacion;
import Data.Classes.Valoracion;
import DataBase.Connection.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class ConsultasParticipaciones {

    public boolean insertar(Participacion participacion) {
        Connection connection = ConnectionManager.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "insert into participaciones(parada, solicitante, viaje, estado_persona, estado_parada)"
                    + "VALUES (?, ?, ?, ?, ?)");
            statement.setInt(1, participacion.parada);
            statement.setString(2, participacion.solicitante);
            statement.setInt(3, participacion.viaje);
            statement.setInt(4, participacion.estado_persona);
            statement.setInt(5, participacion.estado_parada);
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
