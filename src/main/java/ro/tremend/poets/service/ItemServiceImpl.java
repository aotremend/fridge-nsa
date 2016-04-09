package ro.tremend.poets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tremend.poets.domain.model.Item;
import ro.tremend.poets.domain.repository.ItemRepository;

import java.util.List;

/**
 * Created by Vlad on 09.04.2016.
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item findByCode(String code) {
        return itemRepository.findByCode(code);
    }
}
