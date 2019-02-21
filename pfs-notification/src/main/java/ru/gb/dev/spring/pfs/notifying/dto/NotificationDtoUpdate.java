package ru.gb.dev.spring.pfs.notifying.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gb.dev.spring.pfs.notifying.model.base.AbstractBaseEntity;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.UUID;


@Data
@XmlRootElement
public class NotificationDtoUpdate {

    private String id;

    private boolean isActive;

    @NotNull
    private String user_id;

    @NotNull
    private Date date_time;

    @NotNull
    private String title;

    @NotNull
    private String body;

    public String getId() {
        return id;
    }

}
