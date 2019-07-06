/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.blog.servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.avalon.java.blog.entities.Publication;
import ru.avalon.java.blog.ru.avalon.java.blog.services.PostService;



@WebServlet("/projects")
public class ProjectsServlet extends HttpServlet{
    
    private static final String JSP = "WEB-INF/pages/projects.jsp";

    @Inject PostService postService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        List<Publication> projects = postService.getAllPublications();        
        request.setAttribute("projects", projects);
        request.getRequestDispatcher(JSP).forward(request, response);           
    }

    
    
    
}
