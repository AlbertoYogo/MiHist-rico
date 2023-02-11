package Clínica;

public class Profesionales extends Persona {

	private String especialidad;
	private int turno;
	
	public final static int MAÑANA=0;
	public final static int TARDE=1;
	public final static int GUARDIA=2;
	
	
	public Profesionales(String dNI, String nombre, String apellidos, int teléfono, String especialidad, int turno) {
		super(dNI, nombre, apellidos, teléfono);
		this.especialidad = especialidad;
		this.turno = turno;
	}
	public Profesionales() {
		super();
		this.especialidad="";
		this.turno=0;
	}
	
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public int getTurno() {
		return turno;
	}
	public void setTurno(int turno) {
		this.turno = turno;
	}
	
	@Override
	public String toString() {
		return "Pacientes [especialidad=" + especialidad + ", turno=" + turno + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	public static void main(String[] args) {
		Profesionales pro=new Profesionales("1234567A", "Alberto", "Lopez", 678392321, "Cirugia", MAÑANA);
		System.out.println(pro);
	}
}
