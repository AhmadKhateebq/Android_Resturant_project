package com.example.resturantmanagment;

import android.content.Context;
import android.widget.Toast;

import com.example.resturantmanagment.dto.OrderDto;
import com.example.resturantmanagment.model.Customer;
import com.example.resturantmanagment.model.Employee;
import com.example.resturantmanagment.model.Item;
import com.example.resturantmanagment.model.Order;
import com.example.resturantmanagment.model.TempUser;
import com.example.resturantmanagment.model.enums.ROLE;
import com.example.resturantmanagment.model.enums.STATUS;
import com.example.resturantmanagment.resource.CustomerRes;
import com.example.resturantmanagment.resource.EmployeeRes;
import com.example.resturantmanagment.resource.ItemRes;
import com.example.resturantmanagment.resource.OrderItemRes;
import com.example.resturantmanagment.resource.OrderRes;
import com.example.resturantmanagment.resource.repository.CustomerRepository;
import com.example.resturantmanagment.resource.repository.EmployeeRepository;
import com.example.resturantmanagment.resource.repository.ItemRepository;
import com.example.resturantmanagment.resource.repository.OrderItemRepository;
import com.example.resturantmanagment.resource.repository.OrderRepository;
import com.example.resturantmanagment.service.ArrService;
import com.example.resturantmanagment.service.EmpService;
import com.example.resturantmanagment.service.OrderService;

import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static RestaurantService service;
    private final CustomerRepository customerRepository = CustomerRes.getInstance();
    private final EmployeeRepository employeeRepository = EmployeeRes.getInstance();
    private final ItemRepository itemRepository = ItemRes.getInstance();
    private final OrderItemRepository orderItemRepository = OrderItemRes.getInstance();
    private final OrderRepository orderRepository = OrderRes.getInstance();

    private RestaurantService() {
    }

    public static RestaurantService getInstance() {
        if (service == null) {
            synchronized (RestaurantService.class) {
                if (service == null) {
                    service = new RestaurantService();
                }
            }
        }
        return service;
    }

    public String[] ListToStringArray(List list) {
        return ArrService.toArray(list);
    }

    public Order addOrderForDelivery(List<Item> items, Customer customer) {
        return OrderService.addOrder(items, customer, true);
    }

    public Order addOrderForWithBoolean(List<Item> items, Customer customer, boolean out) {
        return OrderService.addOrder(items, customer, out);
    }

    public Order addOrderForService(List<Item> items, Customer customer) {
        return OrderService.addOrder(items, customer);
    }

    public List<OrderDto> getOrdersReportAsObject() {
        return OrderService.getAllOrders();
    }

    public ArrayList<String> getOrdersReportAsString() {
        return OrderService.ordersReport();
    }

    public List<OrderDto> getOrdersForEmployee(Employee employee) {
        return EmpService.getOrders(employee);
    }

    public Order getOrderById(int id) {
        return orderRepository.getOrder(id);
    }

    public List<Order> getOrderByUserId(int id) {
        return orderRepository.getByUserId(id);
    }

    public void changeOrderStatusByEmployee(Order order, Employee employee) {
        EmpService.changeOrderStatus(order, employee);
    }

    public void changeOrderStatusByManager(Order order, STATUS status) {
        EmpService.changeOrderStatus(order, status);
    }

    public void changeOrderStatusByRole(Order order, ROLE role) {
        EmpService.changeOrderStatus(order, role);
    }

    public boolean verifyCustomer(TempUser user) {
        return customerRepository.verify(user);
    }

    public Customer getCustomerByName(String name) {
        return customerRepository.findByName(name);
    }

    public Customer getCustomerByUsername(String name) {
        return customerRepository.findByUsername(name);
    }

    public Customer getCustomerById(int id) {
        return customerRepository.findById(id);
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.addCustomer(customer);
    }

    public Customer addCustomer(String name, String username, String password, String email, String phone) {
        return customerRepository.addCustomer(name, username, password, email, phone);
    }

    public boolean verifyEmployee(TempUser user) {
        return employeeRepository.verify(user);
    }

    public Item getItemByName(String name) {
        return itemRepository.findByName(name);
    }

    public Item getItemById(int id) {
        return itemRepository.findById(id);
    }
    public List<Item> getAllItems(){
        return itemRepository.getAllItems();
    }

    public void makeToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
