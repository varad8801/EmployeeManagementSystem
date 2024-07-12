package demo.EmployeeManagementSystem.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.EmployeeManagementSystem.Model.User;

public interface UserDao extends JpaRepository<User, Integer> {
	User findByUsername(String username);

}
