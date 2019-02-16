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
public class OperationDto {

    @Nullable
    private String id;

    @Nullable
    private String comment;

    @Nullable
    private String amount;

    @Nullable
    private String date;

    @Nullable
    private String typeId;

    @Nullable
    private String accountId;

    @Nullable
    private String userId;

    @Nullable
    private String categoryId;

    @Nullable
    private String fileId;

    @Nullable
    private String counterpartId;

}
