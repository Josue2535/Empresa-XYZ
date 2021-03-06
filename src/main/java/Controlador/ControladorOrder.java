/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.OrderDAO;
import excepciones.DBConexionExcepcion;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import modelo.Client;
import modelo.Order;

/**
 *
 * @author juancamilo
 */
public class ControladorOrder {
    OrderDAO orderDao;

    public ControladorOrder() {
        orderDao = new OrderDAO();
    }
    
    public List<String[]> selectOrders() throws DBConexionExcepcion {
        List<Order> orders = orderDao.seleccionar();
        List<String[]> ordersReturn = new ArrayList<>();
        orders.forEach( order -> {
            String cli[] = {String.valueOf(order.getIdOrder()), order.getDateOrder().toString(), String.valueOf(order.getIdClient().getIdClient()), String.valueOf(order.getIdClient().getFullName())};
            ordersReturn.add(cli);
        });
        return ordersReturn;
    }
    
    public boolean createOrder(int idClient, int idOrder) throws DBConexionExcepcion {
        LocalDate todayLocalDate = LocalDate.now( ZoneId.of( "America/Montreal" ) );
        java.sql.Date sqlDate = java.sql.Date.valueOf( todayLocalDate );
        Order order = new Order(idOrder, sqlDate, new Client(idClient));
        return orderDao.insertar(order);
    }
    
    public int getLastOrderId() throws DBConexionExcepcion {
        return orderDao.lastOrderId();
    }
    
    public Order selectOrderById(int id) throws DBConexionExcepcion{
        return orderDao.selectOrderById(id);
    }
}
