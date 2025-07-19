package com.codesupreme.elehbermarket.api.courier.controller;

import com.codesupreme.elehbermarket.dto.courier.CourierDto;
import com.codesupreme.elehbermarket.service.inter.courier.CourierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v9/courier")
@RequiredArgsConstructor
public class CourierController {

    private final CourierService courierService;

    @PostMapping
    public ResponseEntity<CourierDto> create(@RequestBody CourierDto dto) {
        return ResponseEntity.ok(courierService.createCourier(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<CourierDto> login(@RequestParam String phone, @RequestParam String password) {
        return ResponseEntity.ok(courierService.login(phone, password));
    }


    @GetMapping
    public ResponseEntity<List<CourierDto>> getAll() {
        return ResponseEntity.ok(courierService.getAllCouriers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourierDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(courierService.getCourierById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourierDto> update(@PathVariable Long id, @RequestBody CourierDto dto) {
        return ResponseEntity.ok(courierService.updateCourier(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        courierService.deleteCourier(id);
        return ResponseEntity.noContent().build();
    }
}
