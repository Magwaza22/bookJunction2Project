package za.ac.cput.controller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import za.ac.cput.domain.Notification;
import za.ac.cput.service.NotificationService;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotificationControllerTest {
 /* @Mock
    private NotificationService service;

    @InjectMocks
    private NotificationController controller;

    private MockMvc mockMvc;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void save()throws Exception {
        Notification notification = new Notification();
        notification.setId(1);
        notification.setMessage("Test notification");

        when(service.create(any(Notification.class))).thenReturn(notification);

        mockMvc.perform(post("/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"message\":\"Test notification\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Test notification"));

        ArgumentCaptor<Notification> notificationCaptor = ArgumentCaptor.forClass(Notification.class);
        verify(service).create(notificationCaptor.capture());
        assertEquals(notification.getMessage(), notificationCaptor.getValue().getMessage());
    }

    @Test
    void read() throws Exception{
        Notification notification = new Notification();
        notification.setId(1);
        notification.setMessage("Test notification");

        when(service.read(anyInt())).thenReturn(notification);

        mockMvc.perform(get("/read/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Test notification"));
    }

    @Test
    void deleteByID() throws Exception{
        mockMvc.perform(delete("/deletebyid/1"))
                .andExpect(status().isOk());

        verify(service).delete(1);
    }

    @Test
    void getAll() throws Exception{
        Notification notification1 = new Notification();
        notification1.setId(1);
        notification1.setMessage("Notification 1");

        Notification notification2 = new Notification();
        notification2.setId(2);
        notification2.setMessage("Notification 2");

        List<Notification> notifications = Arrays.asList(notification1, notification2);

        when(service.getall()).thenReturn(notifications);

        mockMvc.perform(get("/getall"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].message").value("Notification 1"))
                .andExpect(jsonPath("$[1].message").value("Notification 2"));
    }*/
}