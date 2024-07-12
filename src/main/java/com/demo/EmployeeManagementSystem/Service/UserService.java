package demo.EmployeeManagementSystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.security.crypto.password.PasswordEncoder;
import demo.EmployeeManagementSystem.DAO.UserDao;
import demo.EmployeeManagementSystem.Model.User;

@Service
public class UserService {
	@Autowired
    private UserDao userdao;

    

    public User registerUser(User user) {
        user.setPassword(user.getPassword());
        return userdao.save(user);
    }

    public User authenticate(String username, String password) {
        User user = userdao.findByUsername(username);
        if (user != null && password.equals( user.getPassword())) {
            return user;
        }
        return null;
    }
}

