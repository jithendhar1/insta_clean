
package com.weblabs.srv;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.weblabs.beans.ServiceBean;
import com.weblabs.service.impl.ServiceServiceImpl;
			
@WebServlet("/EditServiceSrv")
public class EditServiceSrv extends HttpServlet {
    private static final long serialVersionUID = 1L;

    

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //String status1 = "Edit Failed!"; 
        String serviceID= request.getParameter("serviceID");
        String servicename = request.getParameter("servicename");
        String description = request.getParameter("description");
        String price = request.getParameter("price");
        String discount = request.getParameter("discount");
        String coupons = request.getParameter("coupons");
        String type = request.getParameter("type");
        ServiceBean dept = new ServiceBean();
        
        dept.setServiceID(serviceID);
        dept.setServicename(servicename);
        dept.setDescription(description);
        dept.setPrice(price);
        dept.setDiscount(discount);
        dept.setCoupons(coupons);
        dept.setType(type);
        ServiceServiceImpl dao = new ServiceServiceImpl();
   
        String status2 = dao.editS(serviceID, servicename, description, price, discount, coupons,type);

        RequestDispatcher rd = request.getRequestDispatcher("service_edit.jsp?message=" + status2);
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}