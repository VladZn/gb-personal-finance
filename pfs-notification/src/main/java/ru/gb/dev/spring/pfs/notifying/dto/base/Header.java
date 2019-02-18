package ru.gb.dev.spring.pfs.notifying.dto.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement
@NoArgsConstructor
@AllArgsConstructor
public class Header {

    @Nullable
    private boolean success = true;

    @Nullable
    private String message = "";

}
