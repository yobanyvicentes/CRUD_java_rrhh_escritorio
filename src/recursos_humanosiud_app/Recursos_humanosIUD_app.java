package recursos_humanosiud_app;

import bd.Conexion;
import vistas.Home;
/**
 *
 * @author YOBANY
 */
public class Recursos_humanosIUD_app {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Conexion conexion = new Conexion();
        System.out.println(conexion.getCon());
        
        Home f1 = new Home();
        f1.setVisible(true);
        
        
        
    }
    
}
