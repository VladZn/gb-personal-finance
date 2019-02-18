package ru.gb.dev.spring.pfs.notifying.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
<<<<<<< HEAD
=======
import org.jetbrains.annotations.NotNull;
import ru.gb.dev.spring.pfs.notifying.dto.base.Header;

>>>>>>> Add entities, dto, services
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Data
@XmlRootElement
@NoArgsConstructor
public class UserDto {

<<<<<<< HEAD
=======
    @NotNull
    private Header header;

>>>>>>> Add entities, dto, services
    private String id = "";

    private boolean isActive;

    private String user_id = "";

    private Date date_time;

    private String title = "";

    private String body = "";

}
