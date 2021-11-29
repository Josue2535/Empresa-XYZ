/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.OrderProductDAO;
import java.util.*;
import modelo.OrderProduct;

/**
 *
 * @author ADMIN
 */
public class ControladorOrderProduct {
    OrderProductDAO orderProductDao;

    public ControladorOrderProduct() {
        orderProductDao = new OrderProductDAO();
    }
    
    public List<String[]> selectOrderProduct() {
        List<OrderProduct> orders = orderProductDao.seleccionar();
        List<String[]> ordersReturn = new ArrayList<>();
        orders.forEach( orderProduct -> {
            String cli[] = {String.valueOf(orderProduct.getIdOrder()), String.valueOf(orderProduct.getIdProduct()), String.valueOf(orderProduct.getCantityProduct())};
            ordersReturn.add(cli);
        });
        return ordersReturn;
    }
    
    public int createOrderProduct(ArrayList<OrderProduct> orderProducts) {
        
        for(int i = 0; i<orderProducts.size(); i++){
            orderProductDao.insertar(orderProducts.get(i));
        }
        return -1;
    }
}