package ru.avalon.java.blog.servlets;

import java.io.IOException;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.avalon.java.blog.entities.Publication;
import ru.avalon.java.blog.entities.User;
import ru.avalon.java.blog.exceptions.ValidationException;
import static ru.avalon.java.blog.helpers.RedirectHelper.LocalRedirect;
import static ru.avalon.java.blog.helpers.Validation.require;
import static ru.avalon.java.blog.helpers.Validation.requireNonNull;
import ru.avalon.java.blog.ru.avalon.java.blog.services.AuthService;
import ru.avalon.java.blog.service.PublicationService;

@WebServlet("/publication/edit")
public class PublicationEditServlet extends HttpServlet {

    private static final String JSP = "/WEB-INF/pages/publications/edit.jsp";

    @EJB
    PublicationService publicationService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

        if (id != null) {
            try {
                long lid = Long.parseLong(id);
                Publication publication = publicationService.find(lid);
                requireNonNull(publication, "");
                request.setAttribute("publication", publication);
                request.getRequestDispatcher(JSP).forward(request, response);
            } catch (NumberFormatException | ValidationException e) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        } else {
            LocalRedirect(request, response, "/");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        String id = request.getParameter("id");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
         try {
             require(title, "Title is reqired!");
             require(content, "Content if required!");
             long lid = Long.parseLong(id);
             Publication publication = publicationService.find(lid);
             requireNonNull(publication, "");
             publication.setContent(content);
             publication.setTitle(title);
             publicationService.update(publication);
             LocalRedirect(request, response, "/");
         } catch (NumberFormatException | ValidationException e) {
             request.setAttribute("exception", e);
             doGet(request, response);
         }
    }
}
