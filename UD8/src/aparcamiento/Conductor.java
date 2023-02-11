package aparcamiento;

public class Conductor extends Persona {

	private int codigo;
	private int turno;
	
	public Conductor(String dNI, String nombre, String apellidos, int edad, String direccion, String email, int codigo,
			int turno) {
		super(dNI, nombre, apellidos, edad, direccion, email);
		this.codigo = codigo;
		this.turno = turno;
	}

	public Conductor() {
		super();
		this.codigo=0;
		this.turno=0;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	@Override
	public String toString() {
		return "Conductor [codigo=" + codigo + ", turno=" + turno + ", DNI=" + DNI + ", nombre=" + nombre
				+ ", apellidos=" + apellidos + ", edad=" + edad + ", direccion=" + direccion + ", email=" + email + "]";
	}
	
	
	
	
	
}
