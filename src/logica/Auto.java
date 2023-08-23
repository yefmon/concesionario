package logica;

public class Auto extends Vehiculo {
    private int num_puertas;
    private boolean is_gasolina;

    public Auto() {
    }

    public Auto(String tipo_vehiculo, String placa, String marca, String referencia, String modelo, int num_ruedas, double precio, boolean disponible, int num_puertas, boolean is_gasolina) {
        super(tipo_vehiculo, placa, marca, referencia, modelo, num_ruedas, precio, disponible);
        this.num_puertas = num_puertas;
        this.is_gasolina = is_gasolina;
    }

    public int getNum_puertas() {
        return this.num_puertas;
    }

    public void setNum_puertas(int num_puertas) {
        this.num_puertas = num_puertas;
    }

    public boolean isIs_gasolina() {
        return this.is_gasolina;
    }

    public void setIs_gasolina(boolean is_gasolina) {
        this.is_gasolina = is_gasolina;
    }

    public void queSoy() {
        System.out.println("soy un carro");
    }
}