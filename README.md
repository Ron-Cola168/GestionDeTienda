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

### 3. Configuración de Oracle Wallet

Para poder acceder a la base de datos unicamente es necesario mantener el wallet proporcionado en la carpeta OtrosRecursos/Wallet_Magicas dentro del proyecto.
En el caso de querer utilizar una base de datos propia que no sea la de los alumnos sera necesario cambiar en la clase DatabaseConnection las siguientes lineas
1. Línea 18: private static final String DB_USER = "Nombre_de_tu_usuario"
2. Línea 19: private static final String DB_PASSWORD = "contraseña_de_tu_usuario"
3. Línea 23: private static final String WALLET_PATH = "ruta/a/tu/Wallet"
4. Línea 25: private static final String TNS_NAME = "nombre_de_servicio_TSN" (Ej: magicaselencuentro_medium)

### 4. Configuración de la Base de Datos

En caso de utilizar una base de datos propia es necesario utilizar los archivos sql del directorio OtrosRecursos/SQL, para tener las tablas identicas y no tener la necesidad de modificar el codigo

### 5. Ejecución de la Aplicación

Ejecuta el proyecto desde la clase VenPrincipal desde tu IDE

