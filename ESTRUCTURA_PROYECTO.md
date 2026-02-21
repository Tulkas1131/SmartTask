# Diagrama de Estructura del Proyecto SmartTask

## 📋 Descripción General
**SmartTask** es una aplicación de gestión de tareas desarrollada en Java que implementa conceptos avanzados de programación orientada a objetos como herencia, polimorfismo e interfaces. Utiliza Maven como herramienta de construcción y JUnit 5 para testing.

---

## 📁 Estructura de Directorios

```
SmartTask/
│
├── 📄 pom.xml                          # Configuración de Maven
├── 📄 README.md                        # Documentación del proyecto
├── 📄 ESTADO_FINAL.md                  # Estado final del proyecto
├── 📄 ESTRUCTURA_PROYECTO.md           # Este archivo
│
├── 📂 src/                             # Código fuente
│   ├── main/
│   │   └── java/
│   │       ├── Accionable.java         # Interface (Lección 6)
│   │       ├── Tarea.java              # Clase abstracta
│   │       ├── TareaNormal.java        # Hereda de Tarea
│   │       ├── TareaUrgente.java       # Hereda de Tarea
│   │       ├── GestorTareas.java       # Gestor principal
│   │       └── SmartTask.java          # Clase main
│   │
│   └── test/
│       └── java/
│           └── GestorTareasTest.java   # Tests unitarios (JUnit 5)
│
├── 📂 bin/                             # Archivos compilados
│   ├── main/java/
│   └── test/java/
│
├── 📂 target/                          # Artefactos generados por Maven
│   ├── classes/                        # Bytecode compilado
│   ├── test-classes/                   # Tests compilados
│   ├── site/
│   │   └── jacoco/                     # Cobertura de código
│   └── surefire-reports/               # Reportes de tests
│
├── 📂 lib/                             # Dependencias externas
│
├── 📂 docs/                            # Documentación JavaDoc
│   └── (múltiples archivos HTML)
│
└── 📂 .mvn/                            # Configuración Maven Wrapper
```

---

## 🏗️ Diagrama de Clases (UML)

```
┌─────────────────────────────────────────────────────────────────┐
│                    <<Interface>>                                │
│                      Accionable                                 │
├─────────────────────────────────────────────────────────────────┤
│ + mostrarDetalles() : void                                      │
└────────────────┬────────────────────────────────────────────────┘
                 │ implements
                 │
┌────────────────┴────────────────────────────────────────────────┐
│                  <<Abstract>>                                   │
│                      Tarea                                      │
├─────────────────────────────────────────────────────────────────┤
│ - id : int                                                      │
│ - nombre : String                                               │
│ - prioridad : String                                            │
│ - completado : boolean                                          │
├─────────────────────────────────────────────────────────────────┤
│ + Tarea(id, nombre, prioridad)                                  │
│ + getId() : int                                                 │
│ + getNombre() : String                                          │
│ + getPrioridad() : String                                       │
│ + isCompletado() : boolean                                      │
│ + setCompletado(boolean) : void                                 │
│ + mostrarDetalles() : void {abstract}                           │
└────────────┬────────────────────────────────┬───────────────────┘
             │ extends                        │ extends
             │                                │
    ┌────────▼───────────────┐   ┌──────────▼───────────────┐
    │   TareaNormal          │   │   TareaUrgente           │
    ├────────────────────────┤   ├──────────────────────────┤
    │ (Concreta)             │   │ (Concreta)               │
    │                        │   │                          │
    │ + mostrarDetalles()    │   │ + mostrarDetalles()      │
    │ + calcularTiempo()     │   │ + obtenerNotificación()  │
    └────────────────────────┘   └──────────┬───────────────┘
                                            │
                                  (Tareas con mayor
                                   prioridad)
```

---

## 🔧 Componentes Principales

### 1. **Accionable.java** (Interface)
- Define el contrato para las acciones básicas de una tarea
- Método: `mostrarDetalles()` - Visualización de detalles de la tarea
- Propósito: Establecer polimorfismo para diferentes tipos de tareas

### 2. **Tarea.java** (Clase Abstracta)
- Clase base que encapsula los atributos comunes de todas las tareas
- **Atributos:**
  - `id`: Identificador único de la tarea
  - `nombre`: Descripción de la tarea
  - `prioridad`: Nivel de prioridad (Alta/Media/Baja)
  - `completado`: Estado de la tarea
- **Métodos:** Getters, setters y método abstracto `mostrarDetalles()`

### 3. **TareaNormal.java** (Clase Concreta)
- Extensión de `Tarea` para tareas de prioridad normal
- Implementa `mostrarDetalles()` específicamente para tareas normales
- Métodos adicionales para cálculo de tiempo estimado

