package logica;

public class Camion extends Vehiculo{
    private String cap_carga;

    public Camion(){
    }

    public Camion(String tipo_vehiculo, String placa, String marca, String referencia, String modelo, int num_ruedas, double precio, boolean disponible, String cap_carga){
        super(tipo_vehiculo, placa, marca, referencia, modelo, num_ruedas, precio, disponible);
        this.cap_carga = cap_carga;
    }

    public String getCap_carga() {
        return cap_carga;
    }

    public void setCap_carga(String cap_carga) {
        this.cap_carga = cap_carga;
    }

    @Override
    public void queSoy() {
        System.out.println("Soy un camion");
    }
}
