package ru.gb.dev.spring.pfs.notifying.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;


@Data
@XmlRootElement
@NoArgsConstructor
public class NotificationDtoDelete extends NotificationAbstractDto{

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

    public NotificationDtoDelete(String id, boolean isActive, @NotNull String userId,
                                 @NotNull Date dateTime, @NotNull String title,
                                 @NotNull String body) {
        this.id = id;
        this.isActive = isActive;
        this.userId = userId;
        this.dateTime = dateTime;
        this.title = title;
        this.body = body;
    }
}
