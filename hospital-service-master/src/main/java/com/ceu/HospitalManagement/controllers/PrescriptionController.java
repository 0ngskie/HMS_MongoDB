package com.ceu.HospitalManagement.controllers;

import com.ceu.HospitalManagement.entities.RO.PrescriptionRO;
import com.ceu.HospitalManagement.entities.RO.UserRO;
import com.ceu.HospitalManagement.services.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prescription")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.ok(prescriptionService.getAll());
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody PrescriptionRO prescriptionRO) {
        return ResponseEntity.ok(prescriptionService.save(prescriptionRO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable String id, @RequestBody PrescriptionRO updatedPrescription) {
        boolean updated = prescriptionService.update(id, updatedPrescription);
        if (updated) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        boolean deleted = prescriptionService.delete(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
