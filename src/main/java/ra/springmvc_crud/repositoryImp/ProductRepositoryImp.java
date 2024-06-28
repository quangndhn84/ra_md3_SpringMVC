package ra.springmvc_crud.repositoryImp;

import org.springframework.stereotype.Repository;
import ra.springmvc_crud.model.Product;
import ra.springmvc_crud.repository.ProductRepository;
import ra.springmvc_crud.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImp implements ProductRepository {
    @Override
    public List<Product> findAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Product> listProduct = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_all_product()}");
            ResultSet rs = callSt.executeQuery();
            listProduct = new ArrayList<>();
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getString("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setPrice(rs.getFloat("price"));
                product.setTitle(rs.getString("title"));
                product.setCatalogId(rs.getInt("catalog_id"));
                product.setStatus(rs.getBoolean("product_status"));
                listProduct.add(product);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listProduct;
    }

    @Override
    public boolean create(Product product) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call create_product(?,?,?,?,?,?)}");
            callSt.setString(1, product.getProductId());
            callSt.setString(2, product.getProductName());
            callSt.setFloat(3, product.getPrice());
            callSt.setString(4, product.getTitle());
            callSt.setInt(5, product.getCatalogId());
            callSt.setBoolean(6, product.isStatus());
            callSt.executeUpdate();
            result = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }
}
