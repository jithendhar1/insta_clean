package com.weblabs.srv;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet("/OtpGeneratorServlet")
public class OtpGeneratorServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Generate a random 6-digit OTP
        String otp = generateRandomOTP(6);

        // Set the response content type
        response.setContentType("text/plain");

        // Write the OTP to the response
        response.getWriter().write(otp);
    }

    private String generateRandomOTP(int length) {
        // Define the characters allowed in the OTP
        String allowedChars = "0123456789";

        // Create a StringBuilder to store the OTP
        StringBuilder otpBuilder = new StringBuilder();

        // Create a Random object
        Random random = new Random();

        // Generate the OTP
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(allowedChars.length());
            char randomChar = allowedChars.charAt(index);
            otpBuilder.append(randomChar);
        }

        // Convert StringBuilder to String and return the OTP
        return otpBuilder.toString();
    }
}
