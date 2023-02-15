package com.codestates.coffee;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping(value = "/v1/coffees", produces = {MediaType.APPLICATION_JSON_VALUE})
public class CoffeeController {
    @PostConstruct
    public void init() {
        Map<String, Object> coffee1 = new HashMap<>();
        long coffeeId = 1L;
        coffee1.put("coffeeId", coffeeId);
        coffee1.put("korName", "바닐라 라떼");
        coffee1.put("engName", "Vanilla Latte");
        coffee1.put("price", 4500);

    }
    @PostMapping
    public ResponseEntity postCoffee(@RequestBody CoffeePostDto coffeePostDto){
        System.out.println(" # engName : " + coffeePostDto.getEngName());
        System.out.println(" # korName : " + coffeePostDto.getKorName());
        System.out.println(" # price : " + coffeePostDto.getPrice());

        return new ResponseEntity<>(coffeePostDto, HttpStatus.CREATED);
    }

    @PatchMapping("/{coffee-id}")
    public ResponseEntity patchCoffee(@PathVariable("coffee-id")long coffeeId,
                                      @RequestBody CoffeePatchDto coffeePatchDto){
        coffeePatchDto.setCoffeeId(coffeeId);
        coffeePatchDto.setPrice(6000);

        return new ResponseEntity<>(coffeePatchDto, HttpStatus.OK);
    }
    @GetMapping("/{coffee-id}")
    public ResponseEntity getCoffee(@PathVariable("coffee-id")long coffeeId){
        System.out.println("# coffeeID : " + coffeeId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getCoffees(HttpEntity httpEntity){
        for (Map.Entry<String, List<String>> entry : httpEntity.getHeaders().entrySet()){
            System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());
        }
        System.out.println("# get Coffees");

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
