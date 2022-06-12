package com.example.resturantmanagment.service;

import com.example.resturantmanagment.dto.OrderDto;
import com.example.resturantmanagment.model.Employee;
import com.example.resturantmanagment.model.Order;
import com.example.resturantmanagment.model.enums.ROLE;
import com.example.resturantmanagment.model.enums.STATUS;
import com.example.resturantmanagment.resource.OrderRes;
import com.example.resturantmanagment.resource.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

public class EmpService {
    static List<OrderDto> orders = OrderService.getAllOrders();
    private static OrderRepository orderRepository = OrderRes.getInstance();
    public static List<OrderDto> getOrders(Employee employee) {
        return switch (employee.getRole()) {
            case CHEF -> getChefOrders();
            case DELIVERY -> getDelOrders();
            case SERVICE -> getServOrders();
            case MANAGER -> getManagerOrders();
        };
    }

    private static List<OrderDto> getChefOrders() {
        List<OrderDto> list = new ArrayList<>();
        for (OrderDto order : orders) {
            if (order.getStatus() == STATUS.WAITING || order.getStatus() == STATUS.COOKING)
                list.add(order);
        }
        return list;
    }

    private static List<OrderDto> getServOrders() {
        List<OrderDto> list = new ArrayList<>();
        for (OrderDto order : orders) {
            if (order.getStatus() == STATUS.WAITING_TO_SERVE)
                list.add(order);
        }
        return list;
    }

    private static List<OrderDto> getDelOrders() {
        List<OrderDto> list = new ArrayList<>();
        for (OrderDto order : orders) {
            if (order.getStatus() == STATUS.WAITING_TO_PICKUP || order.getStatus() == STATUS.ON_THE_WAY)
                list.add(order);
        }
        return list;
    }

    private static List<OrderDto> getManagerOrders() {
        return orders;
    }

    public static void changeOrderStatus(Order order, STATUS status) {
        orderRepository.getOrder(order.getId()).setStatus(status);
        order.setStatus(status);
    }

    public static void changeOrderStatus(Order order, Employee employee) {
        changeOrderStatus(order, employee.getRole());
    }

    public static void changeOrderStatus(Order order, ROLE role) {
        if (role == ROLE.CHEF) {
            if (order.getStatus() == STATUS.WAITING)
                changeOrderStatus(order, STATUS.COOKING);
            else if (order.getStatus() == STATUS.COOKING && order.isOutside())
                changeOrderStatus(order, STATUS.WAITING_TO_PICKUP);
            else if (order.getStatus() == STATUS.COOKING && !order.isOutside())
                changeOrderStatus(order, STATUS.WAITING_TO_SERVE);

        }
        if (role == ROLE.SERVICE) {
            if (!order.isOutside())
                if (order.getStatus() == STATUS.WAITING_TO_SERVE)
                    changeOrderStatus(order, STATUS.DONE);
        }
        if (role == ROLE.DELIVERY) {
            if (order.isOutside()) {
                if (order.getStatus() == STATUS.WAITING_TO_PICKUP)
                    changeOrderStatus(order, STATUS.ON_THE_WAY);
                else if (order.getStatus() == STATUS.ON_THE_WAY)
                    changeOrderStatus(order, STATUS.DONE);
            }
        }

    }
}
