package ru.gb.dev.spring.pfs.notifying.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import ru.gb.dev.spring.pfs.notifying.controller.service.RestPreconditions;
import ru.gb.dev.spring.pfs.notifying.dto.NotificationDtoCreate;
import ru.gb.dev.spring.pfs.notifying.dto.NotificationDtoDelete;
import ru.gb.dev.spring.pfs.notifying.dto.NotificationDtoUpdate;
import ru.gb.dev.spring.pfs.notifying.dto.service.HealthCheck;
import ru.gb.dev.spring.pfs.notifying.dto.util.ConvertUtil;
import ru.gb.dev.spring.pfs.notifying.dto.view.NotificationDtoView;
import ru.gb.dev.spring.pfs.notifying.exception.RecordNotFoundException;
import ru.gb.dev.spring.pfs.notifying.model.Notification;
import ru.gb.dev.spring.pfs.notifying.service.NotificationServiceImpl;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping("api/notify")
public class NotifyController {


    private final NotificationServiceImpl service;

    private final ModelMapper modelMapper;

    @Autowired
    public NotifyController(final NotificationServiceImpl service, final ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @GetMapping(value = "/health", produces = APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Health health(){
        return new HealthCheck().health();
    }

    @PostMapping(value = "/createNotify", produces = APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public NotificationDtoView createNotify(@Valid @RequestBody NotificationDtoCreate resource){

        RestPreconditions.checkFound(resource);
        Notification notificationOut = service.save(ConvertUtil.convertDtoToNotification(resource));

        return ConvertUtil.convertNotificationToDto(notificationOut, NotificationDtoView.class);

    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    public NotificationDtoView getNotifyById(@PathVariable("id") final String id){
        return service.findById(id)
                .map(notification -> ConvertUtil.convertNotificationToDto(notification, NotificationDtoView.class))
                .orElseThrow(() -> new RecordNotFoundException("Notify with id " + id + " not found"));
    }

    @GetMapping(value = "/getAllNotify", produces = APPLICATION_JSON_UTF8_VALUE)
    public List<NotificationDtoView> getAllNotify(){
        final Iterable<Notification> notifications = service.findAll();
        return StreamSupport
                .stream(notifications.spliterator(), false)
                .map(notify -> ConvertUtil.convertNotificationToDto(notify, NotificationDtoView.class))
                .collect(Collectors.toList());
    }

    @PutMapping(value = "/updateNotify", produces = APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public NotificationDtoView updateNotify(@Valid @RequestBody NotificationDtoUpdate resource){
        return ConvertUtil.convertNotificationToDto(
                service.update(ConvertUtil.convertDtoToNotification(resource)),
                NotificationDtoView.class);
    }

    @DeleteMapping(value = "/{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable("id") final String id){
        service.deleteById(id);
    }

    @DeleteMapping(produces = APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@Valid @RequestBody NotificationDtoDelete resource){
        service.delete(ConvertUtil.convertDtoToNotification(resource));
    }

}
