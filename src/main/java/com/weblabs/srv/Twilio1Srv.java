package com.weblabs.srv;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class Twilio1Srv {

    private static final String TWILIO_ACCOUNT_SID = "AC680a943a65d756365f73c7b69ea04d69";
    private static final String TWILIO_AUTH_TOKEN = "6084ae70cd635d8981b9d752b6e8cff2";
    private static final String TWILIO_PHONE_NUMBER = "+161663622918";

    public void sendOtp(String phno, String otp) {
        String number = phno;
        String otpText = otp;  // Define your OTP message here

        try {
            Twilio.init(TWILIO_ACCOUNT_SID, TWILIO_AUTH_TOKEN, TWILIO_PHONE_NUMBER);
            
			/*
			 * Message message = Message.creator( new PhoneNumber("whatsapp:" + number), new
			 * PhoneNumber("whatsapp:" + TWILIO_PHONE_NUMBER), otpText ).create();
			 */
            
            Message message = Message.creator(
            	    new PhoneNumber("whatsapp:+9390541846"),  // Replace with the recipient's number
            	    new PhoneNumber("whatsapp:+161663622918"),  // Replace with your Twilio phone number
            	    "Hello, this is a test message!"
            	).create();


            System.out.println("SMS sent successfully. SID: " + message.getSid());

        } catch (Exception e) {
            System.err.println("Error sending SMS: " + e.getMessage());
            // You might want to throw an exception or return an error status here
        }
    }
}
