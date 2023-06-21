package dao;

import bd.Conexion;
import java.util.*;
import javax.swing.*;
import models.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.*;

public class FuncionarioDaoImp implements FuncionarioDao {

    private final Conexion conexion = new Conexion();
    private Statement st;
    private ResultSet rS;
    private final String sqlfindall = "SELECT * FROM funcionarios";

//FINDALL
    @Override
    public List<Funcionario> findall() {
        List<Funcionario> funcionarios = new ArrayList<>();

        try {
            st = conexion.getCon().createStatement();
            rS = st.executeQuery(sqlfindall);

            while (rS.next()) {
                Funcionario modeloFuncionario = new Funcionario();
                modeloFuncionario.setId(rS.getInt("id"));
                modeloFuncionario.setNumId(rS.getString("num_id"));
                modeloFuncionario.setNombres(rS.getString("nombres"));
                modeloFuncionario.setApellidos(rS.getString("apellidos"));
                modeloFuncionario.setSexo(rS.getString("sexo"));
                modeloFuncionario.setDireccion(rS.getString("direccion"));
                modeloFuncionario.setTelefono(rS.getString("telefono"));
                modeloFuncionario.setFechaNacimiento(rS.getDate("fecha_nacimiento"));
                modeloFuncionario.setTipoDocumento(rS.getInt("tipos_documentos_id"));
                modeloFuncionario.setTipoDocumento(rS.getInt("estados_civiles_id"));

                funcionarios.add(modeloFuncionario);
                System.out.println(modeloFuncionario.getNombres()+1);
            }
            System.out.println(funcionarios.get(1).getApellidos()+8);
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return funcionarios;
    }
    
    
    
    
    //FINDBYDOC

    @Override
    public Funcionario findByDoc(String document) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
//GUARDAR
    private PreparedStatement sentencia;
    private String sqlguardar = "INSERT INTO funcionarios(num_id, nombres, apellidos, sexo, direccion, telefono,fecha_nacimiento,tipos_documentos_id,estados_civiles_id)"
            + "VALUES(?,?,?,?,?,?,?,?,?)";
    @Override
    public boolean guardar(Funcionario funcionario) {
        try {
            sentencia = conexion.getCon().prepareStatement(sqlguardar);
            sentencia.setString(1, funcionario.getNumId());
            sentencia.setString(2, funcionario.getNombres());
            sentencia.setString(3, funcionario.getApellidos());
            sentencia.setString(4, funcionario.getSexo());
            sentencia.setString(5, funcionario.getDireccion());
            sentencia.setString(6, funcionario.getTelefono());
            sentencia.setDate(7, funcionario.getFechaNacimiento());
            sentencia.setInt(8, funcionario.getTipoDocumento());
            sentencia.setInt(9, funcionario.getEstadoCivil());
            sentencia.executeUpdate();
            System.out.println(sqlguardar);

        } catch (SQLException ex) {
            System.out.println("No se ha podido crear el funcionario");
            return false;
        }
        return true;
    }
 
    
    
//    UPDATE funcionarios SET nombres= ?, apellidos= ?, sexo= ?, " "direccion= ?, telefono= ?, fecha_nacimiento= ?, tipos_documentos_id= ?, estados_civiles_id= ? "            + "WHERE num_id= ?
//ACTUALIZAR  
    private String sqlActualizar = "update funcionarios set nombres=?, apellidos=?, sexo=?, direccion=?, telefono=?, fecha_nacimiento=?, tipos_documentos_id=?, estados_civiles_id=? WHERE num_id=?";
    private PreparedStatement docSQLactualizar;
    @Override
    public boolean actualizar(Funcionario funcionario) {
        try {
            docSQLactualizar = conexion.getCon().prepareStatement(sqlActualizar);
            
            System.out.println(sqlActualizar);
            System.out.println(funcionario);
            
            docSQLactualizar.setString(1, funcionario.getNombres());
            docSQLactualizar.setString(2, funcionario.getApellidos());
            docSQLactualizar.setString(3, funcionario.getSexo());
            docSQLactualizar.setString(4, funcionario.getDireccion());
            docSQLactualizar.setString(5, funcionario.getTelefono());
            docSQLactualizar.setDate(6, funcionario.getFechaNacimiento());
            docSQLactualizar.setInt(7, funcionario.getTipoDocumento());
            docSQLactualizar.setInt(8, funcionario.getEstadoCivil());
            docSQLactualizar.setString(9, funcionario.getNumId());
            System.out.println(sqlActualizar);
            docSQLactualizar.executeUpdate();
            System.out.println("3");
            
        } catch (SQLException ex) {
            System.out.println(ex.toString()); 
            return false;
        }
        return true;
    }

    
    
    
//BORRRAR
    String sqlDelete = "DELETE FROM funcionarios WHERE num_id=?";
    PreparedStatement docSQLdelete;
    
    @Override
    public void borrar(String document) {
        conexion.getCon();
        try {
            docSQLdelete = conexion.getCon().prepareStatement(sqlDelete);
            docSQLdelete.setString(1, document);
            docSQLdelete.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    


//EDITAR    
    String sqlEdit = "SELECT * FROM funcionarios WHERE num_id=?";
    PreparedStatement docSQLedit;
    ResultSet resultadoEdit;

    @Override
    public Funcionario editar(String document) {
        conexion.getCon();
        Funcionario modeloFuncionario = new Funcionario();
        try {
            docSQLedit = conexion.getCon().prepareStatement(sqlEdit);
            docSQLedit.setString(1, document);
            resultadoEdit = docSQLedit.executeQuery();

            while (resultadoEdit.next()) {
                modeloFuncionario.setNumId(resultadoEdit.getString("num_id"));
                modeloFuncionario.setNombres(resultadoEdit.getString("nombres"));
                modeloFuncionario.setApellidos(resultadoEdit.getString("apellidos"));
                modeloFuncionario.setSexo(resultadoEdit.getString("sexo"));
                modeloFuncionario.setDireccion(resultadoEdit.getString("direccion"));
                modeloFuncionario.setTelefono(resultadoEdit.getString("telefono"));
                modeloFuncionario.setFechaNacimiento(resultadoEdit.getDate("fecha_nacimiento"));
                modeloFuncionario.setTipoDocumento(resultadoEdit.getInt("tipos_documentos_id"));
                modeloFuncionario.setEstadoCivil(resultadoEdit.getInt("estados_civiles_id"));

                System.out.println("dao.FuncionarioDaoImp.editar()");
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return modeloFuncionario;
    }

}
