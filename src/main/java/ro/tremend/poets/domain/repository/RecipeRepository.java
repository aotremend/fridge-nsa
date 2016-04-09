package ro.tremend.poets.domain.repository;

import org.springframework.data.repository.CrudRepository;
import ro.tremend.poets.domain.model.Recipe;

import java.util.List;

/**
 * Created by Vlad on 09.04.2016.
 */
public interface RecipeRepository  extends CrudRepository<Recipe, Long> {
    List<Recipe> findByItemsCode(String code);
}
