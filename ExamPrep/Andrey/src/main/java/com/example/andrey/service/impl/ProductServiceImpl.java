package com.example.andrey.service.impl;

import com.example.andrey.model.entity.Product;
import com.example.andrey.model.service.ProductServiceModel;
import com.example.andrey.model.view.ProductViewModel;
import com.example.andrey.repository.ProductRepository;
import com.example.andrey.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductServiceModel addProduct(ProductServiceModel productServiceModel) {
        Product product = modelMapper
                .map(productServiceModel, Product.class);

        productRepository.save(product);

        return modelMapper.map(product, ProductServiceModel.class);
    }

    @Override
    public List<ProductViewModel> findAllProducts() {
       return productRepository.findAll()
                .stream()
               .sorted(Comparator.comparing(Product::getCategory))
                .map(product -> modelMapper.map(product, ProductViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductViewModel findProduct(Long id) {
        return modelMapper.map(productRepository.findById(id), ProductViewModel.class);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
