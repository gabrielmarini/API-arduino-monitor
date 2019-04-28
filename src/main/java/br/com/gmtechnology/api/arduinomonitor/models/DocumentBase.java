package br.com.gmtechnology.api.arduinomonitor.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
class DocumentBase {

    private Boolean status;

    private Date createdAt;

    private Date lastUpdated;
}
