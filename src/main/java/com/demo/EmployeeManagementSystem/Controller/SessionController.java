package demo.EmployeeManagementSystem.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("session")
public class SessionController {

    @GetMapping("checkSession")
    public Map<String, Boolean> checkSession(HttpSession session) {
        Map<String, Boolean> response = new HashMap<>();
        if (session != null && session.getAttribute("user") != null) {
            response.put("loggedIn", true);
        } else {
            response.put("loggedIn", false);
        }
        return response;
    }
}