package ru.gb.dev.spring.pfs.notifying.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Data
@XmlRootElement
@EqualsAndHashCode
@NoArgsConstructor
public class NotificationDtoCreate extends NotificationAbstractDto{

    private boolean isActive;

    @NotNull
    private String userId;

    @NotNull
    private Date dateTime;

    @NotNull
    private String title;

    @NotNull
    private String body;

    public NotificationDtoCreate(boolean isActive, String userId,
                                 Date dateTime,
                                 String title,
                                 String body) {
        this.isActive = isActive;
        this.userId = userId;
        this.dateTime = dateTime;
        this.title = title;
        this.body = body;
    }
}
