package com.weblabs.srv;

import java.security.SecureRandom;

public class OTPGenerator {

	 // Method to generate a random OTP
    public static String generateOTP() {
        // Define the length of the OTP
        int otpLength = 6;

        // Define the characters allowed in the OTP
        String allowedChars = "0123456789";

        // Use SecureRandom for generating random numbers securely
        SecureRandom random = new SecureRandom();

        // StringBuilder to store the generated OTP
        StringBuilder otp = new StringBuilder(otpLength);

        // Generate OTP by appending random characters from allowedChars
        for (int i = 0; i < otpLength; i++) {
            int index = random.nextInt(allowedChars.length());
            otp.append(allowedChars.charAt(index));
        }

        // Return the generated OTP as a string
        return otp.toString();
    }

   
}
