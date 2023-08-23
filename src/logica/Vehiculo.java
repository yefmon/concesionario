package logica;

public abstract class Vehiculo {
	private String tipo_vehiculo;
	private String placa;
	private String marca;
	private String referencia;
	private String modelo;
	private int num_ruedas;
	private double precio;
	private boolean disponible;
	
	public Vehiculo() {}
	
	
	public Vehiculo(String tipo_vehiculo, String placa, String marca, String referencia, String modelo, int num_ruedas, double precio, boolean disponible) {
		super();
		this.tipo_vehiculo = tipo_vehiculo;
		this.placa = placa;
		this.marca = marca;
		this.referencia = referencia;
		this.modelo = modelo;
		this.num_ruedas = num_ruedas;
		this.precio = precio;
		this.disponible = disponible;

	}

	public String getTipo_vehiculo() {
		return tipo_vehiculo;
	}

	public void setTipo_vehiculo(String tipo_vehiculo) {
		this.tipo_vehiculo = tipo_vehiculo;
	}

	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = this.placa;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getReferencia() {
		return referencia;
	}


	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public int getNum_ruedas() {
		return num_ruedas;
	}


	public void setNum_ruedas(int num_ruedas) {
		this.num_ruedas = num_ruedas;
	}
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public abstract void queSoy();
}
