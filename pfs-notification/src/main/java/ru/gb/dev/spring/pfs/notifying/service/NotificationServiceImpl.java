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
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = ErrorDatabase.class)
    public Notification save(Notification notification) {
       if (notification == null)
            throw new ErrorDatabase("Error save database, parameter 1 is null");
        return notificationRepository.save(notification);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Notification findById(String id) {
        if (id == null || id.isEmpty())
            throw new ErrorDatabase("Error save database, parameter 1 is null");
        Optional<Notification>  optionalNotification = notificationRepository.findById(id);
        if (optionalNotification.orElse(null) == null) return null;
        return optionalNotification.get();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Iterable<Notification> findAll() {
        return notificationRepository.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Iterable<Notification> findIsActive() {
        return notificationRepository.findIsActive();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, noRollbackFor = ErrorDatabase.class)
    public Notification update(Notification notification) {
        return save(notification);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, noRollbackFor = ErrorDatabase.class)
    public void deleteById(String id)  {
        if (id == null || id.isEmpty())
            throw new ErrorDatabase("Error save database, parameter 1 is null");
        notificationRepository.deleteById(id);
    }

    @Override
    public void delete(Notification notification) throws ErrorDatabase {
        if (notification == null)
            throw new ErrorDatabase("Error save database, parameter 1 is null");
        notificationRepository.delete(notification);
    }
}
