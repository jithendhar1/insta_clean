
package com.weblabs.srv;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

public class TwilloSrv {

    private static final String TWILIO_ACCOUNT_SID = "AC680a943a65d756365f73c7b69ea04d69";
    private static final String TWILIO_AUTH_TOKEN = "9249a1bac84fa0231292db31a88329b3";
   // private static final String TWILIO_PHONE_NUMBER = "+161663622918";

    public void sendOtp(String phno, String otp) {
     
    	//String number = "whatsapp:" + phno;
    	String number = "whatsapp:+91" + phno;
        String otpText = otp;  // Define your OTP message here

        try {
		
            
        	
        	    Twilio.init(TWILIO_ACCOUNT_SID, TWILIO_AUTH_TOKEN);
       	        Message message = Message.creator(
        	      new com.twilio.type.PhoneNumber(number),
        	      new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
        	      otpText

        	    ).create();

        	    System.out.println(message.getSid());
        	  
            

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