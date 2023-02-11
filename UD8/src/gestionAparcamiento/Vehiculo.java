package gestionAparcamiento;

import java.io.Serializable;

public abstract class Vehiculo implements Valida, Serializable {
    protected String matricula;
    protected String color;
    protected String marca;
    protected String modelo;

    public Vehiculo(){
        this.matricula = "";
        this.color = "";
        this.marca = "";
        this.modelo = "";
    }

    public Vehiculo(String matricula, String color, String marca, String modelo) {
        this.matricula = matricula;
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public boolean valida(String cadena) {
        boolean valida = false;

        if(Character.isDigit(cadena.charAt(0)) && Character.isDigit(cadena.charAt(1)) && Character.isDigit(cadena.charAt(2)) &&
                Character.isDigit(cadena.charAt(3)) && cadena.charAt(4)=='-' && Character.isUpperCase(cadena.charAt(5)) && Character.isUpperCase(cadena.charAt(6)) &&
                Character.isUpperCase(cadena.charAt(7))){
            valida = true;
        }

        return valida;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "matricula='" + matricula + '\'' +
                ", color='" + color + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}
