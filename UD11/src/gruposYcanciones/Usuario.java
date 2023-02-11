package gruposYcanciones;

public class Usuario extends Persona {
	private String tipo_m�sica;

	public Usuario(String dNI, String nombre, String apellidos, String direcci�n, String usuario, String clave,
			String tipo_m�sica) {
		super(dNI, nombre, apellidos, direcci�n, usuario, clave);
		this.tipo_m�sica = tipo_m�sica;
	}
	
	public Usuario() {
		super();
		this.tipo_m�sica="";
	}

	public String getTipo_m�sica() {
		return tipo_m�sica;
	}

	public void setTipo_m�sica(String tipo_m�sica) {
		this.tipo_m�sica = tipo_m�sica;
	}

	@Override
	public String toString() {
		return "Usuario [tipo_m�sica=" + tipo_m�sica + ", DNI=" + DNI + ", nombre=" + nombre + ", apellidos="
				+ apellidos + ", direcci�n=" + direcci�n + ", usuario=" + usuario + ", clave=" + clave + "]";
	}
	
}
