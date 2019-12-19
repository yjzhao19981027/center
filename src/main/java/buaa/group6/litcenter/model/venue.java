package buaa.group6.litcenter.model;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class venue {
    @Field("id")
    private String id;
    private String raw;

    public String getId() {
        return id;
    }
    public String getRaw() {
        return raw;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setRaw(String raw) {
        this.raw = raw;
    }
}
