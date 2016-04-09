package ro.tremend.poets.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.tremend.poets.config.FridgeNsaApplication;
import ro.tremend.poets.domain.model.Item;
import ro.tremend.poets.domain.model.Recipe;
import ro.tremend.poets.service.ItemService;
import ro.tremend.poets.service.ItemServiceImpl;
import ro.tremend.poets.service.RecipeService;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Vlad on 09.04.2016.
 */
@Controller
public class UploadController {
    @Autowired
    ItemService itemService;

    @Autowired
    RecipeService recipeService;

    @RequestMapping(method = RequestMethod.GET, value = "/upload")
    public String provideUploadInfo(Model model) {
        File rootFolder = new File(FridgeNsaApplication.ROOT);
        List<String> fileNames = Arrays.stream(rootFolder.listFiles())
                .map(f -> f.getName())
                .collect(Collectors.toList());

        model.addAttribute("files",
                Arrays.stream(rootFolder.listFiles())
                        .sorted(Comparator.comparingLong(f -> -1 * f.lastModified()))
                        .map(f -> f.getName())
                        .collect(Collectors.toList())
        );

        Item items = itemService.findByCode("apple");
        List<Recipe> recipes = recipeService.findByCode("appleeee");

        return "uploadForm";
    }
}
