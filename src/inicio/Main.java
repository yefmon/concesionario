package inicio;
import logica.Concesionario;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		Concesionario concesionario = new Concesionario();

		boolean programa_activo = true; //Variable que mantiene el programa activo

		while(programa_activo) {

			System.out.println("\n\t ¿Que operación deseas realizar?\n\n" +
					"1. Registrar vehículo\n" +
					"2. Buscar vehículo\n" +
					"3. Listar vehículos disponibles\n" +
					"4. Vender vehículo\n" +
					"5. Mostrar cantidad de vehículos en stock y vendidos\n" +
					"6. Actualizar datos de vehículo\n" +
					"7. Mostrar el valor de ventas totales\n" +
					"8. Eliminar vehículo\n" +
					"9. salir");

			int opcion = entrada.nextInt();		//Variable que permite ingresar a los casos solicitados

			switch (opcion) {
				case 1:
					System.out.println("¿Qué tipo de vehiculo desea registrar?\n" +
							"- Auto\n" +
							"- Moto\n" +
							"- Camion");
					String opc = entrada.next();

					if(opc.equals("auto") || opc.equals("moto") || opc.equals("camion")){
						System.out.println("Digite los siguientes datos:");

						System.out.println("Placa");
						String placa_vehiculo = entrada.next();
						System.out.println("Marca");
						String marca = entrada.next();
						System.out.println("Referencia");
						String referencia = entrada.next();
						System.out.println("Modelo");
						String modelo = entrada.next();
						System.out.println("Cantidad de ruedas");
						int num_ruedas = entrada.nextInt();
						System.out.println("Precio");
						double precio = entrada.nextDouble();
						System.out.println("Distado disponible");
						boolean disponible = true;

						concesionario.registarVehiculo(opc, placa_vehiculo, marca, referencia, modelo, num_ruedas, precio, disponible);
					}else {
						System.out.println("Error, intente nuevamente");
					}
					break;
				case 2:
					System.out.println("Ingrese el tipo de referencia del vehículo que desea buscar:\n" +
							"1. Placa\n" +
							"2. Marca\n" +
							"3. Referencia\n" +
							"4. Modelo\n" +
							"5. Precio");

						int op = entrada.nextInt();

						if(op > 0 && op < 5){
							System.out.println("Ingrese el valor del tipo de referencia seleccionada");
							String buscar_vehiculo = entrada.next();

							concesionario.buscarVehiculo(buscar_vehiculo);
						}else if (op == 5){
							System.out.println("Ingrese el precio del vehículo");
							double buscar_vehiculo = entrada.nextDouble();
							concesionario.buscarVehiculo(String.valueOf(buscar_vehiculo));
						}else {
							System.out.println("Dato invalido, intente nuevamente");
						}
					break;
				case 3:
					concesionario.listarVehiculosDisponibles();
					break;
				case 4:
					System.out.println("Ingrese la referencia del vehículo que desea vender");
					String referencia_vehiculo = entrada.next();

					concesionario.venderVehiculo(referencia_vehiculo);
					break;
				case 5:
					concesionario.mostrarCantidadVehiculos();
					break;
				case 6:
					System.out.println("Ingrese el tipo de vehículo que desea modificar\n" +
							"1. Auto\n" +
							"2. Moto\n" +
							"3. Camion");
					int tipo_vehiculo = entrada.nextInt();

					System.out.println("Ingrese la referencia del vehículo que quieres modificar");
					String referencia_vehiculo_actualizar = entrada.next();

					concesionario.actualizarDatosDeVehiculos(tipo_vehiculo, referencia_vehiculo_actualizar);
					break;
				case 7:
					concesionario.verVentasTotales();
					break;
				case 8:
					System.out.println("ingrese el número de referencia del vehículo");
					String ref_vehiculo = entrada.next();
					concesionario.eliminarVehiculo(ref_vehiculo);
					break;
				case 9:
					System.exit(0);
					break;
				default:
					System.out.println("Error, intente nuevamente");
					break;
			}
		}
	}
}