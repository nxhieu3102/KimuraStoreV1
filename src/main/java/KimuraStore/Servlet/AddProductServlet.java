package KimuraStore.Servlet;

import KimuraStore.Dto.ProductDto;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 50, // 50MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB

@WebServlet({"/uploadFile", "/edit/product/*"})
public class AddProductServlet extends HttpServlet {
    private final String UPLOAD_DIRECTORY = "C:\\Users\\xuan hieu\\Desktop\\KimuraStoreV1\\src\\main\\webapp\\assets\\user\\img\\product";
    private static String DB_URL = "jdbc:mysql://awseb-e-qwiefjt75x-stack-awsebrdsdatabase-klbjyadl6wmx.cqsg8ic72rmk.us-west-2.rds.amazonaws.com:3306/kimurastore";
    private static String USER_NAME = "root";
    private static String PASSWORD = "Nopainnogain:3";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String pathInfo = request.getRequestURI();
        int id = -1;
        if (pathInfo.contains("edit")) {
            String[] pathParts = pathInfo.split("/");
            id = Integer.parseInt(pathParts[pathParts.length - 1]);
        }

        ProductDto product = new ProductDto();

        if (id != -1) {
            product = GetProductById(id);
            DeleteProduct(id);
        }

        product.setName(request.getParameter("name"));
        product.setPrice(Double.parseDouble(request.getParameter("price")));
        product.setCategory_id(Integer.parseInt(request.getParameter("category")));
        product.setDetail(request.getParameter("detail"));

        Double discountRate = 0.0;
        Double discountMoney = 0.0;

        try {
            discountRate = Double.parseDouble(request.getParameter("discount-rate"));
        } catch (Exception e) {
            discountRate = null;
        }

        try {
            discountMoney = Double.parseDouble(request.getParameter("discount-money"));
        } catch (Exception e) {
            discountMoney = null;
        }

        if(discountMoney == null && discountRate == null) {
            discountMoney = 0.0;
            discountRate = 0.0;
        }
        try {
            Part part = request.getPart("image");
            String fileName = Path.of(part.getSubmittedFileName()).getFileName().toString();

            fileName = fileName.toLowerCase();
            if(!fileName.equals("")) {
                product.setImage(fileName);
                part.write(UPLOAD_DIRECTORY + "\\" + fileName);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        product = HandleDiscount(product, discountMoney, discountRate);
        AddProduct(product);
        response.sendRedirect("/admin/product");
    }

    private ProductDto GetProductById(int id){
        try {
            // connect to database 'testdb'
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
            Statement stmt = conn.createStatement();
            // get data from table 'student'
            ProductDto product = new ProductDto();
            String sql = "SELECT * FROM product WHERE id = " + id;
            ResultSet resultSet =  stmt.executeQuery(sql);
            while(resultSet.next()) {
                product.setImage(resultSet.getString("image"));
                product.setId(id);
            }
            // close connection
            conn.close();
            return product;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    private void DeleteProduct(int id) {
        try {
            // connect to database 'testdb'
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
            Statement stmt = conn.createStatement();
            // get data from table 'student'
            String sql = "DELETE FROM product WHERE id = " + id;
            stmt.executeUpdate(sql);
            // close connection
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private ProductDto HandleDiscount(ProductDto product, Double discountMoney, Double discountRate) {
        if (discountMoney != null || discountRate != null) {
            Double price = product.getPrice();
            if (discountMoney != null && discountMoney != 0.0) {
                discountRate = discountMoney / price * 100.0;
            } else {
                discountMoney = discountRate * price / 100.0;
            }
        }
        discountMoney = (double) Math.round(discountMoney);
        discountRate = (double) Math.round(discountRate);

        product.setDiscount_rate(discountRate);
        product.setDiscount_money(discountMoney);
        return product;
    }

    private void AddProduct(ProductDto product) {
        try {
            // connect to database 'testdb'
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
            Statement stmt = conn.createStatement();
            // get data from table 'student'
            String sql = "INSERT INTO product (category_id, name, price, detail, discount_money, discount_rate, image)" +
                    " VALUES (" +
                    product.getCategory_id() + ", '" +
                    product.getName() + "', " +
                    product.getPrice() + ", '" +
                    product.getDetail() + "', " +
                    product.getDiscount_money() + ", " +
                    product.getDiscount_rate() + ", '" +
                    product.getImage() +
                    "')";
            if (product.getId() != 0) {
                sql = "INSERT INTO product (id, category_id, name, price, detail, discount_money, discount_rate, image)" +
                        " VALUES (" +
                        product.getId() + ", " +
                        product.getCategory_id() + ", '" +
                        product.getName() + "', " +
                        product.getPrice() + ", '" +
                        product.getDetail() + "', " +
                        product.getDiscount_money() + ", " +
                        product.getDiscount_rate() + ", '" +
                        product.getImage() +
                        "')";
            }
            stmt.executeUpdate(sql);
            // close connection
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private Connection getConnection(String dbURL, String userName,
                                     String password) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
}
