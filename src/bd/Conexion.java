package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import javax.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YOBANY
 */
public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3308/mydb?serverTimezone=America/Bogota";
    private static final String USER = "root";
    private static final String PASSWORD= "Tecnologia2022*";
    
    private Connection con;
    
    public Conexion() {
        try {
            con = DriverManager.getConnection(URL,USER, PASSWORD);
            con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Connection getCon() {
        return con;
    }

}
