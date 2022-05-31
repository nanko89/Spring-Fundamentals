package com.example.shopinglistexam.service.impl;

import com.example.shopinglistexam.model.entity.Product;
import com.example.shopinglistexam.model.entity.enums.CategoryName;
import com.example.shopinglistexam.model.service.ProductServiceModel;
import com.example.shopinglistexam.model.view.ProductViewModel;
import com.example.shopinglistexam.repository.ProductRepository;
import com.example.shopinglistexam.service.CategoryService;
import com.example.shopinglistexam.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addProduct(ProductServiceModel productServiceModel) {
        Product product = modelMapper
                .map(productServiceModel, Product.class);

        product.setCategory(categoryService
                .findByName(productServiceModel.getCategory()));

        productRepository.save(product);
    }

    @Override
    public ProductServiceModel findByName(String name) {
        return modelMapper
                .map(productRepository.findByName(name), ProductServiceModel.class);
    }

    @Override
    public BigDecimal getTotalSum() {
        return productRepository.findTotalProductSum();
    }

    @Override
    public List<ProductViewModel> findAllProductByCategoryName(CategoryName categoryName) {
        return productRepository
                .findAllByCategory_Name(categoryName)
                .stream()
                .map(product -> modelMapper.map(product, ProductViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void buyProduct(String id) {
        productRepository
                .deleteById(id);
    }

    @Override
    public void buyAllProduct() {
        productRepository
                .deleteAll();;
    }
}
