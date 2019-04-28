package br.com.gmtechnology.api.arduinomonitor.dtos;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
class DocumentBaseDTO {

    @NonNull
    private Boolean status;

    private Date createdAt;

    private Date lastUpdated;
}
