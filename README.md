# SmartTask — Gestor de tareas en consola (Java)

Aplicación de consola en **Java 21** para gestionar tareas (crear, listar, completar y eliminar) con soporte de **prioridades** y **tipos de tarea** (Normal / Urgente). Incluye **pruebas unitarias (JUnit 5)**, **cobertura (JaCoCo)** y **JavaDoc**.

## Estado del proyecto
- ✅ Funcional (CLI)
- ✅ Tests y cobertura
- ✅ Documentación JavaDoc

## Enlaces rápidos
- 📚 Documentación (JavaDoc): **TODO: link a GitHub Pages** (ej: `https://tulkas1131.github.io/SmartTask/`)
- 📈 Cobertura (JaCoCo): `target/site/jacoco/index.html`
- ▶️ Ejecutar: ver sección **Ejecución**

## Características
- Agregar tareas con **nombre** y **prioridad** (Alta/Media/Baja)
- Listar tareas **activas** y **completadas**
- Marcar tareas como **completadas**
- Eliminar tareas por **ID**
- Tipos de tareas: **Normal** y **Urgente**
- Interfaz de consola interactiva
- Pruebas unitarias con **JUnit5**
- Reporte de cobertura con **JaCoCo**
- Documentación **JavaDoc**

---

## Requisitos
- **JDK 21+**
- **Maven 3.6+**

## Instalación
```bash
git clone https://github.com/Tulkas1131/SmartTask.git
cd SmartTask
mvn clean compile
```

## Ejecutar pruebas
```bash
mvn test
```

## Generar JAR
```bash
mvn package
```

> El JAR se genera en `target/` (por defecto: `target/<artifactId>-<version>.jar`).

## Ejecución

### Opción A — Desde Maven
```bash
mvn exec:java -Dexec.mainClass="SmartTask"
```

### Opción B — Desde el JAR
```bash
java -jar target/<artifactId>-<version>.jar
```

---

## Menú de la aplicación
```text
--- SMART TASK MENU ---
1. Listar tareas
2. Agregar tarea
3. Marcar como completada
4. Eliminar tarea
5. Salir
```

## Documentación

### Generar JavaDoc
```bash
mvn javadoc:javadoc
```

Salida típica: `target/site/apidocs/`

### Generar reporte de cobertura
```bash
mvn test
```

Reporte: `target/site/jacoco/index.html`

---

## Estructura del proyecto (resumen)
```text
src/main/java/    Código fuente
src/test/java/    Tests (JUnit 5)
docs/             JavaDoc publicado (ideal para GitHub Pages)
pom.xml           Configuración Maven
```

## Modelo (POO)
```text
Tarea (abstracta)
├── TareaNormal (implementa Accionable)
└── TareaUrgente (implementa Accionable)
```

## Autor
Alejandro Casetti

## Licencia
TODO: Elegir una licencia (recomendado: MIT o Apache-2.0).
