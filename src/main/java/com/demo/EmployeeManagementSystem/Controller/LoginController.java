package demo.EmployeeManagementSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import demo.EmployeeManagementSystem.Model.User;
import demo.EmployeeManagementSystem.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
//@RequestMapping("/")
public class LoginController {

    @Autowired
    private UserService userser;
    
    @GetMapping("/")
    public String home() {
    	
    	return "redirect:/login"; // Return login page (e.g., login.html or login.jsp)
    }
    @GetMapping("/login")
    public String showLoginPage(HttpServletRequest request) {
    	HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            return "redirect:/index.html"; // Redirect to home page if already logged in
        }
        return "login.html"; // Return login page (e.g., login.html or login.jsp)
    }
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpServletRequest request) {
        User user = userser.authenticate(username, password);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            return "redirect:/Index.html"; // Redirect to index.html
        } else {
            return "redirect:/login?error"; // Redirect back to login page with error message
        }
    }
//
//    @PostMapping("/register")
//    public String register(@RequestParam String username, @RequestParam String password) {
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(password);
//        userser.registerUser(user);
//        return "User registered successfully!";
//    }
    
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/login"; // Redirect to login page after logout
    }
}
