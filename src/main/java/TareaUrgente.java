/**
 * Clase que representa una tarea urgente.
 * Extiende la clase abstracta Tarea (Lección 6).
 * Implementa la interfaz Accionable.
 * Las tareas urgentes tienen prioridad inmediata.
 */
public class TareaUrgente extends Tarea implements Accionable {
    
    /**
     * Constructor de TareaUrgente.
     * @param id Identificador único de la tarea
     * @param nombre Nombre o descripción de la tarea
     * @param prioridad Nivel de prioridad (Alta/Media/Baja)
     */
    public TareaUrgente(int id, String nombre, String prioridad) {
        super(id, nombre, prioridad);
    }
    
    /**
     * Sobrescribe el método toString para marcar tareas urgentes.
     * @return String con formato especial para tareas urgentes
     */
    @Override
    public String toString() {
        String estado = isCompletado() ? "[Completada]" : "[Pendiente]";
        return "⚠️ " + getId() + ". " + getNombre() + " | Prioridad: " + getPrioridad() + " " + estado + " [URGENTE]";
    }
    
    /**
     * Implementación del método mostrarDetalles de la interfaz Accionable.
     * Muestra los detalles específicos de una tarea urgente.
     */
    @Override
    public void mostrarDetalles() {
        System.out.println("=== TAREA URGENTE ===");
        System.out.println("ID: " + getId());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Prioridad: " + getPrioridad());
        System.out.println("Estado: " + (isCompletado() ? "Completada" : "Pendiente"));
        System.out.println("Tipo: Urgente ⚠️");
        System.out.println("Requiere atención inmediata");
    }
}
