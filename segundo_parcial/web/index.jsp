<%-- 
    Document   : index
    Created on : 20/09/2021, 19:55:09
    Author     : justo
--%>

<%@page import="Modelo.Producto"  %>
<%@page import="Modelo.Marca"  %>
<%@page  import="javax.swing.table.DefaultTableModel"%>
<%@page  import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Parcial II</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
      
        
    </head>
    <body>
        <style>
            #btn_agregar,boton{ 
                text-decoration: none !important;
                background: none;
                color: #4d2e0c;
                padding: 23px 35px 24px 35px !important;
                border-radius: 5px;
                font-size: 16px;
                text-transform: uppercase;
                border: 1px solid !important;
                width: 40%;
                margin: 0 auto;
                margin-top: 1%;
                font-weight: bold;
                margin-bottom: 5%;
                background-position: 100% 0;
                background-size: 200% 100%;
                transition: all .25s ease-in;
            }
            #btn_agregar:hover,boton:hover{
                background-position: 0 0;
                background-image: linear-gradient(to left, transparent, transparent 50%, #efab3c 50%, #efab3c);
                color: #fff;
                border: 1px solid !important;
            }
            .titulo{
                text-align: center;
                margin-top: 5%;
                margin-bottom: 3%;
                box-shadow: 0px 7px 12px -9px #222;
                padding: 0 0 29px 0;
            }
            
            .identificacion{
                margin-top:1%;
                text-align:right;
                font-weight:bold;
                padding:0 30px;
            }
            
            input,select{
                border: 1px solid #cacaca !important;
                border-radius: 6px !important;
                padding: 20px 25px !important;
                margin: 0 auto !important;
                width: 88% !important;
                resize: none !important;
            }
            input::placeholder{
                color: #292019 !important;
            }
            label{
                font-weight: bold;
                color: #292019;
                font-size: 20px;
                padding: 0 0 0 34px;
            }
            .form-group{
                margin: 15px 0 !important;
            }
            .tabla-productos thead{
                background: #efab3c;
                color: #fff;
            }
            .tabla-productos thead th{
                padding: 2% !important;
                text-align: center !important;
                border: none !important;
            }
            .tabla-productos tbody{
                border: none !important;
                background: none !important;
            }
            .tabla-productos tbody tr{
                border: none !important;
                background: none !important;
            }
            .tabla-productos tbody tr td{
                vertical-align: middle !important;
                text-align: center !important;
                padding: 5% 65px !important;
                color: #4d2e0c !important;
                box-shadow: none;
                border: 1px solid !important;
            }
        </style>
        <h1 class="titulo">Ingreso Productos</h1>
        <p class="identificacion">Justo David Caceres Ortiz 1290-18-18024</p>
           
        <div class="container">
            <form action="sr_producto" method="post" class="form-group row">
                 <br>
                <div class="form-group col-lg-6 col-md-6 col-sm-12 col-xs-12">
                    <label for="lbl_producto">Producto</label>
                    <input type="text" name="txt_producto" id="txt_producto" class="form-control" placeholder="Ejemplo: Computadora DELL" required>
                </div>
                 <div class="form-group col-lg-6 col-md-6 col-sm-12 col-xs-12">
                    <label for="lbl_marca">Marca</label>
                    <select name="txt_marca" id="txt_marca" class="form-control">
                        <%
                        Marca marca = new Marca();
                        HashMap<String,String> drop = marca.drop_marca();
                        for(String i: drop.keySet()){
                            out.println("<option value='"+i+"'>"+ drop.get(i)+"</option>");

                            }
                        %>      
                    </select>
                </div>
                <div class="form-group col-lg-6 col-md-6 col-sm-12 col-xs-12">
                    <label for="lbl_descripcion">Descripcion</label>
                    <input type="text" name="txt_descripcion" id="txt_descripcion" class="form-control" placeholder="Ejemplo: Protatil de 3,4 pulgadas" required>
                </div>
                <div class="form-group col-lg-6 col-md-6 col-sm-12 col-xs-12">
                    <label for="lbl_pcosto">Precio Costo</label>
                    <input type="number" name="txt_pcosto" id="txt_pcosto" class="form-control" placeholder="Ejemplo: 300" required>
                </div>
                <div class="form-group col-lg-6 col-md-6 col-sm-12 col-xs-12">
                    <label for="lbl_pventa">Precio Venta</label>
                    <input type="number" name="txt_pventa" id="txt_pventa" class="form-control" placeholder="Ejemplo: 680" required>
                </div>
                <div class="form-group col-lg-6 col-md-6 col-sm-12 col-xs-12">
                    <label for="lbl_existencia">Existencia</label>
                    <input type="number" name="txt_existencia" id="txt_existencia" class="form-control" placeholder="Ejemplo: 60" required>
                </div>
                <br/>
                <br/>
                <button name="btn_agregar" id="btn_agregar" value="agregar" class="btn btn-outline-primary">Agregar</button>
                
                
            </form>
    <table class="table table-striped tabla-productos">
    <thead>
      <tr>
        <th>Producto</th>
        <th>Marca</th>
        <th>Descripcion</th>
        <th>Precio Costo</th>
        <th>Precio Venta</th>
        <th>Existencia</th>
        
      </tr>
    </thead>
    <tbody id="tbl_productos">
        <%
            Producto producto=new Producto();
            DefaultTableModel tabla = new DefaultTableModel();
            tabla=producto.leer(); 
            for(int t=0; t<tabla.getRowCount();t++){
                out.println("<tr data-id="+ tabla.getValueAt(t, 0) + " data-id_m="+ tabla.getValueAt(t, 2)+">");
                out.println("<td>"+ tabla.getValueAt(t, 1)+"</td>");
                out.println("<td>"+ tabla.getValueAt(t, 3)+"</td>");
                out.println("<td>"+ tabla.getValueAt(t, 4)+"</td>");
                out.println("<td>"+ tabla.getValueAt(t, 5)+"</td>");
                out.println("<td>"+ tabla.getValueAt(t, 6)+"</td>");
                out.println("<td>"+ tabla.getValueAt(t, 7)+"</td>");
                
                out.println("</tr>");
            }
        
        %>
      
    </tbody>
  </table>
        </div>    
            
        </h1>
        
        
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    
    </body>
</html>
