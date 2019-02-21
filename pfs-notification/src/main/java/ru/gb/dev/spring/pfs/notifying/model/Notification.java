package ru.gb.dev.spring.pfs.notifying.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.gb.dev.spring.pfs.notifying.model.base.AbstractBaseEntity;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "notification")
@EqualsAndHashCode(callSuper = true)
public class Notification extends AbstractBaseEntity {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_time", nullable = false)
    private Date date_time;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "body", nullable = false)
    private String body;

    public Notification(Date date_time, String title, String body) {
        this.date_time = date_time;
        this.title = title;
        this.body = body;
    }

}
