package raul.SGTTP.Model.repository;


public class UserEntity {
    String persona;
    String username;
    String password;

    UserEntity(String username, String password, String persona) {
        this.username = username;
        this.password = password;
        this.persona = persona;
    }


}
