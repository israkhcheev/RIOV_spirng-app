package ru.rakhcheev.api.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.rakhcheev.api.dto.ShopRegistry;
import ru.rakhcheev.api.entity.Shop;
import ru.rakhcheev.api.service.ShopService;

import java.util.List;

@Controller
@RequestMapping("shop")
@CrossOrigin
public class ShopController {

    private final ShopService shopService;
    @Autowired
    public ShopController(ShopService shopService){
        this.shopService = shopService;
    }

    @GetMapping
    public ResponseEntity<List<Shop>> getAllElement() {
        try {
            return ResponseEntity.ok(shopService.getAllShop());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shop> getElement(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(shopService.getShopById(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<Shop> createElement(@RequestBody ShopRegistry element) {
        try {
            return ResponseEntity.ok(shopService.createShop(element));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shop> updateElement(@PathVariable Long id, @RequestBody Shop element) {
        try {
            return ResponseEntity.ok(shopService.updateShop(id, element));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteElement(@PathVariable Long id) {
        try {
            shopService.deleteShop(id);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


}
