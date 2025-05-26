# Gestión de Tienda

**Proyecto Trimestre 3**  
Autores: Pablo Segura González y Gonzalo Benítez Diaz

## Descripción del Proyecto

Este proyecto consiste en una aplicación de gestión de tienda desarrollada en Java. Permite administrar productos, ventas y clientes, facilitando el control y la organización de la información relevante para el funcionamiento de una tienda. Entre sus funcionalidades se incluyen el registro y actualización de productos, la gestión de inventario, el procesamiento de ventas y la consulta de historiales.

## SGBD Elegido

El sistema gestor de bases de datos (SGBD) utilizado es **Oracle Database**.

## Instrucciones de Configuración

### 1. Clonar el repositorio

```bash
git clone https://github.com/Ron-Cola168/GestionDeTienda.git
cd GestionDeTienda
```

### 2. Configuración del Driver JDBC

1. Descarga el driver JDBC para Oracle desde la [página oficial de Oracle](https://www.oracle.com/database/technologies/appdev/jdbc-downloads.html).
2. Copia el archivo `ojdbc8.jar` (o la versión correspondiente) en una carpeta `lib` dentro del proyecto (créala si no existe).
3. Añade el JAR del driver al classpath de tu proyecto. Si usas un IDE, agrégalo como dependencia externa.
### 3. Configuración de Oracle Wallet (si aplica)



### 4. Configuración de la Base de Datos

1. Crea las tablas necesarias ejecutando los scripts SQL proporcionados (si existen) en la carpeta `/sql` del repositorio.
2. Configura los datos de conexión (usuario, contraseña, host, puerto, SID o service name) en el archivo de configuración de la aplicación, o directamente en el código fuente según corresponda.

### 5. Ejecución de la Aplicación

Compila el proyecto .java desde tu IDE (el que estes usando) en nuestro caso IntelliJ.
---

## Notas adicionales

- Asegúrate de que la base de datos Oracle esté activa y accesible desde tu equipo.
- Si tienes problemas de conexión, revisa la configuración de red y los parámetros en la cadena de conexión.
- Para dudas adicionales, consulta la documentación oficial de Oracle o abre una issue en este repositorio.
