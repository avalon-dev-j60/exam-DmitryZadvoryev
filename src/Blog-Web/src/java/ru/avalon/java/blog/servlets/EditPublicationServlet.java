package ru.avalon.java.blog.servlets;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.avalon.java.blog.exceptions.ValidationException;
import ru.avalon.java.blog.helpers.RedirectHelper;
import ru.avalon.java.blog.ru.avalon.java.blog.services.PostService;

@WebServlet("/edit")

public class EditPublicationServlet extends HttpServlet {

    private static final String JSP = "WEB-INF/pages/edit.jsp";

    @Inject
    PostService postService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(JSP).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("headline");
        String content = request.getParameter("publication_text");
        String id = request.getParameter("id");
        try {
            postService.editPublications(title, content, id);
            RedirectHelper.localRedirect(request, response, "/projects");
        } catch (ValidationException e) {
            request.setAttribute("exception", e);
            doGet(request, response);
        }
    }
}

