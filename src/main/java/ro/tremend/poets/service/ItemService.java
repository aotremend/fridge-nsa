package ro.tremend.poets.service;

import ro.tremend.poets.domain.model.Item;

import java.util.List;

/**
 * Created by Vlad on 09.04.2016.
 */
public interface ItemService {
    Item findByCode(String code);
}
