package com.codesupreme.elehbermarket.service.inter.courier;

import com.codesupreme.elehbermarket.dto.courier.CourierDto;

import java.util.List;

public interface CourierService {
    CourierDto createCourier(CourierDto dto);
    CourierDto getCourierById(Long id);
    CourierDto login(String phone, String password);
    List<CourierDto> getAllCouriers();
    CourierDto updateCourier(Long id, CourierDto dto);
    void deleteCourier(Long id);
}
