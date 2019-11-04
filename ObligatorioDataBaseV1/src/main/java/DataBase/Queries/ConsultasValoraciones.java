/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase.Queries;

import Data.Classes.Valoracion;
import DataBase.Connection.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author USER
 */
public class ConsultasValoraciones {

    public boolean insertar(Valoracion valoracion) {
        Connection connection = ConnectionManager.getConnection();
        try {

            PreparedStatement statement = connection.prepareStatement(
                    "insert into valoraciones(calificador, calificado, calificacion, observaciones)"
                    + " values(?,?,?,?)");
            statement.setString(1, valoracion.calificador);
            statement.setString(2, valoracion.calificado);
            statement.setInt(3, valoracion.calificacion);
            statement.setString(4, valoracion.observaciones);
            statement.executeUpdate();
//            ResultSet keys = statement.getGeneratedKeys();
//            keys.next();
            return true;

        } catch (SQLException sqle) {
            System.out.println("Error: " + sqle);
            return false;
        } finally {
            ConnectionManager.closeConnection(connection);
        }
    }

    public List<Map<String, String>> valoracionPromedio(String usuario) {
        Connection connection = ConnectionManager.getConnection();
        List<Map<String, String>> result = new LinkedList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from valoraciones where calificado = ?");
            statement.setString(1, usuario);
            ResultSet rs = statement.executeQuery();
            int aux1 = 0;
            int i = 0;
            while (rs.next()) {

                Map<String, String> aux = new HashMap<>();
                aux.put("calificado", rs.getString("calificado"));
                aux.put("calificador", rs.getString("calificador"));
                aux.put("calificacion", Integer.toString(rs.getInt("calificacion")));
                aux.put("observaciones", rs.getString("observaciones"));
                result.add(aux);
                aux1 += rs.getInt("calificacion");
                i++;
            }
            Map<String, String> aux2 = new HashMap<>();
            aux2.put("promedio", Integer.toString(aux1 / i));
            result.add(aux2);
            rs.close();
            statement.close();

            PreparedStatement statement2 = connection.prepareStatement("Update usuarios set valoracionPropmedio =? where mail=?");
            statement.setInt(1, aux1 / i);
            statement.setString(2, usuario);

            return result;
        } catch (SQLException sqle) {
            System.out.println("Error: " + sqle);
            return null;
        } finally {
            ConnectionManager.closeConnection(connection);
        }
    }

}
