package com.venimarket.api.services;

import com.venimarket.api.domains.Customer;
import com.venimarket.api.domains.MethodPayment;
import com.venimarket.api.domains.Order;
import com.venimarket.api.dtos.OrderDto;
import com.venimarket.api.repositories.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CashRegisterService cashRegisterService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private MethodPaymentService methodPaymentService;
    @Autowired
    private StockService stockService;

    public Order createOrder(OrderDto orderDto) throws Exception {
       Order order = new Order();
       if(orderDto.id_customer() !=null){
           Customer customer = this.customerService.findCustomerById(orderDto.id_customer());
           order.setCustomer(customer);
       }
       MethodPayment methodPayment = this.methodPaymentService.findMethodPaymentById(orderDto.id_methodPayment());
       order.setMethodPayment(methodPayment);
       order.setSellDate(LocalDateTime.now());
       this.orderRepository.save(order);
       return order;
    }
    public Order findOrderById(Long id){
        return this.orderRepository.findOrderById(id)
                .orElseThrow(()-> new EntityNotFoundException("Order not found."));
    }
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orderList = this.orderRepository.findAll();
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }
}
