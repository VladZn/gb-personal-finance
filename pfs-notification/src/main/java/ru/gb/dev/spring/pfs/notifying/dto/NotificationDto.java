package ru.gb.dev.spring.pfs.notifying.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.gb.dev.spring.pfs.notifying.dto.base.Header;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Data
@XmlRootElement
@NoArgsConstructor
public class NotificationDto {

    @NotNull
    private Header header;

    private String id = "";

    private String login = "";

    private String email = "";

}
