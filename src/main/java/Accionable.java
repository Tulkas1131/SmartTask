/**
 * Interfaz que define las acciones básicas de una tarea.
 * Permite aplicar polimorfismo en los diferentes tipos de tareas.
 * Requerimiento de la Lección 6.
 *
 * @author Estudiante
 * @version 1.0
 */
public interface Accionable {
    /**
     * Muestra los detalles específicos de la tarea.
     * Cada tipo de tarea implementa este método de forma diferente.
     */
    void mostrarDetalles();
}
