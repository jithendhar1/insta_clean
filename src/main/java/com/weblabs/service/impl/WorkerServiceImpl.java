

package com.weblabs.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.weblabs.utility.DBUtil;

public class WorkerServiceImpl {

	
	//workerID, worker_name, phno, address, salary
	
	public String addW(String worker_name,String phno,String address,String salary,String department) {
		
		String Status1 = "Vechicle Adding Failed!";

        Connection con = DBUtil.provideConnection();
        PreparedStatement ps = null;

        try {
        	ps = con.prepareStatement("INSERT INTO workers_details (worker_name, phno, address, salary,department) VALUES (?,?,?,?,?)");
        	ps.setString(1, worker_name);
        	ps.setString(2, phno);
            ps.setString(3, address);
            ps.setString(4, salary);
            ps.setString(5, department);
           
           
            int k = ps.executeUpdate();

            if (k > 0) {
                Status1 = "Vechicle Added Successfully!";
            }
        } catch (SQLException e) {
            Status1 = "Error: " + e.getMessage();
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(con);
            DBUtil.closeConnection(ps);
        }

        return Status1;
	}
	
//	workerID, worker_name, phno, address, salary
	public String editW(String workerID,String worker_name,String phno,String address,String salary,String department)  {
		
			String Status3 = "Updating  Failed!";

	        Connection con = DBUtil.provideConnection();
	        PreparedStatement ps = null;

	        try {
	        	ps = con.prepareStatement("UPDATE workers_details SET  worker_name= ?, phno= ?, address= ?, salary= ?,department= ? WHERE workerID = ?");
	        	
	        	ps.setString(1, worker_name);
	        	ps.setString(2, phno);
	            ps.setString(3, address);
	            ps.setString(4, salary);
	            ps.setString(5, department);
	            ps.setString(6, workerID);
	           
	            int k = ps.executeUpdate();

	            if (k > 0) {
	            	Status3 = "Updating Successfully!";
	            }
	        }
	         catch (SQLException e) {
	        	Status3 = "Error: " + e.getMessage();
	            e.printStackTrace();
	        } finally {
	            DBUtil.closeConnection(con);
	            DBUtil.closeConnection(ps);
	        }

	        return Status3 ;
	}

	
	public String deleteW(String workerID) {
		String Status2 = " delete Failed!";

        Connection con = DBUtil.provideConnection();
        PreparedStatement ps = null;

        try {
        	ps = con.prepareStatement("DELETE FROM workers_details  WHERE workerID = ?");
            ps.setString(1, workerID);
           
            int k = ps.executeUpdate();

            if (k > 0) {
            	Status2 = " deleted Successfully!";
            }
        } catch (SQLException e) {
        	Status2 = "Error: " + e.getMessage();
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(con);
            DBUtil.closeConnection(ps);
        }

        return Status2;
	}
}
