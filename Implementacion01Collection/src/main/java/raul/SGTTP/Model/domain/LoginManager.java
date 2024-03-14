package raul.SGTTP.Model.domain;

import raul.SGTTP.Model.repository.UserRepository;

public class LoginManager {
    private UserRepository userRepository;

    public LoginManager (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean login(String username, String password) {
        User user = userRepository.getUser(username);
        if (user.equals(User.getNullUsuario())) {
            return false;
        }
        return user.getPassword().equals(password);

    }

}
