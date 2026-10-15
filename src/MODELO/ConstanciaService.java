package MODELO;

import java.time.LocalDate;
import java.util.List;

public class ConstanciaService {

    private final IAlumnoRepositorio repo;

    public ConstanciaService(IAlumnoRepositorio repo) {
        this.repo = repo;
    }

    public List<Alumno> buscarCoincidencias(String texto) {
        return repo.buscarPorIdParcial(texto);
    }

    public Alumno obtenerDatosConfirmacion(String id) throws SeleccionInvalidaException {
        if (id == null || id.isBlank()) {
            throw new SeleccionInvalidaException(
                    "Seleccione un alumno de la lista antes de generar la constancia.");
        }
        Alumno alumno = repo.obtenerPorId(id);
        if (alumno == null) {
            throw new SeleccionInvalidaException("No se encontró el alumno con ID " + id + ".");
        }
        return alumno;
    }

    public Constancia generarConstancia(String id) throws SeleccionInvalidaException {
        Alumno alumno = obtenerDatosConfirmacion(id);
        return new Constancia(alumno, LocalDate.now());
    }
}
