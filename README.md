# SmartTask - Sistema de Gestión de Tareas

## Descripción

SmartTask es una aplicación de consola desarrollada en Java que permite gestionar tareas personales. El proyecto implementa progresivamente los fundamentos del lenguaje Java, algoritmos, estructuras de control, orientación a objetos, principios de diseño, pruebas unitarias y documentación técnica.

## Características

- ✅ **Agregar tareas** con nombre y prioridad (Alta/Media/Baja)
- ✅ **Listar tareas** activas y completadas
- ✅ **Marcar tareas como completadas**
- ✅ **Eliminar tareas** por ID
- ✅ **Dos tipos de tareas**: Normal y Urgente
- ✅ **Interfaz de consola** interactiva
- ✅ **Pruebas unitarias** con JUnit5 (80%+ cobertura)
- ✅ **Documentación JavaDoc** completa

## Estructura del Proyecto

```
SmartTask/
├── src/
│   ├── main/java/
│   │   ├── SmartTask.java          # Clase principal (Lección 4)
│   │   ├── GestorTareas.java       # Gestor de tareas (Lección 5)
│   │   ├── Tarea.java              # Clase abstracta (Lección 6)
│   │   ├── TareaNormal.java        # Herencia (Lección 6)
│   │   ├── TareaUrgente.java       # Herencia y Polimorfismo (Lección 6)
│   │   └── Accionable.java         # Interfaz (Lección 6)
│   └── test/java/
│       └── GestorTareasTest.java   # Pruebas unitarias (Lección 7)
├── pom.xml                         # Configuración Maven
├── docs/                           # Documentación JavaDoc generada
├── bin/                            # Archivos compilados
└── README.md                       # Este archivo
```

## Tecnologías Utilizadas

- **Lenguaje**: Java 21
- **Compilador**: Maven 3.x
- **Testing**: JUnit5 (Jupiter)
- **Cobertura**: JaCoCo
- **IDE**: VS Code / Eclipse

## Requisitos

- JDK 21 o superior
- Maven 3.6+
- VS Code o Eclipse

## Instalación y Compilación

### 1. Clonar o descargar el proyecto

```bash
cd SmartTask
```

### 2. Compilar el proyecto

```bash
mvn clean compile
```

### 3. Ejecutar las pruebas

```bash
mvn test
```

### 4. Crear archivo ejecutable JAR

```bash
mvn package
```

El archivo `SmartTask-1.0.jar` se creará en la carpeta `target/`

## Ejecución

### Desde Maven
```bash
mvn exec:java -Dexec.mainClass="SmartTask"
```

### Desde el JAR
```bash
java -jar target/SmartTask-1.0.jar
```

## Menú de la Aplicación

```
--- SMART TASK MENU ---
1. Listar tareas
2. Agregar tarea
3. Marcar como completada
4. Eliminar tarea
5. Salir
```

## Pruebas Unitarias

### Ejecutar todas las pruebas
```bash
mvn test
```

### Pruebas incluidas (10 total)
1. ✓ Agregar tarea normal
2. ✓ Agregar tarea urgente
3. ✓ Marcar como completada
4. ✓ Marcar inexistente (validación)
5. ✓ Eliminar tarea
6. ✓ Eliminar inexistente (validación)
7. ✓ Listar tareas vacías
8. ✓ Listar tareas con contenido
9. ✓ Flujo completo (agregar → completar → eliminar)
10. ✓ Agregar múltiples tareas

### Cobertura de Código
- Objetivo: 80%+
- Herramienta: JaCoCo
- Reporte: `target/site/jacoco/index.html`

## Generación de Documentación

### Generar JavaDoc
```bash
mvn javadoc:javadoc
```

La documentación se genera en `target/site/apidocs/`

### Ver documentación existente
```bash
cd docs/
open index.html
```

## Conceptos Java Implementados

| Lección | Concepto | Archivo |
|---------|----------|---------|
| 1 | Entorno Java y estructura base | SmartTask.java |
| 2 | Algoritmos y pseudocódigo | GestorTareas.java |
| 3 | Tipos de datos, operadores, control | Tarea.java |
| 4 | Aplicación de consola | SmartTask.java |
| 5 | POO y encapsulamiento | Tarea.java, GestorTareas.java |
| 6 | Herencia, polimorfismo e interfaces | TareaNormal.java, TareaUrgente.java, Accionable.java |
| 7 | Pruebas unitarias | GestorTareasTest.java |

## Estructura de Clases

### Jerarquía de Herencia
```
Tarea (abstracta)
├── TareaNormal (implementa Accionable)
└── TareaUrgente (implementa Accionable)
```

### Interfaz Accionable
```java
public interface Accionable {
    void mostrarDetalles();
}
```

## Buenas Prácticas Implementadas

✅ Encapsulamiento (getters/setters)
✅ Nombres significativos de variables y métodos
✅ Documentación JavaDoc completa
✅ Separación de responsabilidades
✅ Bajo acoplamiento
✅ Pruebas unitarias
✅ Estructura Maven estándar
✅ Control de versiones

## Resultados de Pruebas

```
Tests run: 10
Failures: 0
Errors: 0
Skipped: 0
Coverage: 80%+
```

## Autor

Estudiante - Módulo 4: Fundamentos de Programación en Java

## Licencia

Proyecto educativo - Libre para uso académico