package ro.tremend.poets.domain.dto;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Created by Vlad on 09.04.2016.
 */
public class ItemDto {
    private long id;
    private String name;
    private String description;
    private String imageUrl;

    public ItemDto() {
    }

    public ItemDto(long id, String name, String description, String imageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
