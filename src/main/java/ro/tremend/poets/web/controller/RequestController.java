package ro.tremend.poets.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ro.tremend.poets.domain.model.dto.ItemDto;

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
}