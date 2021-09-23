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
import javax.swing.table.DefaultTableModel;
import Modelo.Marca;
/**
 *
 * @author justo
 */
public class Producto extends Marca {
     private String producto,descripcion;
    private int id_producto,precio_costo,precio_venta,existencia,id_marca;
    private Conexion cn;
    
    public Producto() {
       
    }

    public Producto(String producto, String descripcion, int id_producto, int precio_costo, int precio_venta, int existencia, int id_marca/*, int id*/) {
        //super(id);
        this.producto = producto;
        this.descripcion = descripcion;
        this.id_producto = id_producto;
        this.precio_costo = precio_costo;
        this.precio_venta = precio_venta;
        this.existencia = existencia;
        this.id_marca=id_marca;
    }
    
   

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getPrecio_costo() {
        return precio_costo;
    }

    public void setPrecio_costo(int precio_costo) {
        this.precio_costo = precio_costo;
    }

    public int getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(int precio_venta) {
        this.precio_venta = precio_venta;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }
    
    public int getId_marca() {
        return existencia;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }
    
    /**
     *
     * @return
     */
  
     @Override
    public void agregar(){

        try{
            PreparedStatement parametro;
            cn=new Conexion ();
             String query="INSERT INTO db_empresa.producto(producto,id_marcas,descripcion,precio_costo,precio_venta,existencia)VALUES(?,?,?,?,?,?);";
              cn.abrir_conexion();
              parametro=(PreparedStatement)cn.conexionBD.prepareStatement(query);
              parametro.setString(1, getProducto());
              parametro.setInt(2, getId_marca());
              parametro.setString(3, getDescripcion());
              parametro.setInt(4, getPrecio_costo());
              parametro.setInt(5, getPrecio_venta());
              parametro.setInt(6, getExistencia());
          
              cn.cerrar_conexion();
        }catch(SQLException ex){
                System.out.println(ex.getMessage());
               
            }
     
    } 
    
    public DefaultTableModel leer(){
        DefaultTableModel tabla = new DefaultTableModel();
        try{
            cn=new Conexion();
            cn.abrir_conexion();
            String query="SELECT p.id_producto as id, p.producto, m.id_marca,m.marca, p.descripcion, p.precio_costo, p.precio_venta, p.existencia FROM productos as p inner join marcas as m on p.id_marca = m.id_marca;";
            ResultSet consulta=cn.conexionBD.createStatement().executeQuery(query);
            String encabezado[]={"ID","Producto","ID Marca","Marca","Descripcion","Precio Costo","Precio Venta","Existencias" };
            tabla.setColumnIdentifiers(encabezado);
            String datos[]= new String [8];
            while(consulta.next()){
            datos[0] = consulta.getString("id");
            datos[1] = consulta.getString("producto");
            datos[2] = consulta.getString("id_marca");
            datos[3] = consulta.getString("marca");
            datos[4] = consulta.getString("descripcion");
            datos[5] = consulta.getString("precio_costo");
            datos[6] = consulta.getString("precio_venta");
            datos[7] = consulta.getString("existencia");
            tabla.addRow(datos);
            }
            
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return tabla;
    }
}
