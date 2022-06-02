package com.example.andrey.service;


import com.example.andrey.model.service.ItemServiceModel;
import com.example.andrey.model.view.ItemViewModel;

import java.util.List;

public interface ItemService {
    boolean findByName(String name);

    void addItem(ItemServiceModel itemServiceModel);

    List<ItemViewModel> findAllItems();

    ItemViewModel findById(Long id);

    void deleteItemById(Long id);
}
