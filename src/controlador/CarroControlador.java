/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Carro;

/**
 *
 * @author Ismael
 */
public class CarroControlador {
    Conexion con = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    Statement sentencia;
    
    Carro carro = new Carro();

    public CarroControlador() {
        
        con.getConector();
    }
    
    
    public void crearCarro (Carro c){
        try {
            String sql = "INSERT INTO Carro (id, marca, anio, color)"
                    + "VALUES ( "
                    +c.getId() + ",'"
                    +c.getMarca() + "','"
                    +c.getAnio() + "','"
                    +c.getColor() + "','"
                    +"');";
            
            sentencia= con.getConector().createStatement();
            
            if (sentencia.executeUpdate(sql) > 0) {
                System.out.println("El registro se inserto correctamente");
    
            }
            else{
            
                System.out.println("No se pudo insertar el registro");
            
            }
                           
        } catch (SQLException e) {
            
            System.out.println("Error" + " " + e);
        }
        
        System.out.println(c.toString());
        con.cerrar();
    
    }
    
    
}
