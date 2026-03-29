
package com.ecommerce.order.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="inventory-service")
public interface InventoryClient {
 @GetMapping("/inventory/{product}")
 boolean checkStock(@PathVariable("product") String product);
}
