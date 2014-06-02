/**
 * Base Spring MVC controller.
 */
package com.blizzardtec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blizzardtec.model.Login;

/**
 * @author Barnaby Golden
 *
 */
@Controller
public final class MyController {

    /**
     * Request handler for home page.
     *
     * @return str
     */
    @RequestMapping(method = RequestMethod.GET, value = "/home")
    public String homeRequest() {
        return "welcome";
    }

    /**
     * Request handler for login page.
     *
     * @param m
     *            model
     * @return str
     */
    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String loginRequest(final Model m) {

        m.addAttribute("login", new Login());
        return "login";
    }

    /**
     * Request handler for login page submit.
     *
     * @param login param
     * @param m model
     * @return str val
     */
    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String loginSubmitRequest(
       @ModelAttribute(value = "login") final Login login, final Model m) {

        String retVal;

        if (login.getUsername().equals("test")
                && (login.getPwd().equals("password"))) {

            retVal = "welcome";
        } else {
            retVal = "error";
        }


        return retVal;
    }
}
