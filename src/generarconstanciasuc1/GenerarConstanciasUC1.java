
package generarconstanciasuc1;

import CONTROLADOR.ConstanciaController;
import MODELO.AlumnoRepositorioMemoria;
import MODELO.ConstanciaService;
import VISTA.ConstanciaView;

/**
 *
 * @author Cristian Jesus Cruz Mendívil
 */
public class GenerarConstanciasUC1 {

    public static void main(String[] args) {
        
        System.out.println("Hola");
        ConstanciaView vista = new ConstanciaView();
        ConstanciaService servicio = new ConstanciaService(new AlumnoRepositorioMemoria());
        ConstanciaController controlador = new ConstanciaController(vista, servicio);
        vista.setControlador(controlador);   // ← aquí la vista conoce al controlador
        vista.setVisible(true);
        
    }
    
}
