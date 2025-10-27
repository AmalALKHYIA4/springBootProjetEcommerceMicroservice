package com.ecom.app.services;


import com.ecom.app.dtos.ProductRequest;
import com.ecom.app.dtos.ProductResponse;
import com.ecom.app.mapper.ProductMapper;
import com.ecom.app.models.Product;
import com.ecom.app.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor //contsructeur contient les champs final et non null

public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper ;

    public List<ProductResponse> fetchAllProducts() {
        return productRepository.findByActiveTrue().stream()
                .map(productMapper :: toResponse)
                .collect(Collectors.toList());
    }

    public ProductResponse fetchProductById(Long id){
        return productRepository.findById(id)
                .map(productMapper :: toResponse)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé"));


    }

    public ProductResponse addProduct (ProductRequest productRequest){

        Product product = productMapper.toEntity(productRequest);
        Product saved = productRepository.save(product);
        return productMapper.toResponse(saved);

    }

    public ProductResponse updateProduct (Long id , ProductRequest productRequest){
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé"));
        productMapper.updateEntityFromDto(productRequest, existingProduct);

        Product updated = productRepository.save(existingProduct);
        return productMapper.toResponse(updated);
    }

    public void deleteProduct(Long id) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé"));
        productRepository.delete(existingProduct);
    }


    public List<ProductResponse> searchProducts(String keyword) {
        return productRepository.searchProducts(keyword)
                .stream()
                .map(productMapper::toResponse)
                .collect(Collectors.toList());
    }




}
