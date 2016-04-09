package ro.tremend.poets.domain.repository;

import org.springframework.data.repository.CrudRepository;
import ro.tremend.poets.domain.model.Item;

import java.util.List;

/**
 * Created by Vlad on 09.04.2016.
 */
public interface ItemRepository extends CrudRepository<Item, Long>{
    Item findByCode(String code);
}
