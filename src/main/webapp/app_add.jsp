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

<div class="col-md-6">
    <div class="form-group">
        <label class="col-form-label">appointment date <span class="text-danger">*</span></label>
        <input id="appointmentDate" name="appointmentdate" required class="form-control" type="text">
    </div>
</div>

<div class="col-md-6">
    <div class="form-group">
         <label class="col-form-label">start_time <span class="text-danger">*</span></label> 
        <input id="start_time" name="start_time" required class="form-control" type="text" >
    </div>
</div>
 <div class="col-md-6">
    <div class="form-group">
       <label class="col-form-label">end_time <span class="text-danger">*</span></label> 
        <input id="end_time" name="end_time" required class="form-control" type="text" >
    </div>
     </div>
<div class="col-md-6">
    <div class="form-group">
       <label class="col-form-label">serviceIDlist <span class="text-danger">*</span></label> 
        <input id="serviceIDlist" name="serviceIDlist" multiple class="form-control" type="text" >
    </div>
     </div>   
      
 <div class="submit-section">
        <button type="submit"  class="btn btn-primary submit-btn">Submit</button>
    </div>
    </form>