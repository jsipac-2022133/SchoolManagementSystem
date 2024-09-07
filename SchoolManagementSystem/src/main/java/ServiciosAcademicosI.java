public interface ServiciosAcademicosI {
    void matricularEstudiante(Estudiante estudiante);
    void agregarCurso(Curso curso);
    void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws EstudianteYaInscritoException ;
    void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscritoEnCursoException;

    public class EstudianteYaInscritoException extends Exception{
        public EstudianteYaInscritoException(String message){
            super(message);
        }
    }

    public class EstudianteNoInscritoEnCursoException extends Exception{
        public EstudianteNoInscritoEnCursoException(String message){
            super(message);
        }
    }
}
