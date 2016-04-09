package ro.tremend.poets.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.tremend.poets.config.FridgeNsaApplication;
import ro.tremend.poets.service.ItemService;
import ro.tremend.poets.service.RecipeService;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
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
    public String provideUploadInfo(Model model) throws IOException {
        File rootFolder = new File(FridgeNsaApplication.ROOT);
        List<String> fileNames = Arrays.stream(rootFolder.listFiles())
                .map(f -> f.getName())
                .collect(Collectors.toList());

        model.addAttribute("files", fileNames);
        return "uploadForm";

        }
    }
