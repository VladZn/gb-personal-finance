package ru.gb.dev.spring.pfs.notifying.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.gb.dev.spring.pfs.notifying.dto.base.ResultDto;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Data
@XmlRootElement
@NoArgsConstructor
public class UserDto {

    @NotNull
    private ResultDto result;

    private String id = "";

    private boolean isActive;

    private String user_id = "";

    private Date date_time;

    private String title = "";

    private String body = "";

}
