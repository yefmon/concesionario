package logica;
import java.util.ArrayList;
import java.util.Scanner;

public class Concesionario {
    Scanner entrada = new Scanner(System.in);
    static double total_venta = 0;      //variable estatica que almacena el valor total de las ventas de los vehículos
    ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();  //arraylist que almacena los vehículos


    //constructor vacio
    public Concesionario(){}

    /**
     * Método que permite agregar un nuevo vehiculo al arraylist
     * @param tipo_vehiculo
     * @param placa_vehiculo
     * @param marca
     * @param referencia
     * @param modelo
     * @param num_ruedas
     */
    public void registarVehiculo(String tipo_vehiculo, String placa_vehiculo, String marca, String referencia, String modelo, int num_ruedas, double precio, boolean disponible) {

        if (tipo_vehiculo.equals("auto") || tipo_vehiculo.equals("Auto")) { //Condición que selecciona
            System.out.println("cantidad de puertas");
            int num_puertas = entrada.nextInt();
            System.out.println("¿Es de gasolina?");
            boolean is_gasolina = entrada.nextBoolean();

            Auto auto = new Auto();

            auto.setTipo_vehiculo(tipo_vehiculo);
            auto.setPlaca(placa_vehiculo);
            auto.setMarca(marca);
            auto.setReferencia(referencia);
            auto.setModelo(modelo);
            auto.setNum_ruedas(num_ruedas);
            auto.setPrecio(precio);
            auto.setNum_puertas(num_puertas);
            auto.setIs_gasolina(is_gasolina);
            auto.setDisponible(disponible);

            vehiculos.add(auto);
            System.out.println("Auto registrado exitosamente");

        } else if (tipo_vehiculo.equals("moto") || tipo_vehiculo.equals("Moto")) {

            System.out.println("Cilindraje");
            int cilindraje = entrada.nextInt();
            System.out.println("Tamaño del tanque");
            double tam_tanque = entrada.nextDouble();

            Moto moto = new Moto();

            moto.setTipo_vehiculo(tipo_vehiculo);
            moto.setPlaca(placa_vehiculo);
            moto.setMarca(marca);
            moto.setReferencia(referencia);
            moto.setModelo(modelo);
            moto.setNum_ruedas(num_ruedas);
            moto.setPrecio(precio);
            moto.setCilindraje(cilindraje);
            moto.setTam_tanque(tam_tanque);
            moto.setDisponible(disponible);

            vehiculos.add(moto);
            System.out.println("Moto registrada exitosamente");

        } else if (tipo_vehiculo.equals("camion") || tipo_vehiculo.equals("Camion")){
            System.out.println("Capacidad de carga");
            String cap_carga = entrada.nextLine();

            Camion camion = new Camion();

            camion.setTipo_vehiculo(tipo_vehiculo);
            camion.setPlaca(placa_vehiculo);
            camion.setMarca(marca);
            camion.setReferencia(referencia);
            camion.setModelo(modelo);
            camion.setNum_ruedas(num_ruedas);
            camion.setPrecio(precio);
            camion.setCap_carga(cap_carga);
            camion.setDisponible(disponible);

            vehiculos.add(camion);
            System.out.println("Camion registrado exitosamente");
        }
    }

