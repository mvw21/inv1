package web;

import domain.service.ProductServiceModel;
import domain.view.ViewModel;
import service.ProductService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/products/all")
public class ProductsAllServlet extends HttpServlet {
    private final ProductService productService;

    @Inject
    public ProductsAllServlet(ProductService productService) {
        this.productService = productService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductServiceModel> allProducts = productService.getAll();
        ViewModel<List<ProductServiceModel>> model = new ViewModel<>(allProducts);
        req.setAttribute("model", model);
        req.getRequestDispatcher("/products-all.jsp").forward(req, resp);

    }
}
