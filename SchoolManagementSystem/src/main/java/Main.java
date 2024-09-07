public class Main {
    public static void main(String[] args) {
        GestorAcademico gestor = new GestorAcademico();

        Estudiante est1 = new Estudiante(1, "Juan", "Perez", "01/01/2000", "Matriculado");
        Estudiante est2 = new Estudiante(2, "Ana", "Garcia", "05/03/1999", "Matriculado");

        Curso curso1 = new Curso(1, "Matemáticas", "Curso de álgebra", 4, "1.0");
        Curso curso2 = new Curso(2, "Historia", "Curso de historia antigua", 3, "1.1");

        gestor.matricularEstudiante(est1);
        gestor.agregarCurso(curso1);

        try {
            gestor.inscribirEstudianteCurso(est1, 1);
        } catch (ServiciosAcademicosI.EstudianteYaInscritoException e) {
            throw new RuntimeException(e);
        }
    }
}

