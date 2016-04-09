package ro.tremend.poets.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ro.tremend.poets.config.FridgeNsaApplication;
import ro.tremend.poets.domain.dto.ItemDto;
import ro.tremend.poets.domain.dto.RecipeDto;
import ro.tremend.poets.domain.model.Item;
import ro.tremend.poets.domain.model.Message;
import ro.tremend.poets.domain.model.Recipe;
import ro.tremend.poets.service.ItemService;
import ro.tremend.poets.service.RecipeService;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Vlad on 09.04.2016.
 */
@RestController
public class RequestController {;

    @Autowired
    ItemService itemService;

    @Autowired
    RecipeService recipeService;


    @RequestMapping(method = RequestMethod.POST, value = "/upload")
    public ItemDto handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (file.getOriginalFilename().contains("/")) {
//            throw new Message("error", "Folder separators not allowed");
            return null;
        }
        if (file.getOriginalFilename().contains("/")) {
//            return new Message("error", "Relative pathnames not allowed");
            return null;
        }

        if (!file.isEmpty()) {
            try {
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(new File(FridgeNsaApplication.ROOT + "/" + file.getOriginalFilename())));
                FileCopyUtils.copy(file.getInputStream(), stream);
                stream.close();



                Item item = itemService.findByCode("apple");
                return new ItemDto(item.getId(), item.getName(), item.getContent(), item.getImageUrl());
            }
            catch (Exception e) {
//                return new Message("error", "You failed to upload " + file.getOriginalFilename() + " => " + e.getMessage());
                return null;
            }
        }
        else {
//            return new Message("error", "You failed to upload " + file.getOriginalFilename() + " because the file was empty");
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getRecipes")
    public List<RecipeDto> getRecipes(@RequestParam("code") String code) {
        List<Recipe> recipes = recipeService.findByCode(code);

        List<RecipeDto> recipeDtos = new ArrayList<>();
        if(recipes.size() > 0) {
            recipeDtos.addAll(recipes.stream().map(recipe -> new RecipeDto(recipe.getId(), recipe.getName(), recipe.getContent(), recipe.getImageUrl())).collect(Collectors.toList()));
        }

        return  recipeDtos;
    }
}