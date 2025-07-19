package com.codesupreme.elehbermarket.dao.category;

import com.codesupreme.elehbermarket.model.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
