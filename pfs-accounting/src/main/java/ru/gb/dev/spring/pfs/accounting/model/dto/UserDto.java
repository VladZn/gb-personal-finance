package ru.gb.dev.spring.pfs.accounting.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class UserDto {

    @Nullable
    private String id;

    @Nullable
    private String login;

    @Nullable
    private String password;

    @Nullable
    private String email;

}
