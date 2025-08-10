import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Parqueadero parqueadero = new Parqueadero();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- GESTIÓN PARQUEADERO ---");
            System.out.println("1. Ingresar vehículo");
            System.out.println("2. Registrar salida vehículo");
            System.out.println("3. Consultar estado parqueadero");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("Tipo de vehículo: 1. Automóvil 2. Motocicleta 3. Camión");
                    int tipo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Placa: ");
                    String placa = sc.nextLine();
                    System.out.print("Marca: ");
                    String marca = sc.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();
                    LocalDateTime entrada = LocalDateTime.now();

                    switch (tipo) {
                        case 1:
                            System.out.print("Tipo de combustible: ");
                            String combustible = sc.nextLine();
                            parqueadero.registrarEntrada(new Automovil(placa, marca, modelo, entrada, combustible));
                            break;
                        case 2:
                            System.out.print("Cilindraje: ");
                            int cilindraje = sc.nextInt();
                            parqueadero.registrarEntrada(new Motocicleta(placa, marca, modelo, entrada, cilindraje));
                            break;
                        case 3:
                            System.out.print("Capacidad de carga (ton): ");
                            double carga = sc.nextDouble();
                            parqueadero.registrarEntrada(new Camion(placa, marca, modelo, entrada, carga));
                            break;
                        default:
                            System.out.println("Opción no válida.");
                    }
                    break;
                case 2:
                    System.out.print("Placa del vehículo a retirar: ");
                    String placaSalida = sc.nextLine();
                    parqueadero.registrarSalida(placaSalida);
                    break;
                case 3:
                    parqueadero.mostrarVehiculos();
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}
