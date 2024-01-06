<form action="./AddVechicleSrv" method="post">
<div id="addvechicle" class="modal custom-modal fade" role="dialog">
    <div class="col-md-6">
        <div class="form-group">
            <label for="customerID">Customer ID <span class="text-danger">*</span></label>
            <input id="customerID" name="customerID" class="form-control" type="text">
        </div>
    </div>

    <div class="col-sm-6">
        <div class="form-group">
            <label for="vehicleType">Vehicle Type <span class="text-danger">*</span></label>
            <input id="vehicleType" name="vehicleType" class="form-control" type="text">
        </div>
    </div>

    <div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">Vehicle Model <span class="text-danger">*</span></label>
            <input name="vehicleModel" required class="form-control" type="text">
        </div>
    </div>

    <div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">VIN <span class="text-danger">*</span></label>
            <input name="VIN" required class="form-control" type="text">
        </div>
    </div>
<div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">brand <span class="text-danger">*</span></label>
            <input name="brand" required class="form-control" type="text">
        </div>
    </div>
    <div class="submit-section">
        <button type="submit"  class="btn btn-primary submit-btn">Submit</button>
    </div>
</div>
</form>
