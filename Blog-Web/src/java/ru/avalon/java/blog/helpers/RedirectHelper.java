
package ru.avalon.java.blog.helpers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.HttpHeaders;

public class RedirectHelper {
//
    public RedirectHelper() {
    }
    
    public static void redirect(HttpServletRequest request, HttpServletResponse response, String location) throws ServletException, IOException{
        response.setStatus(HttpServletResponse.SC_FOUND);
        response.setHeader(HttpHeaders.LOCATION, location);
    }
    public static void LocalRedirect(HttpServletRequest request, HttpServletResponse response, String location) throws ServletException, IOException{
        location = request.getContextPath() + location;
        redirect(request, response,location);
    }
    public static void redirectBack(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String referer = request.getHeader("Referer");
        String currentLocation = request.getRequestURL().toString();//возвращает текущее положение
        if(referer == null || referer.equals(currentLocation)){
            LocalRedirect(request, response, "/");
        }else{
            redirect(request, response, referer);
        }        
    }
}
