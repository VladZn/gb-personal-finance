package ru.gb.dev.spring.pfs.notifying.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Data
@XmlRootElement
public class NotificationDtoCreate {

    private boolean isActive;

    @NotNull
    private String userId;

    @NotNull
    private Date dateTime;

    @NotNull
    private String title;

    @NotNull
    private String body;

}
