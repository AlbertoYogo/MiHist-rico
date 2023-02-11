package ProyectoCine;

public class Pelicula {
	private int a�o;
	private String director;
	private String genero;
	private String nombre;
	
	public void mostrarPelicula() {
		System.out.println("La pel�cula " +this.nombre+ " sali� el " +this.a�o+ " "
				+ "con " +this.director+ " como director y del genero " +this.genero);
	}
	
	//Constructor por defecto
	public Pelicula() {
		this.a�o=0;
		this.director=" ";
		this.genero=" ";
		this.nombre=" ";
	}

	//Constructor con par�metros.
	public Pelicula(int a�o, String director, String genero, String nombre) {
		super();
		this.a�o = a�o;
		this.director = director;
		this.genero = genero;
		this.nombre = nombre;
	}
	
	//Getters y setters
	public int getA�o() {
		return a�o;
	}

	public void setA�o(int a�o) {
		this.a�o = a�o;
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
