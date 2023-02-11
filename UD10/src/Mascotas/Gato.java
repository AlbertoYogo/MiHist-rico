package Mascotas;

public class Gato extends Mascota {

	private boolean estaMaullando;

	
	public Gato(int edad, String nombre, boolean estaMaullando) {
		super(edad, nombre);
		this.estaMaullando = estaMaullando;
		this.id=this.generarId(nombre);
	}


	public boolean isEstaMaullando() {
		return estaMaullando;
	}


	public void setEstaMaullando(boolean estaMaullando) {
		this.estaMaullando = estaMaullando;
	}


	@Override
	public String toString() {
		return "Gato [estaMaullando=" + estaMaullando + ", edad=" + edad + ", nombre=" + nombre + ", id=" + id + "]";
	}
	
	public String generarId(String nombre) {
		String id;
		id="G"+nombre.substring(0, 2)+(int) (Math.random()*20);
		
		return id;
	}
	
	
	public static void main(String[] args) {
		Gato g=new Gato(20, "Finn", false);
		System.out.println(g);
	}
}
