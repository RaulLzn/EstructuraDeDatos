package raul.SGTTP.Model.domain;

import raul.Model.array.Array;


public abstract class AbstractPerson {
    protected String nombre;
    protected String apellido;
    protected Array<String> telefonos;

    public AbstractPerson(String nombre, String apellido, Array<String> telefonos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefonos = telefonos;
    }

    public AbstractPerson() {
        this.nombre = "N/A";
        this.apellido = "N/A";
        this.telefonos = new Array<>(1);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Array<String> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(Array<String> telefonos) {
        this.telefonos = telefonos;
    }
}
