# Magicas: El Encuentro

## 📝 Descripción del Proyecto

**Magicas: El Encuentro** es una aplicación desarrollada por Pablo Segura González y Gonzalo Benítez Díaz, orientada a la gestión de tiendas dedicadas a la venta de juegos de mesa y cartas coleccionables. El sistema facilita la administración de productos, inventario, ventas, clientes y demás operaciones clave para el funcionamiento eficiente de una tienda especializada.

---

## 💾 SGBD Elegido

El sistema gestor de base de datos (SGBD) utilizado en este proyecto es **Oracle Database**.

---

## ⚙️ Instrucciones de Configuración

### 1. Requisitos Previos

- **Java JDK 17** o superior instalado en el sistema.
- **Oracle Database** accesible (local o remota).
- **Driver JDBC para Oracle** (ojdbc8.jar o superior).
- **Wallet de Oracle** (si la conexión requiere cifrado SSL).
- Herramienta de construcción recomendada: **Maven** o **Gradle** (opcional, pero recomendado).

### 2. Descarga del Driver JDBC de Oracle

1. Accede al sitio oficial de Oracle para descargar el driver JDBC:  
   [https://www.oracle.com/database/technologies/appdev/jdbc-downloads.html](https://www.oracle.com/database/technologies/appdev/jdbc-downloads.html)
2. Descarga el archivo `ojdbc8.jar` o la versión compatible con tu SGBD Oracle.
3. Copia el `ojdbc8.jar` a la carpeta `lib/` del proyecto o asegúrate de incluirlo en el classpath de tu IDE/herramienta de construcción.

#### Si usas Maven, añade la dependencia en tu archivo `pom.xml`:

```xml
<dependency>
    <groupId>com.oracle.database.jdbc</groupId>
    <artifactId>ojdbc8</artifactId>
    <version>21.7.0.0</version>
</dependency>
```

#### Si usas Gradle, añade el siguiente bloque al archivo `build.gradle`:

```groovy
dependencies {
    implementation 'com.oracle.database.jdbc:ojdbc8:21.7.0.0'
}
```

### 3. Wallet de Oracle (Conexión Segura)

Si tu base de datos requiere una conexión cifrada (por ejemplo, Oracle Autonomous Database):

1. Descarga el Wallet desde tu consola de Oracle Cloud o solicita el archivo al administrador de la base de datos.
2. Extrae el contenido del wallet (por ejemplo, carpeta `wallet/`) en el directorio raíz del proyecto o en la ruta que prefieras.
3. Configura el archivo `sqlnet.ora` y asegúrate de que el archivo de propiedades de conexión apunte correctamente al wallet.

Ejemplo de cadena de conexión usando wallet:
```
jdbc:oracle:thin:@<service_name>?TNS_ADMIN=/ruta/a/tu/wallet
```

---

## ▶️ Ejecución de la Aplicación

1. **Clona este repositorio:**

   ```bash
   git clone https://github.com/Ron-Cola168/GestionDeTienda.git
   cd GestionDeTienda
   ```

2. **Configura el archivo de propiedades de conexión (`config.properties` o similar):**

   - Especifica el usuario, contraseña, URL JDBC y ruta al wallet si aplica.
   - Ejemplo de contenido:
     ```
     db.url=jdbc:oracle:thin:@<service_name>?TNS_ADMIN=/ruta/a/tu/wallet
     db.user=usuario
     db.password=contraseña
     ```

3. **Compila el proyecto:**

   - Si usas Maven:
     ```bash
     mvn clean compile
     ```
   - Si usas Gradle:
     ```bash
     gradle build
     ```
   - O compila manualmente (asegúrate de incluir el driver JDBC en el classpath):
     ```bash
     javac -cp ".;lib/ojdbc8.jar" src/**/*.java
     ```

4. **Ejecuta la aplicación:**

   - Si usas un archivo Main, por ejemplo `Main.java`:
     ```bash
     java -cp ".;lib/ojdbc8.jar" ruta/al/paquete/Main
     ```
   - O usando Maven:
     ```bash
     mvn exec:java -Dexec.mainClass="ruta.al.paquete.Main"
     ```

---

## 📄 Notas Adicionales

- Asegúrate de que las credenciales y rutas de conexión sean correctas y tengan los permisos necesarios en Oracle Database.
- Modifica el archivo de propiedades según la estructura y archivos del proyecto.
- Consulta la documentación oficial de Oracle para detalles específicos sobre el uso de wallet y configuración de conexiones seguras.

---

## 👥 Autores

- Pablo Segura González
- Gonzalo Benítez Díaz

---
