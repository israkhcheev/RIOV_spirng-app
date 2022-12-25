package ru.rakhcheev.api.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.rakhcheev.api.entity.Element;
import ru.rakhcheev.api.service.ElementService;

import java.util.List;

@Controller
@RequestMapping("element")
@CrossOrigin
public class ElementController {

    private final ElementService elementService;
    @Autowired
    public ElementController(ElementService elementService){
        this.elementService = elementService;
    }

    @GetMapping
    public ResponseEntity<List<Element>> getAllElement() {
        try {
            return ResponseEntity.ok(elementService.getAllElements());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Element> getElement(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(elementService.getElementById(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<Element> createElement(@RequestBody Element element) {
        try {
            return ResponseEntity.ok(elementService.createElement(element));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Element> updateElement(@PathVariable Long id, @RequestBody Element element) {
        try {
            return ResponseEntity.ok(elementService.updateElement(id, element));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteElement(@PathVariable Long id) {
        try {
            elementService.deleteElement(id);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


}
