# Sistema de Gestión de Parqueadero

Este proyecto es una aplicación de consola en Java que permite gestionar la entrada y salida de vehículos en un parqueadero, calculando el costo según el tipo de vehículo y el tiempo de estadía. Utiliza herencia para representar distintos tipos de vehículos.

## Características

- Registro de entrada y salida de vehículos (Automóvil, Motocicleta, Camión).
- Cálculo automático del costo de parqueo según el tipo y tiempo de estadía.
- Consulta del estado actual del parqueadero.
- Interfaz de usuario por consola.

## Clases Principales

- **Vehiculo**: Clase base con atributos comunes para todos los vehículos.
- **Automovil, Motocicleta, Camion**: Clases que heredan de `Vehiculo` y agregan atributos específicos.
- **Parqueadero**: Gestiona la lista de vehículos y las operaciones principales.
- **Main**: Contiene la interfaz de usuario de consola.

## Tarifas de Parqueo

- **Automóvil:** $2000 por hora.
- **Motocicleta:** $1000 por hora.
- **Camión:** $5000 por hora.

*(Las fracciones de hora se cobran como hora completa.)*

## Requisitos

- Java 8 o superior

## Compilación y Ejecución

1. **Clona o descarga el repositorio.**
2. **Compila todos los archivos Java:**
   ```bash
   javac *.java
   ```
3. **Ejecuta el programa principal:**
   ```bash
   java Main
   ```

## Uso

El programa mostrará un menú interactivo donde podrás:
- Ingresar un vehículo (seleccionando tipo y datos).
- Registrar la salida de un vehículo (ingresando la placa).
- Consultar los vehículos presentes en el parqueadero.


¿Tienes dudas o sugerencias? ¡No dudes en contribuir!
