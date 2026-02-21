import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona la colección de tareas del sistema.
 * Centraliza la lógica de agregar, listar, completar y eliminar tareas.
 * Aplica los fundamentos de la Lección 5.
 *
 * @author Estudiante
 * @version 1.0
 */
public class GestorTareas {
    private List<Tarea> listaTareas = new ArrayList<>();
    private int contadorId = 1;

    /**
     * Obtiene la lista de tareas registradas.
     * @return Lista de tareas
     */
    public List<Tarea> getListaTareas() {
        return listaTareas;
    }

    /**
     * Agrega una nueva tarea al gestor (Normal o Urgente).
     * @param nombre Nombre o descripción de la tarea
     * @param prioridad Nivel de prioridad (Alta/Media/Baja)
     * @param tipo Tipo de tarea: "Normal" o "Urgente"
     */
    public void agregarTarea(String nombre, String prioridad, String tipo) {
        Tarea nueva;
        if (tipo.equalsIgnoreCase("Urgente")) {
            nueva = new TareaUrgente(contadorId++, nombre, prioridad);
        } else {
            nueva = new TareaNormal(contadorId++, nombre, prioridad);
        }
        listaTareas.add(nueva);
        System.out.println("Tarea " + tipo + " agregada.");
    }

    /**
     * Lista todas las tareas registradas.
     */
    public void listarTareas() {
        if (listaTareas.isEmpty()) {
            System.out.println("No hay tareas registradas.");
        } else {
            for (Tarea t : listaTareas) {
                System.out.println(t);
            }
        }
    }

    /**
     * Marca una tarea como completada por su ID.
     * @param id Identificador de la tarea a completar
     */
    public void marcarComoCompletada(int id) {
        for (Tarea t : listaTareas) {
            if (t.getId() == id) {
                t.setCompletado(true);
                System.out.println("Tarea marcada como completada.");
                return;
            }
        }
        System.out.println("Tarea no encontrada.");
    }

    /**
     * Elimina una tarea por su ID.
     * @param id Identificador de la tarea a eliminar
     */
    public void eliminarTarea(int id) {
        if (listaTareas.removeIf(t -> t.getId() == id)) {
            System.out.println("Tarea eliminada.");
        } else {
            System.out.println("Tarea no encontrada.");
        }
    }
}
