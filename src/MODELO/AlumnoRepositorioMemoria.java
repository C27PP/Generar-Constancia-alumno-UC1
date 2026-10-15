package MODELO;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AlumnoRepositorioMemoria implements IAlumnoRepositorio {

    private final Map<String, Alumno> alumnos = new LinkedHashMap<>();

    public AlumnoRepositorioMemoria() {
        // Datos de prueba (simulación)
        agregar("2026001", "Ana Sofía Valenzuela Ruiz", 2, 6);
        agregar("2026002", "Carlos Eduardo Moroyoqui Soto", 2, 5);
        agregar("2026010", "María Fernanda Encinas León", 2, 6);
        agregar("2026105", "José Luis Armenta Félix", 1, 7);
        agregar("2025001", "Daniela Guadalupe Buitimea Cota", 4, 6);
        agregar("2025037", "Luis Ángel Yocupicio Ayala", 4, 5);
        agregar("2024015", "Karla Paola Zazueta Ibarra", 6, 6);
        agregar("2024120", "Diego Alonso Valdez Rosas", 6, 4);
        agregar("2023008", "Valeria Itzel Quintero Báez", 8, 5);
        agregar("2023999", "Jesús Alberto Cruz Mendoza", 8, 3);
    }

    private void agregar(String id, String nombre, int semestre, int materias) {
        alumnos.put(id, new Alumno(id, nombre, semestre, materias));
    }

    @Override
    public List<Alumno> buscarPorIdParcial(String texto) {
        List<Alumno> resultado = new ArrayList<>();
        if (texto == null) return resultado;
        String t = texto.trim().toLowerCase();
        if (t.isEmpty()) return resultado;
        for (Alumno a : alumnos.values()) {
            if (a.getId().toLowerCase().contains(t)) {
                resultado.add(a);
            }
        }
        return resultado;
    }

    @Override
    public Alumno obtenerPorId(String id) {
        return alumnos.get(id);
    }
}
