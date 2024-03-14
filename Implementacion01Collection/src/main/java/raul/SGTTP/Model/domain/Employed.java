package raul.SGTTP.Model.domain;

import raul.Model.array.Array;

public class Employed extends AbstractPerson {
    private String Id;

    public Employed(String nombre, String apellido, Array<String> telefonos, String Id) {
        super(nombre, apellido, telefonos);
        this.Id = Id;
    }

    public Employed() {
        super();
        this.Id = "N/A";
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public static Employed getNullEmpleado() {
        return new Employed("N/A", "N/A", new Array<>(1), "N/A");
    }
}
