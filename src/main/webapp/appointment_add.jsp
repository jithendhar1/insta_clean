<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>

<form action="./AddAppointmentSrv" method="post">



    <div class="col-sm-6">
        <div class="form-group">
            <label for="customerID">customerID <span class="text-danger">*</span></label>
            <input id="customerID" name="customerID" class="form-control" type="text">
        </div>
    </div>

    <div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label"> VIN <span class="text-danger">*</span></label>
            <input name="VIN" required class="form-control" type="text">
        </div>
    </div>
 <div class="col-sm-6">
    <div class="form-group">
        <label for="availabilityThreshold">Work places <span class="text-danger">*</span></label>
        <input id="availabilityThreshold" name="availabilityThreshold" class="form-control" type="text">
    </div>
</div>
<div class="col-md-6">
    <div class="form-group">
        <label class="col-form-label">appointment date <span class="text-danger">*</span></label>
        <input id="appointmentDate" name="appointmentdate" required class="form-control" type="text">
    </div>
</div>

<div class="col-md-6">
    <div class="form-group">
         <label class="col-form-label">11 <span class="text-danger">*</span></label> 
        <input id="A11" name="A11" required class="form-control" type="text" >
    </div>
</div>
      <div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">12 <span class="text-danger">*</span></label> 
            <input name="A12"  id="A12" required class="form-control" type="text" >
        </div>
    </div>
 <div class="col-md-6">
    <div class="form-group">
       <label class="col-form-label">13 <span class="text-danger">*</span></label> 
        <input id="A13" name="A13" required class="form-control" type="text" >
    </div>
</div>
      <div class="col-md-6">
        <div class="form-group">
             <label class="col-form-label">14 <span class="text-danger">*</span></label>
            <input name="A14"  id="A14" required class="form-control" type="text" >
        </div>
    </div><div class="col-md-6">
    <div class="form-group">
        <label class="col-form-label">15 <span class="text-danger">*</span></label> 
        <input id="A15" name="A15" required class="form-control" type="text" >
    </div>
</div>
      <div class="col-md-6">
        <div class="form-group">
           <label class="col-form-label">16 <span class="text-danger">*</span></label> 
            <input name="A16"  id="A16" required class="form-control" type="text" >
        </div>
    </div><div class="col-md-6">
    <div class="form-group">
        <label class="col-form-label">17 <span class="text-danger">*</span></label> 
        <input id="A17" name="A17" required class="form-control" type="text" >
    </div>
</div>
      <div class="col-md-6">
        <div class="form-group">
             <label class="col-form-label">18 <span class="text-danger">*</span></label> 
            <input name="A18"  id="A18" required class="form-control" type="text" >
        </div>
    </div>

 
  <!-- Add a hidden input for the availability status of each time slot -->
  <input type="hidden" id="availability11" name="availability11" value="true">
  <input type="hidden" id="availability12" name="availability12" value="true">
    <input type="hidden" id="availability13" name="availability13" value="true">
  <input type="hidden" id="availability14" name="availability14" value="true">
    <input type="hidden" id="availability15" name="availability15" value="true">
  <input type="hidden" id="availability16" name="availability16" value="true">
    <input type="hidden" id="availability17" name="availability17" value="true">
  <input type="hidden" id="availability18" name="availability18" value="true">
  <!-- Repeat for other time slots -->
     
  <!-- Submit button -->
  <div class="submit-section">
    <button type="submit" class="btn btn-primary submit-btn">Submit</button>
  </div>
</form>

<script>
$(document).ready(function() {
    // Add an event listener to the appointment date input field
    $('#appointmentDate').on('change', function() {
        // Fetch availability from the server and update the hidden input values
        $.ajax({
            url: 'YourAvailabilityEndpoint',  // Replace with your actual endpoint
            method: 'GET',
            data: { appointmentDate: $(this).val() }, // Pass the appointment date
            success: function(data) {
                // Read the availability threshold from user input
                var availabilityThreshold = parseInt($('#availabilityThreshold').val()) || 3;

                // Update the hidden input values based on the availability
                updateAvailability('A11', data.availability11, availabilityThreshold);
                updateAvailability('A12', data.availability12, availabilityThreshold);
                updateAvailability('A13', data.availability13, availabilityThreshold);
                updateAvailability('A14', data.availability14, availabilityThreshold);
                updateAvailability('A15', data.availability15, availabilityThreshold);
                updateAvailability('A16', data.availability16, availabilityThreshold);
                updateAvailability('A17', data.availability17, availabilityThreshold);
                updateAvailability('A18', data.availability18, availabilityThreshold);

                // Disable input fields based on availability
                disableTimeSlot('A11', data.availability11, availabilityThreshold);
                disableTimeSlot('A12', data.availability12, availabilityThreshold);
                disableTimeSlot('A13', data.availability13, availabilityThreshold);
                disableTimeSlot('A14', data.availability14, availabilityThreshold);
                disableTimeSlot('A15', data.availability15, availabilityThreshold);
                disableTimeSlot('A16', data.availability16, availabilityThreshold);
                disableTimeSlot('A17', data.availability17, availabilityThreshold);
                disableTimeSlot('A18', data.availability18, availabilityThreshold);
            },
            error: function(error) {
                console.error('Error fetching availability:', error);
            }
        });
    });

    // Function to update hidden input values based on availability
    function updateAvailability(timeSlot, availability, threshold) {
        $('#availability' + timeSlot).val(availability.toString());
        // Update the threshold input field dynamically
        $('#availabilityThreshold').val(threshold);
    }

    // Function to disable/enable time slot based on availability
    function disableTimeSlot(timeSlot, availability, threshold) {
        if (availability >= threshold) {
            // If available equal to or more than the threshold, disable the input field
            $('#' + timeSlot).prop('disabled', true);
        } else {
            // If not available or available less than the threshold, enable the input field
            $('#' + timeSlot).prop('disabled', false);
        }
    }
});

</script>