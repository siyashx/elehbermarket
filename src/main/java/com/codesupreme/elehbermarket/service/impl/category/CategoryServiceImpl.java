package com.codesupreme.elehbermarket.service.impl.category;

import com.codesupreme.elehbermarket.dto.category.CategoryDto;
import com.codesupreme.elehbermarket.model.category.Category;
import com.codesupreme.elehbermarket.dao.category.CategoryRepository;
import com.codesupreme.elehbermarket.service.inter.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private CategoryDto toDto(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .imageUrl(category.getImageUrl())
                .build();
    }

    private Category toEntity(CategoryDto dto) {
        return Category.builder()
                .id(dto.getId()) // create zamanı null ola bilər
                .name(dto.getName())
                .imageUrl(dto.getImageUrl())
                .build();
    }

    @Override
    public CategoryDto createCategory(CategoryDto dto) {
        Category category = toEntity(dto);
        Category saved = categoryRepository.save(category);
        return toDto(saved);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        return toDto(category);
    }

    @Override
    public void deleteCategory(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new RuntimeException("Category not found");
        }
        categoryRepository.deleteById(id);
    }

    @Override
    @Transactional
    public CategoryDto updateCategory(Long id, CategoryDto dto) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        category.setName(dto.getName());
        category.setImageUrl(dto.getImageUrl());

        return toDto(categoryRepository.save(category));
    }
}
