package ro.tremend.poets.web.controller;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ro.tremend.poets.config.FridgeNsaApplication;
import ro.tremend.poets.domain.dto.ItemDto;
import ro.tremend.poets.domain.model.Message;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Vlad on 09.04.2016.
 */
@RestController
public class RequestController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public ItemDto greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new ItemDto(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/upload")
    public Message handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (file.getOriginalFilename().contains("/")) {
            return new Message("error", "Folder separators not allowed");
        }
        if (file.getOriginalFilename().contains("/")) {
            return new Message("error", "Relative pathnames not allowed");
        }

        if (!file.isEmpty()) {
            try {
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(new File(FridgeNsaApplication.ROOT + "/" + file.getOriginalFilename())));
                FileCopyUtils.copy(file.getInputStream(), stream);
                stream.close();
                return new Message("success", "You successfully uploaded " + file.getOriginalFilename() + "!");
            }
            catch (Exception e) {
                return new Message("error", "You failed to upload " + file.getOriginalFilename() + " => " + e.getMessage());
            }
        }
        else {
            return new Message("error", "You failed to upload " + file.getOriginalFilename() + " because the file was empty");
        }
    }
}