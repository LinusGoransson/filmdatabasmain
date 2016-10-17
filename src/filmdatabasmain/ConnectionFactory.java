/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmdatabasmain;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author linusgoransson
 */
public class ConnectionFactory {
    public static Connection getConnection() throws SQLException{
        String url = "jdbc:mysql://localhost/filmdatabas";
        String username = "root";
        String password = "";
        
        Connection connection = (com.mysql.jdbc.Connection)DriverManager.getConnection(url, username, password);
        return connection;
    }
}
