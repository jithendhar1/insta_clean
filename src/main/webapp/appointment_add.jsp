<form action="./AddAppointmentSrv" method="post">
<div id="addappointment" class="modal custom-modal fade" role="dialog">
  <!--   <div class="col-md-6">
        <div class="form-group">
            <label for="appointmentID">appointment ID <span class="text-danger">*</span></label>
            <input id="appointmentID" name="appointmentID" class="form-control" type="text">
        </div>
    </div> -->

    <div class="col-sm-6">
        <div class="form-group">
            <label for="customerID">customerID <span class="text-danger">*</span></label>
            <input id="customerID" name="customerID" class="form-control" type="text">
        </div>
    </div>

    <div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label"> vehicleID <span class="text-danger">*</span></label>
            <input name="vehicleID" required class="form-control" type="text">
        </div>
    </div>

    <div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">serviceID <span class="text-danger">*</span></label>
            <input name="serviceID" required class="form-control" type="text">
        </div>
    </div>
<div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">appointmentdate <span class="text-danger">*</span></label>
            <input name="appointmentdate" required class="form-control" type="text">
        </div>
    </div>
    <div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">status <span class="text-danger">*</span></label>
            <input name="status" required class="form-control" type="text">
        </div>
    </div>
    <div class="submit-section">
        <button type="submit"  class="btn btn-primary submit-btn">Submit</button>
    </div>
</div>
</form>
