package web;

import domain.entity.enums.Type;
import domain.service.ProductServiceModel;
import service.ProductService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/products/create")
public class ProductsCreateServlet extends HttpServlet {

    private final ProductService productService;

    @Inject
    public ProductsCreateServlet(ProductService productService) {
        this.productService = productService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/products-create.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("product-name");
        String username = (String) req.getSession().getAttribute("username");
        String quantity = req.getParameter("quantity");
        Type type = Type.valueOf(req.getParameter("type").toUpperCase());

        ProductServiceModel product = productService.create(name, username , quantity, type);

        if (product == null) {
            resp.sendRedirect("/products/create");
        } else {
            resp.sendRedirect("/home");

        }

    }
}
