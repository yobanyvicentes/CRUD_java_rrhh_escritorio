package controlador;
/**
 *
 * @author YOBANY
 */
import dao.TipoDocumentoDaoImp;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import models.*;

public class TipoDocumentoControler {
    private TipoDocumentoDaoImp tipoIdentificacionDao = new TipoDocumentoDaoImp();

    public TipoDocumentoControler() {
    }
    
    public DefaultComboBoxModel llenarCombo(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        List<TipoDocumento> tiposIds = tipoIdentificacionDao.findAll();
        for(TipoDocumento t : tiposIds){
            modelo.addElement(t.getDescripcion());
        }
        return modelo;
    }
    
}