### 4. **TareaUrgente.java** (Clase Concreta)
- Extensión de `Tarea` para tareas de alta prioridad
- Implementa `mostrarDetalles()` con indicadores de urgencia
- Métodos adicionales para notificaciones y alertas

### 5. **GestorTareas.java** (Gestor Principal)
- Gestiona la colección de tareas (ArrayList)
- **Responsabilidades:**
  - Agregar nuevas tareas (normales o urgentes)
  - Listar todas las tareas
  - Marcar tareas como completadas
  - Eliminar tareas
  - Buscar tareas por ID
- Mantiene un contador automático de IDs

### 6. **SmartTask.java** (Punto de Entrada)
- Clase `main` de la aplicación
- Implementa interfaz de usuario en línea de comandos
- Menú interactivo con opciones:
  1. Listar tareas
  2. Agregar tarea
  3. Marcar como completada
  4. Eliminar tarea
  5. Salir

---

## 📊 Flujo de Datos

```
┌──────────────────┐
│    SmartTask     │ (main)
│   main(String[])│
└────────┬─────────┘
         │ crea
         ▼
┌──────────────────────┐
│  GestorTareas        │
│ - listaTareas        │
│ - contadorId         │
└────────┬─────────────┘
         │
    ┌────┴────┬──────────────┐
    │         │              │
    ▼         ▼              ▼
┌─────────┐ ┌────────────┐ ┌───────────┐
│ Tarea   │ │TareaNormal │ │TareaUrgente│
│abstract │ │ concrete   │ │ concrete  │
└─────────┘ └────────────┘ └───────────┘
```

---

## 🧪 Testing

### Dependencias de Testing
- **JUnit 5** (Jupiter)
  - junit-jupiter-api (5.9.3)
  - junit-jupiter-engine (5.9.3)
  - junit-jupiter-params (5.9.3)

### Suite de Tests
- **GestorTareasTest.java** - Tests unitarios para el gestor de tareas
- Cobertura: Validación de funcionalidades CRUD y casos límite

### Herramientas de Cobertura
- **JaCoCo** - Análisis de cobertura de código
- Reportes generados en: `target/site/jacoco/`

---

## 🔄 Ciclo de Desarrollo

### Build
```bash
mvn clean compile
```

### Testing
```bash
mvn test
```

### Cobertura
```bash
mvn jacoco:report
```

### Documentación
```bash
mvn javadoc:javadoc
```

---

## 📚 Conceptos de Programación Implementados

| Concepto | Comentarios | Implementación |
|----------|------------|-----------------|
| **Herencia** | Lección 5 | `TareaNormal` y `TareaUrgente` heredan de `Tarea` |
| **Polimorfismo** | Lección 6 | Implementación de `mostrarDetalles()` en subclases |
| **Interfaces** | Lección 6 | `Accionable` define contrato para mostrar detalles |
| **Encapsulamiento** | Lección 5 | Atributos privados con getters/setters públicos |
| **Clase Abstracta** | Lección 5 | `Tarea` define estructura común but no es instantiable |
| **Colecciones** | Lección 7 | `ArrayList<Tarea>` para gestionar lista de tareas |

---

## 📦 Construcción y Dependencias

### Java Version
- **Target:** Java 21
- **Compilador:** Maven Compiler Plugin

### Dependencias
```xml
<!-- Testing -->
org.junit.jupiter:junit-jupiter-api:5.9.3
org.junit.jupiter:junit-jupiter-engine:5.9.3
org.junit.jupiter:junit-jupiter-params:5.9.3

<!-- Code Coverage -->
org.jacoco:jacoco-maven-plugin
```

---

## 🎯 Objetivos del Proyecto

✅ Implementar jerarquía de clases con herencia  
✅ Aplicar polimorfismo en métodos concretos  
✅ Definir interfaces para contratos  
✅ Gestionar colecciones de objetos  
✅ Crear tests unitarios con JUnit 5  
✅ Documentar código con JavaDoc  
✅ Analizar cobertura de código  

---

## 📝 Convenciones del Proyecto

- **Packaging:** com.smarttask
- **Nomenclatura:** CamelCase para clases, camelCase para variables
- **Documentación:** JavaDoc en todas las clases y métodos públicos
- **Testing:** JUnit 5 con cobertura mínima del 80%
- **Build Tool:** Apache Maven 3.x+

---

**Última actualización:** 14 de febrero de 2026  
**Versión del Proyecto:** 1.0  
**Estado:** Completo y funcional ✓
