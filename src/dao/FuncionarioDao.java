package dao;

import java.util.List;
import models.Funcionario;

/**
 *
 * @author YOBANY
 */
public interface FuncionarioDao {
    
    List<Funcionario> findall();
    
    Funcionario findByDoc(String document);
    
    boolean guardar(Funcionario funcionario);
    
    Funcionario editar(String document);
    
    boolean actualizar(Funcionario funcionario);
    
    void borrar(String document);
}
