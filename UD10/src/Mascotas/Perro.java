package Mascotas;

public class Perro extends Mascota {

	private boolean estaLadrando;

	
	public Perro(int edad, String nombre, boolean estaLadrando) {
		super(edad, nombre);
		this.estaLadrando = estaLadrando;
		this.id=this.generarId(nombre);
	}


	public boolean isEstaLadrando() {
		return estaLadrando;
	}


	public void setEstaLadrando(boolean estaLadrando) {
		this.estaLadrando = estaLadrando;
	}


	@Override
	public String toString() {
		return "Perro [estaLadrando=" + estaLadrando + ", edad=" + edad + ", nombre=" + nombre + ", id=" + id + "]";
	}
	
	
	public String generarId(String nombre) {
		String id;
		id="P"+nombre.substring(0, 2)+(int) (Math.random()*20);
		
		return id;
	}
	
	public static void main(String[] args) {
		Perro p=new Perro(6, "Snoopy", true);
		System.out.println(p);
	}
}
