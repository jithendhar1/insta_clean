
package com.weblabs.srv;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.weblabs.DAO.VechicleDAO;
import com.weblabs.beans.VechicleBean;

@WebServlet("/DAOVechicleSrv")
public class DAOVechicleSrv extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Your existing servlet code here

        List<VechicleBean> allVehicles = getVechcile();

        // Convert the list to JSON
        String jsonResponse = new Gson().toJson(allVehicles);

        // Set the content type and write the JSON response
        response.setContentType("application/json");
        response.getWriter().write(jsonResponse);
    }

    // Your existing servlet code here

    public List<VechicleBean> getVechcile() {
        List<VechicleBean> allVehicles = VechicleDAO.getAllVehicles();
        return allVehicles;
    }

    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}