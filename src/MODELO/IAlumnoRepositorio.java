package MODELO;

import java.util.List;

public interface IAlumnoRepositorio {

    List<Alumno> buscarPorIdParcial(String texto);

    Alumno obtenerPorId(String id);
}
