package br.com.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class ConnectionFactory {
	
	private final String url    = "jdbc:mysql://localhost:3306/dbexample";
    private final String user   = "root";
    private final String pass   = "";
    private final String driver = "com.mysql.jdbc.Driver";
    
    Connection connection;
    public Statement stm;
    public ResultSet rs;
    
    public Connection getConnection(){
    	try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException Driver) {
            JOptionPane.showMessageDialog(null, "Erro de driver " + Driver);
        } catch(SQLException Fonte){
            JOptionPane.showMessageDialog(null, "Erro ao localizar o BD " + Fonte);            
        }
        return connection;
    }
}
