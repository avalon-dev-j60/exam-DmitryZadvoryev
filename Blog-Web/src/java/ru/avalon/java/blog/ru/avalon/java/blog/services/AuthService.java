
package ru.avalon.java.blog.ru.avalon.java.blog.services;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import ru.avalon.java.blog.service.UserService;
import static ru.avalon.java.blog.helpers.Validation.*;
import ru.avalon.java.blog.entities.User;
import ru.avalon.java.blog.exceptions.ValidationException;


@Stateless
public class AuthService {
    
    @EJB UserService userService;
    
    @Inject HttpSession session;
    
    public void signIn(String email, String password) throws ValidationException{
        require(email, "Email is required!");
        require(password, "Password is required!");
        User user = userService.findByEmail(email);
        requireNonNull(user, " User does not exist!");
        requireEquals(user.getPassword(), password, "Invalid password!");
        session.setAttribute("user", email);
    }
    
    public void signOut(){
        session.invalidate();
    }
    
    public boolean isSignedIn(){
        return session.getAttribute("user") != null;
    }
    
    public void register(String email, String password, String passwordConfirmation) throws ValidationException{
        require(email, "Email is required!");
        require(password, "Password is required!");
        require(passwordConfirmation, "PasswordConfirmation is required!");
        requireEquals(password, passwordConfirmation, "Password does not match confirmation!");
        User user = userService.findByEmail(email);
        requireNull(user, "User already exist");
        user = new User(email, password);
        userService.create(user);
        
    }
    
    public User getUser(){
        
        String email = (String) session.getAttribute("user");
        
        if(email != null){
            return userService.findByEmail(email);
        }
        return null;        
    }
}

