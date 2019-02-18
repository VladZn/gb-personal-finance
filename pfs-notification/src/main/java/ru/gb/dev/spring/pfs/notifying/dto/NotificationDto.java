package ru.gb.dev.spring.pfs.notifying.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
<<<<<<< HEAD

import javax.xml.bind.annotation.XmlRootElement;
=======
import org.jetbrains.annotations.NotNull;
import ru.gb.dev.spring.pfs.notifying.dto.base.Header;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
>>>>>>> Add entities, dto, services

@Data
@XmlRootElement
@NoArgsConstructor
public class NotificationDto {

<<<<<<< HEAD
=======
    @NotNull
    private Header header;

>>>>>>> Add entities, dto, services
    private String id = "";

    private String login = "";

    private String email = "";

}
