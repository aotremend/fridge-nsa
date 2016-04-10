package ro.tremend.poets.service;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import ro.tremend.poets.config.FridgeNsaApplication;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vlad on 09.04.2016.
 */
@Service
public class ImageProcessingServiceImpl implements ImageProcessingService {
    @Override
    public List<String> processResult() {
        List<String> itemList = new ArrayList<>();
        File f;
        final String filePath = FridgeNsaApplication.ROOT + "/result.txt";
        do {
            f = new File(filePath);
        } while (!f.exists());

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                itemList.add(line);
            }
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }

        try {
            FileUtils.cleanDirectory(new File(FridgeNsaApplication.ROOT));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return itemList;
    }
}
