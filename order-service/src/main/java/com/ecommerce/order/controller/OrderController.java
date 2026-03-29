
package com.ecommerce.order.controller;

import com.ecommerce.order.client.InventoryClient;
import com.ecommerce.order.kafka.OrderProducer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

 private final InventoryClient inventoryClient;
 private final OrderProducer producer;

 public OrderController(InventoryClient inventoryClient,OrderProducer producer){
  this.inventoryClient = inventoryClient;
  this.producer = producer;
 }

 @PostMapping("/{product}")
 @CircuitBreaker(name="inventory", fallbackMethod="fallback")
 public String placeOrder(@PathVariable String product){
  boolean inStock = inventoryClient.checkStock(product);
  if(inStock){
   producer.sendOrderEvent("Order-placed");
   return "Order placed for " + product;
  }
  return "Product out of stock";
 }

 public String fallback(String product, Exception e){
  return "Inventory service unavailable. Try later.";
 }
}
