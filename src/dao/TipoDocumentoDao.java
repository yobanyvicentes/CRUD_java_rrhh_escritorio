/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.TipoDocumento;

/**
 *
 * @author YOBANY
 */
public interface TipoDocumentoDao {
    
    List<TipoDocumento> findAll ();
    
}
