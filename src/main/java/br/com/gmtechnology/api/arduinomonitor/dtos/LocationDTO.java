package br.com.gmtechnology.api.arduinomonitor.dtos;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class LocationDTO extends DocumentBaseDTO {

    @Id
    private String id;

    @NotBlank
    private String name;

    @NonNull
    private Double latitude;

    @NotNull
    private Double longitude;
}
