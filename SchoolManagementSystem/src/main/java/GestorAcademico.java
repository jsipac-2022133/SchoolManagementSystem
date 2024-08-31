import java.util.ArrayList;
import java.util.HashMap;

public class GestorAcademico {
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Curso> cursos;
    private HashMap<Curso, ArrayList<Estudiante>> inscripciones;

    public GestorAcademico() {
        this.estudiantes = new ArrayList<>();
        this.cursos = new ArrayList<>();
        this.inscripciones = new HashMap<>();
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public void agregarCurso(Curso curso) {
        cursos.add(curso);
    }

    public void inscribirEstudianteEnCurso(Estudiante estudiante, Curso curso) {
        if (!inscripciones.containsKey(curso)) {
            inscripciones.put(curso, new ArrayList<>());
        }
        inscripciones.get(curso).add(estudiante);
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public HashMap<Curso, ArrayList<Estudiante>> getInscripciones() {
        return inscripciones;
    }
}
