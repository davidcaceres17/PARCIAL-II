/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author justo
 */
public class Conexion {
    public Connection conexionBD;
    public final String bd = "bd_empresa";
    public final String urlConexion = String.format("jdbc:mysql://localhost:3306/%s",bd);
    public final String usuario = "root";
    public final String contra = "12345678";
    public final String jdbc = "com.mysql.cj.jdbc.Driver";
    
    public void abrir_conexion (){
    try{
    Class.forName(jdbc);
    conexionBD = DriverManager.getConnection(urlConexion,usuario,contra);

    
    }catch(HeadlessException | ClassNotFoundException | SQLException ex){
    System.out.println("Error " + ex.getMessage());
    }
    }
    public void cerrar_conexion (){
    try{
        conexionBD.close();
    }catch(SQLException ex){
         System.out.println("Error " + ex.getMessage());
    }
    } 
}