    /**
     * Método que permite buscar un vehículo del arraylist e imprimirlo por pantalla.
     * @param opcion_referencia
     */
    public void buscarVehiculo(String opcion_referencia){

        for (int i=0; i< vehiculos.size(); i++) { //Ciclo que recorre el arraylist
            String precio_vehiculo = String.valueOf(vehiculos.get(i).getPrecio()); //convertimos el precio a tipo String
            if(!vehiculos.isEmpty()){
                if(opcion_referencia.equals(vehiculos.get(i).getPlaca()) || opcion_referencia.equals(vehiculos.get(i).getMarca()) || opcion_referencia.equals(vehiculos.get(i).getReferencia()) || opcion_referencia.equals(vehiculos.get(i).getModelo()) || opcion_referencia.equals(precio_vehiculo)){
                    System.out.println("Tipo de vehículo: "+vehiculos.get(i).getTipo_vehiculo()+" Placa: "+vehiculos.get(i).getPlaca()+" Marca: "+vehiculos.get(i).getMarca()+" Referencia: "+vehiculos.get(i).getReferencia()+" Modelo: "+vehiculos.get(i).getModelo()+" Número de ruedas: "+vehiculos.get(i).getNum_ruedas()+" Precio: "+vehiculos.get(i).getPrecio()+" Disponibilidad: "+vehiculos.get(i).isDisponible());
                }else{
                    System.out.println("El vehículo no existe");
                }
            }else {
                System.out.println("No hay vehículos");
            }
        }
    }

    /**
     * Método que permite mostrar todos los vehículos de estado "Disponible"
     */
    public void listarVehiculosDisponibles(){
        System.out.println("\tVehículos Disponlibles\n");
        for(Vehiculo vehiculo:vehiculos){
            if(!vehiculos.isEmpty()){
                if (vehiculo.isDisponible()){
                   String estado = "Disponible";
                    System.out.println("Estado: "+estado+" Marca: "+vehiculo.getMarca()+" Referencia: "+vehiculo.getReferencia()+" Modelo: "+vehiculo.getModelo()+" Número de ruedas: "+vehiculo.getNum_ruedas()+" Precio: "+vehiculo.getPrecio());
                }
            }
        }
    }

    /**
     * Método que permite vender un vehículo y así mismo cambiar su estado a no disponible, además en una variable estatica
     * almacena y va sumando el precio de los vehiculos vendidos.
     * @param referencia
     */
    public void venderVehiculo(String referencia){

        for(Vehiculo vehiculo:vehiculos){
            if(!vehiculos.isEmpty()){
                if(vehiculo.getReferencia().equals(referencia)){
                    System.out.println("¿Desea vender este vehículo?\n" +
                            "1. Aceptar\n" +
                            "2. Cancelar");
                    int opcion = entrada.nextInt();
                    if(opcion == 1){
                        System.out.println("Vehículo vendido exitosamente");
                        vehiculo.setDisponible(false);
                        total_venta += vehiculo.getPrecio();
                    }
                }else {
                    System.out.println("Error, vehículo no encontrado");
                }
            }
        }
    }

    /**
     * Método que permite mostrar la cantidad y todos los vehículos en stock y los vendidos
     */
    public void mostrarCantidadVehiculos(){
        int vendidos = 0;
        int stock = 0;

        for (Vehiculo vehiculo:vehiculos){
            if (!vehiculos.isEmpty()){
                if(vehiculo.isDisponible()){
                    String estado = "Disponible";
                    System.out.println("Estado: "+estado+" Tipo de vehículo "+vehiculo.getTipo_vehiculo()+" Marca: "+vehiculo.getMarca()+" Referencia: "+vehiculo.getReferencia()+" Modelo: "+vehiculo.getModelo()+" Número de ruedas: "+vehiculo.getNum_ruedas()+" Precio: "+vehiculo.getPrecio());
                    stock++;
                }else {
                    String estado = "No disponible";
                    System.out.println("Estado: "+estado+" Tipo de vehículo "+vehiculo.getTipo_vehiculo()+" Marca: "+vehiculo.getMarca()+" Referencia: "+vehiculo.getReferencia()+" Modelo: "+vehiculo.getModelo()+" Número de ruedas: "+vehiculo.getNum_ruedas()+" Precio: "+vehiculo.getPrecio());
                    vendidos++;
                }
            }
        }
        System.out.println("Hay "+stock+" vehículos en stock y hay "+vendidos+" vehículos vendidos.");
    }

