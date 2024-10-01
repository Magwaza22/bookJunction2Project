package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Notification;
import za.ac.cput.repository.NotificationRepository;

import java.util.List;
@Service
public class NotificationService implements INotificationService{

private final NotificationRepository notificationRepository;
@Autowired
     NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public Void delete(Integer notificationID) {
        return null;
    }

    @Override
    public List<Notification> getall() {
        return notificationRepository.findAll();
    }

    @Override
    public Notification create(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public Notification read(Integer integer) {
        return notificationRepository.findById(integer).orElse(null);
    }

    @Override
    public Notification update(Notification notification) {
        return notificationRepository.save(notification) ;
    }
}
