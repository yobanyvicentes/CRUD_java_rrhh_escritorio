package dao;

import bd.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.TipoDocumento;

/**
 *
 * @author YOBANY
 */
public class TipoDocumentoDaoImp implements TipoDocumentoDao{
    
    private Conexion conexion = new Conexion();
    private Statement st;
    private ResultSet rS;
    private String sql = "SELECT * FROM tipos_documentos;";

    @Override
    public List<TipoDocumento> findAll() {
        List<TipoDocumento> tiposId = new ArrayList<>();
      
        try {            
            st = conexion.getCon().createStatement();
            rS = st.executeQuery(sql);
            
            while (rS.next()) {   
                TipoDocumento modeloTD = new TipoDocumento();
                modeloTD.setId(rS.getInt("id"));
                modeloTD.setNombre(rS.getString("nombre"));
                modeloTD.setDescripcion(rS.getString("descripcion"));
                
                tiposId.add(modeloTD);
            }
            
            rS.close();
            st.close();
            conexion.getCon().close();
                 
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.out.println("error en la consulta");
        }
        
        return tiposId;
    }
    
}
