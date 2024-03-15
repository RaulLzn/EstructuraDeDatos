package raul.EjercicioPractica.Visitante;

public class Visitante {
    public String nombre;

    public Visitante(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Visitante{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
