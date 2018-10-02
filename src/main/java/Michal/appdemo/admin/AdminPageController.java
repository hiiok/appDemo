package Michal.appdemo.admin;

import Michal.appdemo.user.User;
import Michal.appdemo.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.GET;
import java.util.List;

@Controller
@Secured(value = {"ROLE_ADMIN"})
public class AdminPageController {

    @Autowired
    private UserService userService;

    @GET
    @RequestMapping(value = "/admin")
    public String openAdminMainPage() {
        return "admin/admin";
    }

    @GET
    @RequestMapping(value = "/admin/users")
    public String openAdminAllUsersPage(Model model) {
        List<User> userList = getAllUsers();
        model.addAttribute("userList", userList);
        return "admin/users";
    }


    //Pobieranie listy użytkowników
    private List<User> getAllUsers() {
        List<User> usersList = userService.findAll();
        for (User users : usersList) {
            int numerRoli = users.getRoles().iterator().next().getId();
        }
        return usersList;
    }
}