    /**
     * Método que permite actualizar datos de un vehículo de un arraylist
     * @param tipo_vehiculo
     * @param referencia
     */
    public void actualizarDatosDeVehiculos(int tipo_vehiculo, String referencia){

        System.out.println("Ingresa la nueva placa del vehículo");
        String placa = entrada.next();
        System.out.println("Ingresa la nueva marca del vehículo");
        String marca = entrada.next();
        System.out.println("Ingrese el nuevo modelo del vehículo");
        String modelo = entrada.next();
        System.out.println("Ingrese el nuevo número de ruedas");
        int numero_ruedas = entrada.nextInt();
        System.out.println("Ingrese el nuevo precio");
        double precio = entrada.nextDouble();

        if(tipo_vehiculo == 1){
            System.out.println("Ingrese el nuevo número de puertas");
            int num_puertas = entrada.nextInt();
            System.out.println("Ingrese si es de gasolina\n" +
                    "true: si\n" +
                    "false: No");
            boolean is_gasolina = entrada.nextBoolean();

            for (Vehiculo vehiculo:vehiculos){
                if (vehiculo.getReferencia().equals(referencia)){
                    vehiculo.setPlaca(placa);
                    vehiculo.setMarca(marca);
                    vehiculo.setModelo(modelo);
                    vehiculo.setNum_ruedas(numero_ruedas);
                    vehiculo.setPrecio(precio);

                    System.out.println("Vehículo actualizado exitosamente");
                }else {
                    System.out.println("Vehículo no encontrado");
                }
            }
        }else if (tipo_vehiculo == 2){
            System.out.println("Ingrese el nuevo cilindraje de la moto");
            int cilindraje = entrada.nextInt();
            System.out.println("Ingrese el nuevo tamaño del tanque");
            double tam_tanque = entrada.nextDouble();

            for (Vehiculo vehiculo:vehiculos){
                if (vehiculo.getReferencia().equals(referencia)){
                    vehiculo.setPlaca(placa);
                    vehiculo.setMarca(marca);
                    vehiculo.setModelo(modelo);
                    vehiculo.setNum_ruedas(numero_ruedas);
                    vehiculo.setPrecio(precio);

                    System.out.println("Vehículo actualizado exitosamente");
                }else {
                    System.out.println("Vehículo no encontrado");
                }
            }
        }else {
            System.out.println("Ingrese la capacidad de carga");
            String cap_carga = entrada.next();

            for (Vehiculo vehiculo:vehiculos){
                if (vehiculo.getReferencia().equals(referencia)){
                    vehiculo.setPlaca(placa);
                    vehiculo.setMarca(marca);
                    vehiculo.setModelo(modelo);
                    vehiculo.setNum_ruedas(numero_ruedas);
                    vehiculo.setPrecio(precio);

                    System.out.println("Vehículo actualizado exitosamente");
                }else {
                    System.out.println("Vehículo no encontrado");
                }
            }
        }
    }

    /**
     * Método que permite mostrar el valor total de las ventas.
     */
    public void verVentasTotales(){
        System.out.println("El valor total en ventas es de $"+total_venta);
    }

    /**
     * Método que permite eliminar un vehículo del arraylist
     * @param referencia
     */
    public void eliminarVehiculo(String referencia){

        for (int i=0; i<vehiculos.size(); i++) { //recorro el arraylist
            if(!vehiculos.isEmpty()){           //Verifica que el arraylist no este vacio
                if(vehiculos.get(i).getReferencia().equals(referencia) && vehiculos.get(i).isDisponible()){     //Condición que verifica que la referencia recibida por parámetro este en el arraylist, además verifica que el estado sea "disponible"
                    vehiculos.remove(vehiculos.get(i));     //Elimina el objeto del arraylist
                    System.out.println("Vehículo eliminado exitosamente.");
                }else {
                    System.out.println("El vehículo no se pudo eliminar, verifique la referencia o si el vehículo fue vendido e intente nuevamente.");
                }
            }else {
                System.out.println("La lista está vacía. No puedes borrar más elementos.");
            }
        }
    }
}
