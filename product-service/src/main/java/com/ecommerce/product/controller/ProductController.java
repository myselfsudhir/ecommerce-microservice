
package com.ecommerce.product.controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/products")
public class ProductController {
 @GetMapping
 public List<String> getProducts(){
  return List.of("Laptop","Phone","Tablet");
 }
}
