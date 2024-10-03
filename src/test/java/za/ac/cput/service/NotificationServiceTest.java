package za.ac.cput.service;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import za.ac.cput.domain.Notification;
import za.ac.cput.repository.NotificationRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;



class NotificationServiceTest {
    @InjectMocks
    private NotificationService notificationService;

    @Mock
    private NotificationRepository notificationRepository;

    private Notification notification;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        notification = new Notification();
        notification.getUserID(1);
        notification.setMessage("Test notification");
    }

    @Test
    void delete() {
        doNothing().when(notificationRepository).deleteById(anyInt());

        notificationService.delete(1); // Replace with actual service logic if needed.

        verify(notificationRepository, times(1)).deleteById(anyInt());


    }

    @Test
    void getall() {
        Notification notification2 = new Notification(); // Initialize another Notification
        notification2.setId(2);
        notification2.setMessage("Another test notification");

        List<Notification> notifications = Arrays.asList(notification, notification2);
        when(notificationRepository.findAll()).thenReturn(notifications);

        List<Notification> result = notificationService.getall();

        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(2);
        verify(notificationRepository, times(1)).findAll();
    }

    @Test
    void create() {
        when(notificationRepository.save(any(Notification.class))).thenReturn(notification);

        Notification created = notificationService.create(notification);

        assertThat(created).isNotNull();
        assertThat(created.getId()).isEqualTo(notification.getId());
        assertThat(created.getMessage()).isEqualTo(notification.getMessage());
        verify(notificationRepository, times(1)).save(notification);
    }

    @Test
    void read() {
        when(notificationRepository.findById(anyInt())).thenReturn(Optional.of(notification));

        Notification read = notificationService.read(1);

        assertThat(read).isNotNull();
        assertThat(read.getId()).isEqualTo(notification.getId());
        verify(notificationRepository, times(1)).findById(anyInt());
    }

    @Test
    void update() {
        when(notificationRepository.save(any(Notification.class))).thenReturn(notification);

        Notification updated = notificationService.update(notification);

        assertThat(updated).isNotNull();
        assertThat(updated.getId()).isEqualTo(notification.getId());
        assertThat(updated.getMessage()).isEqualTo(notification.getMessage());
        verify(notificationRepository, times(1)).save(notification);
    }
}