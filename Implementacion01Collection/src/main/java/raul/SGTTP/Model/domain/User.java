package raul.SGTTP.Model.domain;

public class User {

    private String username;
    private String password;

    private AbstractPerson person;

    public User(String username, String password, AbstractPerson persona) {
        this.username = username;
        this.password = password;
        this.person = persona;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AbstractPerson getPerson() {
        return person;
    }

    public void setPerson(AbstractPerson person) {
        this.person = person;
    }

    public static User getNullUsuario() {
        return new User("N/A", "N/A", new AbstractPerson() {});
    }
}
