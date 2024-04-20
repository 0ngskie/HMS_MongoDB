package com.ceu.HospitalManagement.controllers;

import com.ceu.HospitalManagement.entities.RO.UserRO;
import com.ceu.HospitalManagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody UserRO userRO) {
        return ResponseEntity.ok(userService.save(userRO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable String id, @RequestBody UserRO updatedUser) {
        boolean updated = userService.update(id, updatedUser);
        if (updated) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        boolean deleted = userService.delete(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
