<form action="./AddWorkerSrv" method="post">
<div id="addworker" class="modal custom-modal fade" role="dialog">

    <div class="col-sm-6">
        <div class="form-group">
            <label for="worker_name">worker_name  <span class="text-danger">*</span></label>
            <input id="worker_name" name="worker_name" class="form-control" type="text">
        </div>
    </div>

    <div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">phno  <span class="text-danger">*</span></label>
            <input name="phno" required class="form-control" type="text">
        </div>
    </div>

    <div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">address <span class="text-danger">*</span></label>
            <input name="address" required class="form-control" type="text">
        </div>
    </div>
<div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">salary <span class="text-danger">*</span></label>
            <input name="salary" required class="form-control" type="text">
        </div>
    </div>

    <div class="submit-section">
        <button type="submit"  class="btn btn-primary submit-btn">Submit</button>
    </div>
    
</div>
</form>
