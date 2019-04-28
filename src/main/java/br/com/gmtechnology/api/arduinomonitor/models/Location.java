package br.com.gmtechnology.api.arduinomonitor.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "col_loc")
@Getter
@Setter
public class Location extends DocumentBase{

    @Id
    private String id;

    private String name;

    private Double latitude;

    private Double longitude;
}
