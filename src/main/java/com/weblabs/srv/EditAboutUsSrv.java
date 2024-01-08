package com.weblabs.srv;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.weblabs.beans.AboutUsBean;
import com.weblabs.service.impl.AboutUsServiceImpl;
			
@WebServlet("/EditAboutUsSrv")
public class EditAboutUsSrv extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String status = "Edit  Failed!"; 
        String aboutID= request.getParameter("aboutID");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
       
        

        AboutUsBean about = new AboutUsBean();
        about.setAboutID(aboutID);
        about.setTitle(title);
        about.setContent(content);
        

        AboutUsServiceImpl dao = new AboutUsServiceImpl();
   
        String status1 = dao.editabout(aboutID,title,content);

        RequestDispatcher rd = request.getRequestDispatcher("about.jsp?message=" + status1);
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}