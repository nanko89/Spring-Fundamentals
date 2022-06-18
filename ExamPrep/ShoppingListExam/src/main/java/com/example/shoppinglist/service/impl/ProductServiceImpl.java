package com.example.shoppinglist.service.impl;

import com.example.shoppinglist.model.entity.Category;
import com.example.shoppinglist.model.entity.Product;
import com.example.shoppinglist.model.entity.enums.CategoryName;
import com.example.shoppinglist.model.service.ProductServiceModel;
import com.example.shoppinglist.model.view.ProductViewModel;
import com.example.shoppinglist.repository.ProductRepository;
import com.example.shoppinglist.service.CategoryService;
import com.example.shoppinglist.service.ProductService;
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
    public boolean isFreeName(String name) {
        return this.productRepository
                .findByNameIgnoreCase(name)
                .isEmpty();
    }

    @Override
    public void addProduct(ProductServiceModel serviceModel) {
        Product product = modelMapper.map(serviceModel, Product.class);
        Category category = categoryService
                .findByName(serviceModel.getCategory());

        product.setCategory(category);
        productRepository.save(product);
    }

    @Override
    public List<ProductViewModel> findAllByCategoryName(CategoryName category) {
        return this.productRepository
                .findAllByCategory_Name(category)
                .stream()
                .map(product -> modelMapper.map(product, ProductViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public BigDecimal findTotalSum() {
        return productRepository.findTotalProductSum();
    }

    @Override
    public void buyProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void buyAll() {
        productRepository.deleteAll();
    }
}
