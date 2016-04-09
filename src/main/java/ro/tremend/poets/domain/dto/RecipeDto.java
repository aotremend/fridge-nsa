package ro.tremend.poets.domain.dto;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Created by Vlad on 09.04.2016.
 */
@JsonRootName("recipe")
public class RecipeDto {
    private long id;
    private String name;
    private String content;
    private String otherProducts;
    private String imageUrl;

    public RecipeDto() {
    }

    public RecipeDto(long id, String name, String content, String otherProducts, String imageUrl) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.otherProducts = otherProducts;
        this.imageUrl = imageUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getOtherProducts() {
        return otherProducts;
    }

    public void setOtherProducts(String otherProducts) {
        this.otherProducts = otherProducts;
    }
}
