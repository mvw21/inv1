package web;

import service.UserService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users/login")
public class UsersLoginServlet extends HttpServlet {

    private final UserService userService;

    @Inject
    public UsersLoginServlet(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/users-login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean loggedIn = userService.login(username, password);

        if (loggedIn) {
            resp.sendRedirect("/home");
            req.getSession().setAttribute("username", username);
        } else {
            resp.sendRedirect("/users-login");
        }
}
}
