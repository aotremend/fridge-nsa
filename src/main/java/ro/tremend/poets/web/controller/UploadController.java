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

import java.io.*;
import java.util.ArrayList;
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
    public String provideUploadInfo(Model model) throws IOException {
        final String filename = "C:/Users/dion/Documents/GitHub/fridge-nsa/upload/my.txt";

        File rootFolder = new File(FridgeNsaApplication.ROOT);
        List<String> fileNames = Arrays.stream(rootFolder.listFiles())
                .map(f -> f.getName())
                .collect(Collectors.toList());


        BufferedReader br = new BufferedReader(new FileReader(filename));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            List<String> dataNum = new ArrayList<>();
            String LS = System.getProperty("line.separator");

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();

            dataNum.add(everything);
            System.out.print(dataNum);
            for (int i = 0; i < dataNum.size(); i++)
            model.addAttribute("items", dataNum);
        } finally {
            br.close();
        }
        return "uploadForm";

        }
    }
