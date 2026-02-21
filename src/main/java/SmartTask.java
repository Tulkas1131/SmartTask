import java.util.Scanner;

/**
 * Aplicación SmartTask - Sistema de Gestión de Tareas.
 * Permite crear, listar, completar y eliminar tareas normales y urgentes.
 * Implementa conceptos de Lección 6: Herencia y Polimorfismo.
 *
 * @author Estudiante
 * @version 1.0
 */
public class SmartTask {
    /**
     * Punto de entrada de la aplicación.
     * Muestra un menú interactivo en consola para gestionar tareas.
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorTareas gestor = new GestorTareas();
        
        while (true) {
            System.out.println("\n--- SMART TASK MENU ---");
            System.out.println("1. Listar tareas");
            System.out.println("2. Agregar tarea");
            System.out.println("3. Marcar como completada");
            System.out.println("4. Eliminar tarea");
            System.out.println("5. Salir");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    gestor.listarTareas();
                    break;
                case 2:
                    System.out.print("Nombre de la tarea: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Prioridad (Alta/Media/Baja): ");
                    String prioridad = scanner.nextLine();
                    System.out.print("Tipo de tarea (Normal/Urgente): ");
                    String tipo = scanner.nextLine();
                    gestor.agregarTarea(nombre, prioridad, tipo);
                    break;
                case 3:
                    System.out.print("ID de la tarea a completar: ");
                    int idComp = scanner.nextInt();
                    gestor.marcarComoCompletada(idComp);
                    break;
                case 4:
                    System.out.print("ID de la tarea a eliminar: ");
                    int idElim = scanner.nextInt();
                    gestor.eliminarTarea(idElim);
                    break;
                case 5:
                    System.out.println("¡Adiós!");
                    scanner.close();
                    return;
            }
        }
    }
}
