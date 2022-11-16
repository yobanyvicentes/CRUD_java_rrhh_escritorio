/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bd.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.*;

/**
 *
 * @author YOBANY
 */
public class EstadoCivilDaoImp implements EstadoCivilDao{
    
    private Conexion conexion = new Conexion();
    private Statement st;
    private ResultSet rS;
    private String sql = "SELECT * FROM estados_civiles";
    
    @Override
    public List<EstadoCivil> findAll() {
        
        List<EstadoCivil> estadoscivilesId = new ArrayList<>();
        
        try {            
            st = conexion.getCon().createStatement();
            rS = st.executeQuery(sql);
            
            while (rS.next()) {   
                EstadoCivil modeloEC = new EstadoCivil();
                modeloEC.setId(rS.getInt("id"));
                modeloEC.setNombre(rS.getString("nombre"));
                modeloEC.setDescripcion(rS.getString("descripcion"));
                
                estadoscivilesId.add(modeloEC);
            }
            
            rS.close();
            st.close();
            conexion.getCon().close();
                 
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        return estadoscivilesId;
    }
    
}
