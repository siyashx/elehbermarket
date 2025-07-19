package com.codesupreme.elehbermarket.dao.courier;

import com.codesupreme.elehbermarket.model.courier.Courier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourierRepository extends JpaRepository<Courier, Long> {

    Optional<Courier> findByPhoneAndPassword(String phone, String password);

}
