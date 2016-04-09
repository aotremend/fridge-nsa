package ro.tremend.poets.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Vlad on 09.04.2016.
 */
public class Message {
    @JsonProperty("status")
    private String status;

    @JsonProperty("message")
    private String message;

    public Message() {
    }

    public Message(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
