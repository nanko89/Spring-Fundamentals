package com.example.andrey.service.impl;

import com.example.andrey.model.entity.Category;
import com.example.andrey.model.entity.Item;
import com.example.andrey.model.service.ItemServiceModel;
import com.example.andrey.model.view.ItemViewModel;
import com.example.andrey.repository.ItemRepository;
import com.example.andrey.service.CategoryService;
import com.example.andrey.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    public ItemServiceImpl(ItemRepository itemRepository, CategoryService categoryService, ModelMapper modelMapper) {
        this.itemRepository = itemRepository;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean findByName(String name) {
        return itemRepository
                .existsByName(name);
    }

    @Override
    public void addItem(ItemServiceModel itemServiceModel) {
        Category category = categoryService
                .findByCategoryName(itemServiceModel.getCategory());


        Item item = modelMapper
                .map(itemServiceModel, Item.class)
                .setCategory(category);

        itemRepository.save(item);
    }

    @Override
    public List<ItemViewModel> findAllItems() {
        return itemRepository
                .findAll()
                .stream()
                .map(item -> {
                    ItemViewModel itemViewModel = modelMapper
                            .map(item, ItemViewModel.class);
                    itemViewModel
                            .setImgUrl("/img/" + item.getGender().name() + "-" + item.getCategory().getName().name() + ".jpg");
                    return itemViewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public ItemViewModel findById(Long id) {

        Optional<Item> item = itemRepository.findById(id);

        ItemViewModel itemViewModel = modelMapper.map(item, ItemViewModel.class);

        itemViewModel.setImgUrl(String.format("/img/%s-%s.jpg",
                item.get().getGender().name(), item.get().getCategory().getName().name()));

        return itemViewModel;
    }

    @Override
    public void deleteItemById(Long id) {
        itemRepository.deleteById(id);
    }
}
