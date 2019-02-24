package ru.gb.dev.spring.pfs.notifying.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;


@Data
@NoArgsConstructor
@XmlRootElement
public class NotificationDtoUpdate {

    private String id;

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
