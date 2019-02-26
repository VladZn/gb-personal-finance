package ru.gb.dev.spring.pfs.notifying.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;
import java.util.Date;


@Data
@XmlRootElement
@NoArgsConstructor
public class NotificationDtoUpdate extends NotificationAbstractDto{

    @NotNull
    private String id;

    private Boolean isActive;

    @NotNull
    private String userId;

    @NotNull
    private LocalDateTime dateTime;

    @NotNull
    private String title;

    @NotNull
    private String body;

    public NotificationDtoUpdate(@NotNull String id, boolean isActive, @NotNull String userId,
                                 @NotNull LocalDateTime dateTime, @NotNull String title,
                                 @NotNull String body) {
        this.id = id;
        this.isActive = isActive;
        this.userId = userId;
        this.dateTime = dateTime;
        this.title = title;
        this.body = body;
    }
}
