/**
 * Clase de pruebas unitarias para GestorTareas.
 * Implementa la Lección 7: Pruebas unitarias en Java con JUnit5.
 * 
 * <p>Esta clase de pruebas valida el funcionamiento correcto de:</p>
 * <ul>
 *   <li>agregarTarea()</li>
 *   <li>listarTareas()</li>
 *   <li>marcarComoCompletada()</li>
 *   <li>eliminarTarea()</li>
 * </ul>
 * 
 * @author Estudiante
 * @version 1.0
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Pruebas del Gestor de Tareas")
public class GestorTareasTest {
    
    private GestorTareas gestor;
    
    /**
     * Inicializa el gestor de tareas antes de cada prueba.
     * Se ejecuta automáticamente antes de cada método @Test.
     */
    @BeforeEach
    public void setUp() {
        gestor = new GestorTareas();
    }
    
    /**
     * Prueba 1: Verifica que se puede agregar una tarea normal correctamente.
     */
    @Test
    @DisplayName("Agregar tarea normal")
    public void testAgregarTareaNormal() {
        gestor.agregarTarea("Completar proyecto", "Alta", "Normal");

        assertEquals(1, gestor.getListaTareas().size());
        assertTrue(gestor.getListaTareas().get(0) instanceof TareaNormal);
        assertEquals("Completar proyecto", gestor.getListaTareas().get(0).getNombre());
    }
    
    /**
     * Prueba 2: Verifica que se puede agregar una tarea urgente correctamente.
     */
    @Test
    @DisplayName("Agregar tarea urgente")
    public void testAgregarTareaUrgente() {
        gestor.agregarTarea("Resolver bug crítico", "Alta", "Urgente");

        assertEquals(1, gestor.getListaTareas().size());
        assertTrue(gestor.getListaTareas().get(0) instanceof TareaUrgente);
    }
    
    /**
     * Prueba 3: Verifica que marcar una tarea como completada funciona.
     */
    @Test
    @DisplayName("Marcar tarea como completada")
    public void testMarcarComoCompletada() {
        gestor.agregarTarea("Tarea de prueba", "Media", "Normal");

        gestor.marcarComoCompletada(1);

        assertTrue(gestor.getListaTareas().get(0).isCompletado());
    }
    
    /**
     * Prueba 4: Verifica que marcar como completada una tarea inexistente no lanza excepción.
     */
    @Test
    @DisplayName("Marcar tarea inexistente como completada")
    public void testMarcarComoCompletadaTareaInexistente() {
        assertDoesNotThrow(() -> gestor.marcarComoCompletada(999));
    }
    
    /**
     * Prueba 5: Verifica que se puede eliminar una tarea correctamente.
     */
    @Test
    @DisplayName("Eliminar tarea existente")
    public void testEliminarTarea() {
        gestor.agregarTarea("Tarea a eliminar", "Baja", "Normal");
        assertEquals(1, gestor.getListaTareas().size());

        gestor.eliminarTarea(1);

        assertEquals(0, gestor.getListaTareas().size());
    }
    
    /**
     * Prueba 6: Verifica que eliminar una tarea inexistente no lanza excepción.
     */
    @Test
    @DisplayName("Eliminar tarea inexistente")
    public void testEliminarTareaInexistente() {
        assertDoesNotThrow(() -> gestor.eliminarTarea(999));
    }
    
    /**
     * Prueba 7: Verifica que listar tareas funciona cuando está vacío.
     */
    @Test
    @DisplayName("Listar tareas vacías")
    public void testListarTareasVacias() {
        assertEquals(0, gestor.getListaTareas().size());
        assertDoesNotThrow(() -> gestor.listarTareas());
    }
    
    /**
     * Prueba 8: Verifica que listar tareas funciona con datos.
     */
    @Test
    @DisplayName("Listar tareas con contenido")
    public void testListarTareasConContenido() {
        gestor.agregarTarea("Tarea 1", "Alta", "Normal");
        gestor.agregarTarea("Tarea 2", "Media", "Urgente");
        gestor.agregarTarea("Tarea 3", "Baja", "Normal");

        assertEquals(3, gestor.getListaTareas().size());
        assertDoesNotThrow(() -> gestor.listarTareas());
    }
    
    /**
     * Prueba 9: Verifica múltiples operaciones en secuencia.
     */
    @Test
    @DisplayName("Flujo completo: agregar, marcar completada y eliminar")
    public void testFlujoCompleto() {
        gestor.agregarTarea("Tarea 1", "Alta", "Normal");
        gestor.agregarTarea("Tarea 2", "Media", "Urgente");
        assertEquals(2, gestor.getListaTareas().size());

        gestor.marcarComoCompletada(1);
        assertTrue(gestor.getListaTareas().get(0).isCompletado());

        gestor.eliminarTarea(2);
        assertEquals(1, gestor.getListaTareas().size());
    }
    
    /**
     * Prueba 10: Verifica que se pueden agregar múltiples tareas de diferentes tipos.
     */
    @Test
    @DisplayName("Agregar múltiples tareas de diferentes tipos")
    public void testAgregarMultiplesTareas() {
        for (int i = 0; i < 5; i++) {
            String tipo = (i % 2 == 0) ? "Normal" : "Urgente";
            gestor.agregarTarea("Tarea " + i, "Alta", tipo);
        }

        assertEquals(5, gestor.getListaTareas().size());
    }

    /**
     * Prueba 11: Verifica mostrarDetalles() de TareaNormal.
     */
    @Test
    @DisplayName("MostrarDetalles de tarea normal")
    public void testMostrarDetallesTareaNormal() {
        TareaNormal tarea = new TareaNormal(1, "Test", "Alta");
        assertDoesNotThrow(() -> tarea.mostrarDetalles());
        assertEquals("Alta", tarea.getPrioridad());
        assertFalse(tarea.isCompletado());
    }

    /**
     * Prueba 12: Verifica mostrarDetalles() de TareaUrgente.
     */
    @Test
    @DisplayName("MostrarDetalles de tarea urgente")
    public void testMostrarDetallesTareaUrgente() {
        TareaUrgente tarea = new TareaUrgente(1, "Bug crítico", "Alta");
        assertDoesNotThrow(() -> tarea.mostrarDetalles());
        assertTrue(tarea.toString().contains("URGENTE"));
    }

    /**
     * Prueba 13: Verifica toString() de TareaNormal.
     */
    @Test
    @DisplayName("ToString de tarea normal")
    public void testToStringTareaNormal() {
        TareaNormal tarea = new TareaNormal(1, "Estudiar", "Media");
        String resultado = tarea.toString();
        assertTrue(resultado.contains("Estudiar"));
        assertTrue(resultado.contains("Media"));
        assertTrue(resultado.contains("Pendiente"));
    }

    /**
     * Prueba 14: Verifica toString() de TareaUrgente completada.
     */
    @Test
    @DisplayName("ToString de tarea urgente completada")
    public void testToStringTareaUrgenteCompletada() {
        TareaUrgente tarea = new TareaUrgente(1, "Deploy", "Alta");
        tarea.setCompletado(true);
        String resultado = tarea.toString();
        assertTrue(resultado.contains("Completada"));
        assertTrue(resultado.contains("URGENTE"));
        assertTrue(tarea.isCompletado());
    }

    /**
     * Prueba 15: Verifica mostrarDetalles() con tarea completada.
     */
    @Test
    @DisplayName("MostrarDetalles de tarea completada")
    public void testMostrarDetallesTareaCompletada() {
        TareaNormal tarea = new TareaNormal(1, "Revisar", "Baja");
        tarea.setCompletado(true);
        assertTrue(tarea.isCompletado());
        assertDoesNotThrow(() -> tarea.mostrarDetalles());
    }
}
