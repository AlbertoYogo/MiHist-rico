package gestionAparcamiento;

import java.io.Serializable;

public class Cliente extends Persona implements Serializable {
    private int horaLlegada;
    private int diasEstancia;
    private Vehiculo v;

    public Cliente() {
        super();
        this.horaLlegada = 0;
        this.diasEstancia = 0;
        this.v = null;
    }

    public Cliente(String DNI, String nombre, String apellidos, int edad, String direccion, String email, int horaLlegada, int diasEstancia, Vehiculo v) {
        super(DNI, nombre, apellidos, edad, direccion, email);
        this.horaLlegada = horaLlegada;
        this.diasEstancia = diasEstancia;
        this.v = v;
    }

    public int getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(int horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public int getDiasEstancia() {
        return diasEstancia;
    }

    public void setDiasEstancia(int diasEstancia) {
        this.diasEstancia = diasEstancia;
    }

    public Vehiculo getV() {
        return v;
    }

    public void setV(Vehiculo v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "horaLlegada='" + horaLlegada + '\'' +
                ", diasEstancia=" + diasEstancia +
                ", v=" + v +
                ", DNI='" + DNI + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                ", direccion='" + direccion + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static void main(String[] args) {
        //TODO: Probar el metodo valida
        Cliente c1 = new Cliente();
        c1.setDNI("15501089D");
        System.out.println(c1.valida(c1.getDNI()));
    }
}
