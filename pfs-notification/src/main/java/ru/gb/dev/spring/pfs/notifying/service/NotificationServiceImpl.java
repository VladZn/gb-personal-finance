package ru.gb.dev.spring.pfs.notifying.service;

import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.dev.spring.pfs.notifying.exception.ErrorDatabase;
import ru.gb.dev.spring.pfs.notifying.model.Notification;
import ru.gb.dev.spring.pfs.notifying.repository.NotificationRepository;

import java.util.Optional;

@Service
public class NotificationServiceImpl implements NotificationService{

    @Autowired
    private NotificationRepository notificationRepository;

    @Nullable
    @Override
<<<<<<< HEAD
    @Transactional(propagation = Propagation.REQUIRED)
    public Notification save(Notification notification) throws ErrorDatabase {
       if (notification == null)
            throw new ErrorDatabase("Error save database, parameter 1 is null");
        return notificationRepository.save(notification);
=======
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = ErrorDatabase.class)
    public Notification save(Notification notification) {

        if (notification == null)
            throw new ErrorDatabase("Error save database, parameter 1 is null");
        return notificationRepository.save(notification);

>>>>>>> Add entities, dto, services
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
<<<<<<< HEAD
    public Notification findById(String id) throws ErrorDatabase{
=======
    public Notification findById(String id) {

>>>>>>> Add entities, dto, services
        if (id == null || id.isEmpty())
            throw new ErrorDatabase("Error save database, parameter 1 is null");
        Optional<Notification>  optionalNotification = notificationRepository.findById(id);
        if (optionalNotification.orElse(null) == null) return null;
        return optionalNotification.get();
<<<<<<< HEAD
=======

>>>>>>> Add entities, dto, services
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Iterable<Notification> findAll() {
        return notificationRepository.findAll();
    }

    @Override
<<<<<<< HEAD
    @Transactional(propagation = Propagation.SUPPORTS)
    public Iterable<Notification> findIsActive() {
        return notificationRepository.findIsActive();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Notification update(Notification notification) throws ErrorDatabase {
        return save(notification);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteById(String id) throws ErrorDatabase {
        if (id == null || id.isEmpty())
            throw new ErrorDatabase("Error save database, parameter 1 is null");
        notificationRepository.deleteById(id);
=======
    public Iterable<Notification> findIsActive() {
        return null;
    }

    @Override
    public Notification update(Notification notification) throws ErrorDatabase {
        return null;
    }

    @Override
    public void deleteById(String id) throws ErrorDatabase {

>>>>>>> Add entities, dto, services
    }

    @Override
    public void delete(Notification notification) throws ErrorDatabase {
<<<<<<< HEAD
        if (notification == null)
            throw new ErrorDatabase("Error save database, parameter 1 is null");
        notificationRepository.delete(notification);
=======

>>>>>>> Add entities, dto, services
    }
}
