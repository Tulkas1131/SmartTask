/**
 * Clase que representa una tarea normal.
 * Extiende la clase abstracta Tarea (Lección 6).
 * Implementa la interfaz Accionable.
 */
public class TareaNormal extends Tarea implements Accionable {
    
    /**
     * Constructor de TareaNormal.
     * @param id Identificador único de la tarea
     * @param nombre Nombre o descripción de la tarea
     * @param prioridad Nivel de prioridad (Alta/Media/Baja)
     */
    public TareaNormal(int id, String nombre, String prioridad) {
        super(id, nombre, prioridad);
    }
    
    /**
     * Implementación del método mostrarDetalles de la interfaz Accionable.
     * Muestra los detalles específicos de una tarea normal.
     */
    @Override
    public void mostrarDetalles() {
        System.out.println("=== TAREA NORMAL ===");
        System.out.println("ID: " + getId());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Prioridad: " + getPrioridad());
        System.out.println("Estado: " + (isCompletado() ? "Completada" : "Pendiente"));
        System.out.println("Tipo: Normal");
    }
}
