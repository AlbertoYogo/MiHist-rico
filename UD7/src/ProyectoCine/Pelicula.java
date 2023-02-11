package ProyectoCine;

public class Pelicula {
	private int año;
	private String director;
	private String genero;
	private String nombre;
	
	public void mostrarPelicula() {
		System.out.println("La película " +this.nombre+ " salió el " +this.año+ " "
				+ "con " +this.director+ " como director y del genero " +this.genero);
	}
	
	//Constructor por defecto
	public Pelicula() {
		this.año=0;
		this.director=" ";
		this.genero=" ";
		this.nombre=" ";
	}

	//Constructor con parámetros.
	public Pelicula(int año, String director, String genero, String nombre) {
		super();
		this.año = año;
		this.director = director;
		this.genero = genero;
		this.nombre = nombre;
	}
	
	//Getters y setters
	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public static void main(String[] args) {
		Pelicula p=new Pelicula(2022, "alguien", "superheroes", "Spiderman: No Way Home");
		p.mostrarPelicula();
	}
	
	
}
