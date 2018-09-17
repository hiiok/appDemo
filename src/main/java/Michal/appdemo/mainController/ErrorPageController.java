package Michal.appdemo.mainController;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.GET;

public class ErrorPageController implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @GET
    @RequestMapping(value = "/error")
    public String showErrorPage() {
        return "error";
    }
}
