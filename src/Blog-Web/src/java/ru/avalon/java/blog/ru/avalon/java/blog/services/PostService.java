package ru.avalon.java.blog.ru.avalon.java.blog.services;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import ru.avalon.java.blog.entities.Publication;
import ru.avalon.java.blog.entities.User;
import ru.avalon.java.blog.exceptions.ValidationException;
import static ru.avalon.java.blog.helpers.Validation.require;
import static ru.avalon.java.blog.helpers.Validation.requireNonNull;
import ru.avalon.java.blog.service.PublicationService;

@Stateless

public class PostService {
    
    @EJB PublicationService publicationService;
    
    @Inject HttpSession session;
    
    public List<Publication> getAllPublications(){           
       return publicationService.findAll();            
    }
    
    public void createPublication(String title, String content) throws ValidationException{
        require(title, "Header is required!");
        require(content, "Text is required!");
        
        User user = (User) session.getAttribute("author");
        Publication publication = new Publication(title, content, user);
        publicationService.create(publication);   
    }
    
    public void editPublications(String title, String content, String id) throws ValidationException {
        require(title, "Title is required");
        require(content, "Content is required");
        require(id, "Id is required");
        Publication publication = publicationService.findPublicationById(Long.getLong(id));
        requireNonNull(publication, "Publication not found");
        publication.setTitle(title);
        publication.setContent(content);
        publicationService.update(publication);
    }
}
