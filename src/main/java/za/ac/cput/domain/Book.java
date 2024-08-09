package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    private Long bookID;
    private String ISBN;
    private String title;
    private String edition;



}
