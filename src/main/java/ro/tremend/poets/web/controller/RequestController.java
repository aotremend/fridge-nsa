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
import ro.tremend.poets.domain.model.Recipe;
import ro.tremend.poets.service.ImageProcessingService;
import ro.tremend.poets.service.ItemService;
import ro.tremend.poets.service.RecipeService;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Vlad on 09.04.2016.
 */
@RestController
public class RequestController {

    @Autowired
    ItemService itemService;

    @Autowired
    RecipeService recipeService;

    @Autowired
    ImageProcessingService imageProcessingService;

    @RequestMapping(method = RequestMethod.POST, value = "/upload")
    public List<ItemDto> handleFileUpload(@RequestParam("file") MultipartFile file) {
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

                List<String> itemCodes = imageProcessingService.processResult();
                List<ItemDto> itemDtos = new ArrayList<>();

                if(itemCodes.size() > 0) {
                    for (String itemCode : itemCodes) {
                        Item item = itemService.findByCode(itemCode);
                        if(item != null) {
                            itemDtos.add(new ItemDto(item.getId(), item.getName(), item.getDescription(), item.getImageUrl()));
                        }
                    }
                }

                return itemDtos;
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
    public Set<RecipeDto> getRecipes(@RequestParam("code") String code) {
//        code.split(",");
        List<Recipe> recipes = recipeService.findByCodeIn(code);

        Set<RecipeDto> recipeDtos = new HashSet<>();
        if(recipes.size() > 0) {
            recipeDtos.addAll(recipes.stream().map(recipe -> new RecipeDto(recipe.getId(), recipe.getName(), recipe.getContent(), recipe.getOtherProducts(), recipe.getImageUrl())).collect(Collectors.toList()));
        }

        return  recipeDtos;
    }
}