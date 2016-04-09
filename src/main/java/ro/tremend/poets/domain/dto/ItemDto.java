package ro.tremend.poets.domain.dto;

/**
 * Created by Vlad on 09.04.2016.
 */
public class ItemDto {
    private final long id;
    private final String content;

    public ItemDto(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
