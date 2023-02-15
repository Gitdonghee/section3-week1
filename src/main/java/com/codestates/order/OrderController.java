package com.codestates.order;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping(value = "/v1/orders", produces = {MediaType.APPLICATION_JSON_VALUE})
class OrderController {

    @PostMapping
    public ResponseEntity postOrder(HttpServletRequest httpServletRequest,
                                    @RequestParam("memberId") long memberId,
                                    @RequestParam("coffeeId") long coffeeId){
        System.out.println("# user-agent : " + httpServletRequest.getHeader("user-agent"));
        System.out.println("# memberId : " + memberId);
        System.out.println("# coffeeId : " + coffeeId);

        Map<String, Object> map = new HashMap<>();
        map.put("memberId", memberId);
        map.put("coffeeID", coffeeId);

        return new ResponseEntity<>(new Order(memberId, coffeeId), HttpStatus.CREATED);
    }
    @GetMapping("/{order-id}")
    public ResponseEntity getOrder(@PathVariable("order-id") long orderId) {
        System.out.println("# orderId: " + orderId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getOrders() {
        System.out.println("# get Orders");

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
