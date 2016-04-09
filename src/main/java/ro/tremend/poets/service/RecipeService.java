package ro.tremend.poets.service;

import ro.tremend.poets.domain.model.Recipe;

import java.util.List;

/**
 * Created by Vlad on 09.04.2016.
 */
public interface RecipeService {
    List<Recipe> findByCodeIn(String code);
}
