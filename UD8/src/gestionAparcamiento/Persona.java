package gestionAparcamiento;

import java.io.Serializable;

public class Persona implements Valida, Serializable {
    protected String DNI;
    protected String nombre;
    protected String apellidos;
    protected int edad;
    protected String direccion;
    protected String email;

    public Persona() {
        this.DNI = "";
        this.nombre = "";
        this.apellidos = "";
        this.edad = 18;
        this.direccion = "";
        this.email = "";
    }

    public Persona(String DNI, String nombre, String apellidos, int edad, String direccion, String email) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.direccion = direccion;
        this.email = email;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean valida(String cadena) {
        boolean valido = false;
        String[] letras = {"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
        int numero = Integer.parseInt(cadena.substring(0,8));
        String letra = letras[numero%23];
        if (cadena.length() == 9 && Character.isLetter(cadena.charAt(8)) && letra.equalsIgnoreCase(String.valueOf(cadena.charAt(8)))){
            valido = true;
        }

        return valido;
    }
}
