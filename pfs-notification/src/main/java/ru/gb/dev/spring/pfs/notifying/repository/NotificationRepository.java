package ru.gb.dev.spring.pfs.notifying.repository;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.Query;
=======
>>>>>>> Add entities, dto, services
import org.springframework.stereotype.Repository;
import ru.gb.dev.spring.pfs.notifying.model.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, String> {

<<<<<<< HEAD
    @Query(value = "SELECT * FROM Notification n WHERE n.isActive = 1", nativeQuery = true)
    Iterable<Notification> findIsActive();

=======
>>>>>>> Add entities, dto, services
}
