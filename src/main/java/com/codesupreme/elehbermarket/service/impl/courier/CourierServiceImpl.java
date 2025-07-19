package com.codesupreme.elehbermarket.service.impl.courier;

import com.codesupreme.elehbermarket.dao.courier.CourierRepository;
import com.codesupreme.elehbermarket.dto.courier.CourierDto;
import com.codesupreme.elehbermarket.model.courier.Courier;
import com.codesupreme.elehbermarket.service.inter.courier.CourierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourierServiceImpl implements CourierService {

    private final CourierRepository courierRepository;

    private CourierDto toDto(Courier courier) {
        return CourierDto.builder()
                .id(courier.getId())
                .fullName(courier.getFullName())
                .phone(courier.getPhone())
                .imageUrl(courier.getImageUrl())
                .password(courier.getPassword())
                .isDisable(courier.getIsDisable())
                .createdAt(courier.getCreatedAt())
                .build();
    }

    private Courier toEntity(CourierDto dto) {
        return Courier.builder()
                .id(dto.getId())
                .fullName(dto.getFullName())
                .phone(dto.getPhone())
                .imageUrl(dto.getImageUrl())
                .password(dto.getPassword())
                .isDisable(dto.getIsDisable())
                .build();
    }

    @Override
    public CourierDto createCourier(CourierDto dto) {
        return toDto(courierRepository.save(toEntity(dto)));
    }

    @Override
    public CourierDto getCourierById(Long id) {
        return courierRepository.findById(id).map(this::toDto).orElse(null);
    }

    @Override
    public CourierDto login(String phone, String password) {
        Courier courier = courierRepository.findByPhoneAndPassword(phone, password)
                .orElseThrow(() -> new RuntimeException("İstifadəçi tapılmadı və ya şifrə yanlışdır"));
        return toDto(courier);
    }


    @Override
    public List<CourierDto> getAllCouriers() {
        return courierRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public CourierDto updateCourier(Long id, CourierDto dto) {
        return courierRepository.findById(id).map(courier -> {
            courier.setFullName(dto.getFullName());
            courier.setPhone(dto.getPhone());
            courier.setImageUrl(dto.getImageUrl());
            courier.setPassword(dto.getPassword());
            courier.setIsDisable(dto.getIsDisable());
            return toDto(courierRepository.save(courier));
        }).orElse(null);
    }

    @Override
    public void deleteCourier(Long id) {
        courierRepository.deleteById(id);
    }
}
