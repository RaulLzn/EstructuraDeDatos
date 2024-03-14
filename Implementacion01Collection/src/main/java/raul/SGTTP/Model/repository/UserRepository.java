package raul.SGTTP.Model.repository;

import raul.SGTTP.Model.domain.Employed;
import raul.SGTTP.Model.domain.User;
import raul.SGTTP.shared.filejsonadapter.FileJsonAdapter;

public class UserRepository {

    private FileJsonAdapter<UserEntity> fileJson;
    private String pathFile;

    public UserRepository(String pathFile) {
            this.pathFile = pathFile;
            fileJson = FileJsonAdapter.getInstance();
    }

    public User getUser(String username) {
        UserEntity[] userEntities = fileJson.getObjects(pathFile, UserEntity[].class);
        for (UserEntity userEntity : userEntities) {
            if (userEntity.username.equals(username)) {
                EmployedRepository employedRepository = new EmployedRepository("src/main/java/raul/SGTTP/Model/repository/employed.json");
                Employed employed = employedRepository.getEmployed(userEntity.persona);
                return new User(userEntity.username, userEntity.password, employed);
            }
        }
        return User.getNullUsuario();
    }


}
