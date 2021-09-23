/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.sql.PreparedStatement;
/**
 * 
 * @author justo
 */
public class Marca{
    private int id;
    private Conexion cn;
    
    public Marca(){}
    public Marca(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public HashMap drop_marca(){
        HashMap<String,String>drop = new HashMap();
        try{
            cn=new Conexion();
            String query="SELECT id_marca as id,marca FROM marcas;";
            cn.abrir_conexion();
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            while(consulta.next()){
                drop.put(consulta.getString("id"), consulta.getString("marca"));
            }
            
            cn.cerrar_conexion();
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }

        return drop;
    }
    
    public void agregar(){}
    public void mostrar(){}
    public void modificar(){}
    public void eliminar(){}
}
