package MODELO;

import java.time.LocalDate;

public class Constancia {

    private final Alumno alumno;
    private final LocalDate fechaEmision;

    public Constancia(Alumno alumno, LocalDate fechaEmision) {
        this.alumno = alumno;
        this.fechaEmision = fechaEmision;
    }

    public Alumno getAlumno() { return alumno; }
    public LocalDate getFechaEmision() { return fechaEmision; }

    /** Texto del cuerpo de la constancia (simulación, no genera documentos). */
    public String getTexto() {
        return "Se hace constar que el/la alumno(a) " + alumno.getNombre()
                + ", con ID " + alumno.getId()
                + ", se encuentra inscrito(a) en el semestre " + alumno.getSemestre()
                + ", cursando " + alumno.getCantidadMaterias()
                + " materias durante el ciclo escolar vigente.";
    }
}
