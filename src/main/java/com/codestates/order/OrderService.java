package com.codestates.order;

import com.codestates.coffee.CoffeeService;
import com.codestates.exception.BusinessLogicException;
import com.codestates.exception.ExceptionCode;
import com.codestates.member.MemberService;
import com.codestates.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    final private OrderRepository orderRepository;
    final private MemberService memberService;
    final private CoffeeService coffeeService;

    public OrderService(OrderRepository orderRepository, MemberService memberService, CoffeeService coffeeService){
        this.orderRepository = orderRepository;
        this.memberService = memberService;
        this.coffeeService = coffeeService;
    }

    public Order createOrder(Order order){
        memberService.findVerifiedMember(order.getMemberId().getId());

        order.getOrderCoffees()
                .stream()
                .forEach(coffeeRef -> {
                    coffeeService.findVerifiedCoffee(coffeeRef.getCoffeeId());
                });

        return orderRepository.save(order);
    }

    public Order findOrder(long orderId){

        return findVerifeidOrder(orderId);
    }

    public List<Order> findOrders(){

        return (List<Order>) orderRepository.findAll();
    }

    public void cancelOrder(long orderId){
        Order findOder = findVerifeidOrder(orderId);
        int step = findOder.getOrderStatus().getStepNumber();

        if(step>= 2) {
            throw new BusinessLogicException(ExceptionCode.CANNOT_CHANGE_ORDER);
        }

        findOder.setOrderStatus(Order.OrderStatus.ORDER_CANCEL);
        orderRepository.save(findOder);
    }

    private Order findVerifeidOrder(long orderId){
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        Order findOrder = optionalOrder.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.ORDER_NOT_FOUND));

        return findOrder;
    }
}
