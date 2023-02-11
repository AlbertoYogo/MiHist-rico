package gruposYcanciones;

public abstract class Persona {

	//DNI, nombre, apellidos, direcci�n, usuario, clave,
	protected String DNI;
	protected String nombre;
	protected String apellidos;
	protected String direcci�n;
	protected String usuario;
	protected String clave;
	
	public Persona(String dNI, String nombre, String apellidos, String direcci�n, String usuario, String clave) {
		this.DNI = dNI;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direcci�n = direcci�n;
		this.usuario = usuario;
		this.clave = clave;
	}
	
	public Persona() {
		this.DNI = " ";
		this.nombre = "";
		this.apellidos = "";
		this.direcci�n = "";
		this.usuario = "";
		this.clave = "";
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDirecci�n() {
		return direcci�n;
	}

	public void setDirecci�n(String direcci�n) {
		this.direcci�n = direcci�n;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Override
	public String toString() {
		return "Persona [DNI=" + DNI + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direcci�n=" + direcci�n
				+ ", usuario=" + usuario + ", clave=" + clave + "]";
	}
	
	
	
	
}
