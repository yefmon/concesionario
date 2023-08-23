package logica;

public class Moto extends Vehiculo {
	
	private int cilindraje;
	private double tam_tanque;
	
	public Moto() {
		
	}

	public Moto(String tipo_vehiculo, String placa, String marca, String referencia, String modelo, int num_ruedas, double precio, boolean disponible, int cilindraje, double tam_tanque) {
		super(tipo_vehiculo, placa, marca, referencia, modelo, num_ruedas, precio, disponible);
		this.cilindraje = cilindraje;
		this.tam_tanque = tam_tanque;
	}


	public int getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}

	public double getTam_tanque() {
		return tam_tanque;
	}

	public void setTam_tanque(double tam_tanque) {
		this.tam_tanque = tam_tanque;
	}

	@Override
	public void queSoy() {
		// TODO Auto-generated method stub
		System.out.println("soy una moto");
	}

}
