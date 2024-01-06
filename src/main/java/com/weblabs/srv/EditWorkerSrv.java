
package com.weblabs.srv;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.weblabs.beans.WorkerBean;
import com.weblabs.service.impl.WorkerServiceImpl;
			
@WebServlet("/EditWorkerSrv")
public class EditWorkerSrv extends HttpServlet {
    private static final long serialVersionUID = 1L;



    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

 
        String workerID= request.getParameter("workerID");
        String worker_name = request.getParameter("worker_name");
        String phno = request.getParameter("phno");
        String address = request.getParameter("address");
        String salary = request.getParameter("salary");
        String department = request.getParameter("department");
        
        WorkerBean dept = new WorkerBean();
        dept.setWorkerID(workerID);
        dept.setWorker_name(worker_name);
        dept.setPhno(phno);
        dept.setAddress(address);
        dept.setSalary(salary);
        dept.setDepartment(department);
        
        WorkerServiceImpl dao = new WorkerServiceImpl();
   
        String status1 = dao.editW(workerID, worker_name, phno, address, salary,department);

        RequestDispatcher rd = request.getRequestDispatcher("worker_edit.jsp?message=" + status1);
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}