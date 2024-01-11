package com.weblabs.srv;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class TwilloSrv {

    private static final String TWILIO_ACCOUNT_SID = "AC680a943a65d756365f73c7b69ea04d69";
    private static final String TWILIO_AUTH_TOKEN = "f3f437927b61ebe0fa0b5884bd92d42d";
    private static final String TWILIO_PHONE_NUMBER = "+16166362291";

    public void sendOtp(String phno, String otp) {
        String number = phno;
        String otpText = otp;  // Define your OTP message here

        try {
            Twilio.init(TWILIO_ACCOUNT_SID, TWILIO_AUTH_TOKEN);

            // Send SMS
            Message message = Message.creator(
                    new PhoneNumber(number),
                    new PhoneNumber(TWILIO_PHONE_NUMBER),
                    otpText
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
