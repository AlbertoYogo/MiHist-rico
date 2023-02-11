package gestionAparcamiento;

public class Conductor extends Persona{
    private int codigo;
    private int turno;

    private enum turnos {MAÑANA, TARDE, NOCHE};

    public Conductor() {
        super();
        this.codigo = 0;
        this.turno = 0;
    }

    public Conductor(int codigo, int turno, String DNI, String nombre, String apellidos, int edad, String direccion, String email) {
        super(DNI, nombre, apellidos, edad, direccion, email);
        this.codigo = codigo;
        this.turno = turno;
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
}
