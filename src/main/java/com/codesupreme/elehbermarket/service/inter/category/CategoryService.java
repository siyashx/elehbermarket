package com.codesupreme.elehbermarket.service.inter.category;


import com.codesupreme.elehbermarket.dto.category.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto dto);
    List<CategoryDto> getAllCategories();
    CategoryDto getCategoryById(Long id);
    void deleteCategory(Long id);
    CategoryDto updateCategory(Long id, CategoryDto dto);
}