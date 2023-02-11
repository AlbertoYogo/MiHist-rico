package gruposYcanciones;

public class Administrador extends Persona {
	private int turno;

	public Administrador(String dNI, String nombre, String apellidos, String dirección, String usuario, String clave,
			int turno) {
		super(dNI, nombre, apellidos, dirección, usuario, clave);
		this.turno = turno;
	}
	
	public Administrador() {
		super();
		this.turno=0;
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	@Override
	public String toString() {
		return "Administrador [turno=" + turno + ", DNI=" + DNI + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", dirección=" + dirección + ", usuario=" + usuario + ", clave=" + clave + "]";
	}
	
	
	
}
