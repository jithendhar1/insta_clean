
package com.weblabs.srv;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class TwilloSrv {

    private static final String TWILIO_ACCOUNT_SID = "";
    private static final String TWILIO_AUTH_TOKEN = "";
    private static final String TWILIO_PHONE_NUMBER = "+";

    public void sendOtp(String phno, String otp) {
        String number = phno;
        String otpText = otp;  // Define your OTP message here

        try {
			/*
			 * Twilio.init(TWILIO_ACCOUNT_SID, TWILIO_AUTH_TOKEN);
			 * 
			 * // Send SMS Message message = Message.creator( new PhoneNumber(number), new
			 * PhoneNumber(TWILIO_PHONE_NUMBER), otpText ).create();
			 */
            
            
            
        	Twilio.init(TWILIO_ACCOUNT_SID, TWILIO_AUTH_TOKEN);
    	    Message message = Message.creator(
    	      new com.twilio.type.PhoneNumber("whatsapp:+"),
    	      new com.twilio.type.PhoneNumber("whatsapp:+"),
    	     " otpText"

    	    ).create();   
            
            
            

            // Log the SID of the message
            System.out.println("SMS sent successfully. SID: " + message.getSid());

            // Respond to the client or handle success
            // You might want to return a success message or status here

        } catch (Exception e) {
            // Handle exceptions
            System.err.println("Error sending SMS: " + e.getMessage());
            
            // Respond to the client or handle the error
            // You might want to throw an exception or return an error status here
        }
    }

   
}