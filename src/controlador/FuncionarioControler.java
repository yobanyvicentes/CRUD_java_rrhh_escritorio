package controlador;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;
import dao.FuncionarioDaoImp;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Funcionario;
/**
 *
 * @author YOBANY
 */
public class FuncionarioControler {
    private FuncionarioDaoImp funcionarioDaoImp = new FuncionarioDaoImp();

    public FuncionarioControler() {
    }
    
    public DefaultTableModel listarFuncionarios(){
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("num_id");
        modeloTabla.addColumn("nombres");
        modeloTabla.addColumn("apellidos");
        modeloTabla.addColumn("sexo");
        modeloTabla.addColumn("direccion");
        modeloTabla.addColumn("telefono");
        modeloTabla.addColumn("fechaNacimiento");
        
        FuncionarioDaoImp funcionarioDaoImpl = new FuncionarioDaoImp();
        List<Funcionario> listaFuncionarios = new ArrayList<>();
        listaFuncionarios = funcionarioDaoImpl.findall();

        System.out.println(listaFuncionarios.get(1).getApellidos());
        
        for(Funcionario f: listaFuncionarios){
            String[] fila = {
                f.getNumId(),
                f.getNombres(),
                f.getApellidos(),
                f.getSexo(),
                f.getDireccion(),
                f.getTelefono(),
                f.getFechaNacimiento().toString()
            };
            System.out.println(fila[2]);
            modeloTabla.addRow(fila);
        }
        
        return modeloTabla;
    }
    
    public void crearFuncionario(Funcionario funcionario){
        FuncionarioDaoImp fun = new FuncionarioDaoImp();
        if(fun.guardar(funcionario)==true) {
            JOptionPane.showMessageDialog(null, "Funcionario creado con exito");
        }else{
            JOptionPane.showMessageDialog(null, "Hubo un problema al intentar crear el funcionario");
        }
    }
    
    public Funcionario editarFuncionario(String document){
        Funcionario funcionario = new Funcionario();
        try {
            funcionario = funcionarioDaoImp.editar(document);
            System.out.println("ahora puede editar al funcionario");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un problema al intentar editar el funcionario");
        }
        return funcionario;
    }

    public void eliminarFuncionario(String text) {
        try {
            funcionarioDaoImp.borrar(text);
            JOptionPane.showMessageDialog(null, "Funcionario borrado con exito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puedo borrar el funcionario");
        }
    }

    public void update(Funcionario funcionario) {
        FuncionarioDaoImp fun = new FuncionarioDaoImp();
        if(fun.actualizar(funcionario)==true) {
            JOptionPane.showMessageDialog(null, "Funcionario actualizado con exito");
        }else{
            JOptionPane.showMessageDialog(null, "Hubo un problema al intentar actualizar el funcionario");
        }
    }
}
