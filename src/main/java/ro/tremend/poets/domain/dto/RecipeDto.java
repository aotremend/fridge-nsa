package ro.tremend.poets.domain.dto;

/**
 * Created by Vlad on 09.04.2016.
 */
public class RecipeDto {
    private long id;
    private String name;
    private String content;
    private String imageUrl;

    public RecipeDto() {
    }

    public RecipeDto(long id, String name, String content, String imageUrl) {
        this.id = id;
        this.name = name;
        this.content = content;
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
}
