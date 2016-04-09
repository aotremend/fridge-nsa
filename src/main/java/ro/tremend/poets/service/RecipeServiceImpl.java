package ro.tremend.poets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tremend.poets.domain.model.Recipe;
import ro.tremend.poets.domain.repository.RecipeRepository;

import java.util.List;

/**
 * Created by Vlad on 09.04.2016.
 */
@Service
public class RecipeServiceImpl implements RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public List<Recipe> findByCode(String code) {
        return recipeRepository.findByItemsCode(code);
    }
}
