package com.codesupreme.elehbermarket.service.impl.product;

import com.codesupreme.elehbermarket.dao.product.ProductRepository;
import com.codesupreme.elehbermarket.dto.product.ProductDto;
import com.codesupreme.elehbermarket.model.product.Product;
import com.codesupreme.elehbermarket.service.inter.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private ProductDto toDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .unit(product.getUnit())
                .imageUrl(product.getImageUrl())
                .category(product.getCategory())
                .build();
    }

    private Product toEntity(ProductDto dto) {
        return Product.builder()
                .id(dto.getId())
                .name(dto.getName())
                .price(dto.getPrice())
                .unit(dto.getUnit())
                .imageUrl(dto.getImageUrl())
                .category(dto.getCategory())
                .build();
    }

    @Override
    public ProductDto createProduct(ProductDto dto) {
        return toDto(productRepository.save(toEntity(dto)));
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductById(Long id) {
        return productRepository.findById(id).map(this::toDto).orElse(null);
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto dto) {
        return productRepository.findById(id).map(product -> {
            product.setName(dto.getName());
            product.setPrice(dto.getPrice());
            product.setUnit(dto.getUnit());
            product.setImageUrl(dto.getImageUrl());
            product.setCategory(dto.getCategory());
            return toDto(productRepository.save(product));
        }).orElse(null);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
