/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.ProductDAO;
import excepciones.DBConexionExcepcion;
import java.util.*;
import modelo.Product;

/**
 *
 * @author juancamilo
 */
public class ControladorProduct {
    
    ProductDAO productDao;

    public ControladorProduct() {
        productDao = new ProductDAO();
    }
    
    public boolean Modificar(int idproduct, String name, String description, double price) throws DBConexionExcepcion{
      Product product = new Product (idproduct, name, description, price);
         return productDao.Modificar(product);
     }
    
    
    public List<String[]> selectProducts() throws DBConexionExcepcion {
        List<Product> products = productDao.seleccionar();
        List<String[]> productsReturn = new ArrayList<>();
        products.forEach( product -> {
            String cli[] = {String.valueOf(product.getIdProduct()), product.getName(), product.getDescription(), String.valueOf(product.getPrice())};
            productsReturn.add(cli);
        });
        return productsReturn;
    }
    
    public boolean createProduct(String name, String description, double price) throws DBConexionExcepcion {
        Product product = new Product(name, description, price);
        return productDao.insertar(product);
    }
    
    public Product selectProductById(int idPro) throws DBConexionExcepcion {
        return productDao.selectProductById(idPro);
    }
    
}
