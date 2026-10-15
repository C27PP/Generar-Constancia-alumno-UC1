package CONTROLADOR;

import MODELO.Alumno;
import MODELO.Constancia;
import MODELO.ConstanciaService;
import MODELO.SeleccionInvalidaException;
import VISTA.ConstanciaView;
import java.util.List;

public class ConstanciaController {

    private final ConstanciaView vista;
    private final ConstanciaService servicio;
    private String idSeleccionado;

    public ConstanciaController(ConstanciaView vista, ConstanciaService servicio) {
        this.vista = vista;
        this.servicio = servicio;
    }

    /** Se llama cada vez que cambia el texto del buscador. */
    public void onIdTecleado(String texto) {
        idSeleccionado = null;
        List<Alumno> coincidencias = servicio.buscarCoincidencias(texto);
        vista.actualizarLista(coincidencias);
        vista.limpiarDetalle();
    }

    /** Se llama al seleccionar un ID en la lista (id == null si no hay selección). */
    public void onAlumnoSeleccionado(String id) {
        idSeleccionado = id;
        if (id == null) {
            vista.limpiarDetalle();
            return;
        }
        try {
            Alumno alumno = servicio.obtenerDatosConfirmacion(id);
            vista.mostrarDatos(alumno);
        } catch (SeleccionInvalidaException e) {
            vista.mostrarError(e.getMessage());
        }
    }

    /** Se llama al pulsar "Generar constancia". */
    public void onGenerarConstancia() {
        try {
            Constancia constancia = servicio.generarConstancia(idSeleccionado);
            vista.mostrarConstancia(constancia);
        } catch (SeleccionInvalidaException e) {
            vista.mostrarError(e.getMessage());
        }
    }
}
