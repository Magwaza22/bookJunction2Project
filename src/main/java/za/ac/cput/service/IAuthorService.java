package za.ac.cput.service;

import za.ac.cput.domain.Author;
import java.util.List;


public interface IAuthorService  extends IService<Author, String>{
    List<Author> getall();
}
