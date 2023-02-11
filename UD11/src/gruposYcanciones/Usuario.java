package gruposYcanciones;

public class Usuario extends Persona {
	private String tipo_música;

	public Usuario(String dNI, String nombre, String apellidos, String dirección, String usuario, String clave,
			String tipo_música) {
		super(dNI, nombre, apellidos, dirección, usuario, clave);
		this.tipo_música = tipo_música;
	}
	
	public Usuario() {
		super();
		this.tipo_música="";
	}

	public String getTipo_música() {
		return tipo_música;
	}

	public void setTipo_música(String tipo_música) {
		this.tipo_música = tipo_música;
	}

	@Override
	public String toString() {
		return "Usuario [tipo_música=" + tipo_música + ", DNI=" + DNI + ", nombre=" + nombre + ", apellidos="
				+ apellidos + ", dirección=" + dirección + ", usuario=" + usuario + ", clave=" + clave + "]";
	}
	
}
