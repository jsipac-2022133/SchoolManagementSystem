import java.util.ArrayList;
import java.util.HashMap;

public class GestorAcademico implements ServiciosAcademicosI {
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Curso> cursos;
    private HashMap<Curso, ArrayList<Estudiante>> inscripciones;

    public GestorAcademico() {
        this.estudiantes = new ArrayList<>();
        this.cursos = new ArrayList<>();
        this.inscripciones = new HashMap<>();
    }

    @Override
    public void matricularEstudiante(Estudiante estudiante) {
        if (!estudiantes.contains(estudiante)) {
            estudiantes.add(estudiante);
            System.out.println("Estudiante matriculado.");
        }
    }

    @Override
    public void agregarCurso(Curso curso) {
        if (!cursos.contains(curso)) {
            cursos.add(curso);
            System.out.println("Curso agregado.");
        }
    }

    @Override
    public void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws EstudianteYaInscritoException {
        Curso curso = cursos.stream().filter(c -> c.getId() == idCurso).findFirst().orElse(null);
        if (curso != null) {
            ArrayList<Estudiante> inscritos = inscripciones.getOrDefault(curso, new ArrayList<>());
            if (inscritos.contains(estudiante)) {
                throw new EstudianteYaInscritoException("El estudiante ya está inscrito.");
            } else {
                inscritos.add(estudiante);
                inscripciones.put(curso, inscritos);
                System.out.println("Estudiante inscrito en el curso.");
            }
        }
    }

    @Override
    public void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscritoEnCursoException {
        // Buscar el curso por su ID
        Curso curso = null;
        for (Curso c : cursos) {
            if (c.getId() == idCurso) {
                curso = c;
                break;
            }
        }

        if (curso == null) {
            throw new EstudianteNoInscritoEnCursoException("Curso con ID " + idCurso + " no encontrado.");
        }

        ArrayList<Estudiante> estudiantesInscritos = inscripciones.get(curso);

        if (estudiantesInscritos == null || estudiantesInscritos.isEmpty()) {
            throw new EstudianteNoInscritoEnCursoException("No hay estudiantes inscritos en el curso.");
        }

        Estudiante estudianteAEliminar = null;
        for (Estudiante e : estudiantesInscritos) {
            if (e.getId() == idEstudiante) {
                estudianteAEliminar = e;
                break;
            }
        }

        if (estudianteAEliminar == null) {
            throw new EstudianteNoInscritoEnCursoException("El estudiante con ID " + idEstudiante + " no está inscrito en el curso.");
        }

        estudiantesInscritos.remove(estudianteAEliminar);
        System.out.println("Estudiante desinscrito del curso exitosamente.");
    }

}
