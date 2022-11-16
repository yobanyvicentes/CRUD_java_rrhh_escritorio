package controlador;

import dao.EstadoCivilDaoImp;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import models.EstadoCivil;
/**
 *
 * @author YOBANY
 */
public class EstadoCivilControler {
    private EstadoCivilDaoImp estadoCivilDaoImp = new EstadoCivilDaoImp();

    public EstadoCivilControler() {
    }
    
    public DefaultComboBoxModel llenarComboEstados(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        List<EstadoCivil> estadosCiviles = estadoCivilDaoImp.findAll();
        for(EstadoCivil c : estadosCiviles){
            modelo.addElement(c.getDescripcion());
        }
        return modelo;
    }
}
