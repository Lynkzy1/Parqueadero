import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Parqueadero {
    private List<Vehiculo> vehiculos;
    private static final int TARIFA_AUTOMOVIL = 2000;
    private static final int TARIFA_MOTO = 1000;
    private static final int TARIFA_CAMION = 5000;

    public Parqueadero() {
        vehiculos = new ArrayList<>();
    }

    public void registrarEntrada(Vehiculo v) {
        vehiculos.add(v);
        System.out.println("Vehículo registrado exitosamente.");
    }

    public double registrarSalida(String placa) {
        Iterator<Vehiculo> iterator = vehiculos.iterator();
        while (iterator.hasNext()) {
            Vehiculo v = iterator.next();
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                LocalDateTime salida = LocalDateTime.now();
                long minutos = Duration.between(v.getHoraEntrada(), salida).toMinutes();
                long horas = minutos / 60;
                if (minutos % 60 != 0) horas++; // Fracciones como hora completa

                double tarifa = 0;
                if (v instanceof Automovil) {
                    tarifa = TARIFA_AUTOMOVIL * horas;
                } else if (v instanceof Motocicleta) {
                    tarifa = TARIFA_MOTO * horas;
                } else if (v instanceof Camion) {
                    tarifa = TARIFA_CAMION * horas;
                }
                iterator.remove();
                System.out.println("Salida registrada. Tiempo: " + horas + " hora(s). Tarifa: $" + tarifa);
                return tarifa;
            }
        }
        System.out.println("Vehículo no encontrado.");
        return 0;
    }

    public void mostrarVehiculos() {
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos en el parqueadero.");
            return;
        }
        for (Vehiculo v : vehiculos) {
            System.out.print("Placa: " + v.getPlaca() + ", Marca: " + v.getMarca() + ", Modelo: " + v.getModelo());
            if (v instanceof Automovil) {
                System.out.print(", Tipo: Automóvil, Combustible: " + ((Automovil) v).getTipoCombustible());
            } else if (v instanceof Motocicleta) {
                System.out.print(", Tipo: Motocicleta, Cilindraje: " + ((Motocicleta) v).getCilindraje());
            } else if (v instanceof Camion) {
                System.out.print(", Tipo: Camión, Capacidad: " + ((Camion) v).getCapacidadCarga() + " toneladas");
            }
            System.out.println(", Hora entrada: " + v.getHoraEntrada());
        }
    }
}
