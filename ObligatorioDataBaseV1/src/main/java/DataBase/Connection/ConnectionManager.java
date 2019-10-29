/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase.Connection;

import java.sql.*;
/**
 *
 * @author USER
 */
public class ConnectionManager {
    private final static String DRIVER = "jdbc:postgresql://";
    private final static String HOST = "ec2-184-73-192-251.compute-1.amazonaws.com";
    private final static String PORT = "5432";
    private final static String NAME = "ddi1901j5ivsin";
    private final static String USER = "svmgkongeowcya";
    private final static String PASS = "fb7f6b3d9a02fe96ae1eb2c757e3753ca4b3b2b712175c6ace6cc88da3e64751";
    
    public static Connection getConnection (){
        String url = DRIVER + HOST + ":" + PORT+ "/" + NAME;
        try {
            return DriverManager.getConnection(url,USER,PASS);
        } catch(SQLException sqle){
            throw new RuntimeException("Error",sqle);
        }
    }
    public static void closeConnection (Connection con){
        try{
            con.close();
        }catch(SQLException sqle){
            throw new RuntimeException("Error",sqle);
        }
    }
}
