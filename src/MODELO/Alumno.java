package MODELO;

public class Alumno {

    private final String id;
    private final String nombre;
    private final int semestre;
    private final int cantidadMaterias;

    public Alumno(String id, String nombre, int semestre, int cantidadMaterias) {
        this.id = id;
        this.nombre = nombre;
        this.semestre = semestre;
        this.cantidadMaterias = cantidadMaterias;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public int getSemestre() { return semestre; }
    public int getCantidadMaterias() { return cantidadMaterias; }

    @Override
    public String toString() {
        return id;
    }
}
