/**
 * Clase abstracta que representa una tarea individual.
 * Encapsula los atributos comunes de todas las tareas.
 * Aplica los fundamentos de la Lección 3 y 5.
 *
 * @author Estudiante
 * @version 1.0
 */
public abstract class Tarea {
    private int id;
    private String nombre;
    private String prioridad;
    private boolean completado;

    /**
     * Constructor que inicializa una tarea con estado pendiente.
     * @param id Identificador único de la tarea
     * @param nombre Nombre o descripción de la tarea
     * @param prioridad Nivel de prioridad (Alta/Media/Baja)
     */
    public Tarea(int id, String nombre, String prioridad) {
        this.id = id;
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.completado = false;
    }

    /** @return Identificador de la tarea */
    public int getId() { return id; }

    /** @return Nombre de la tarea */
    public String getNombre() { return nombre; }

    /** @return Prioridad de la tarea */
    public String getPrioridad() { return prioridad; }

    /** @return true si la tarea está completada */
    public boolean isCompletado() { return completado; }

    /**
     * Cambia el estado de completado de la tarea.
     * @param completado true para marcar como completada
     */
    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

    /**
     * Representación en texto de la tarea.
     * @return Cadena con id, nombre, prioridad y estado
     */
    @Override
    public String toString() {
        String estado = completado ? "[Completada]" : "[Pendiente]";
        return id + ". " + nombre + " | Prioridad: " + prioridad + " " + estado;
    }
}