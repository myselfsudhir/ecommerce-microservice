
package com.ecommerce.inventory.controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
 @GetMapping("/{product}")
 public boolean checkStock(@PathVariable String product){
  return !product.equalsIgnoreCase("out-of-stock");
 }
}
