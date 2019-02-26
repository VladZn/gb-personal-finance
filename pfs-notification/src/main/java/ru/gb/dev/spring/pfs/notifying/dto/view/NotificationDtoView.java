package ru.gb.dev.spring.pfs.notifying.dto.view;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.gb.dev.spring.pfs.notifying.dto.NotificationAbstractDto;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;

@Data
@XmlRootElement
@NoArgsConstructor
public class NotificationDtoView extends NotificationAbstractDto {

    @Getter
    @Setter
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

}
