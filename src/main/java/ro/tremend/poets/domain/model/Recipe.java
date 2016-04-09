package ro.tremend.poets.domain.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Vlad on 09.04.2016.
 */

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String name;
    private String content;
    private String imageUrl;
    private String otherProducts;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Item> items;

    public Recipe() {
    }

    public Recipe(String name, String content, String imageUrl, String otherProducts, List<Item> items) {
        this.name = name;
        this.content = content;
        this.imageUrl = imageUrl;
        this.otherProducts = otherProducts;
        this.items = items;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOtherProducts() {
        return otherProducts;
    }

    public void setOtherProducts(String otherProducts) {
        this.otherProducts = otherProducts;
    }
}
