<form action="./AddWorkerSrv" method="post">
<div id="addworker" class="modal custom-modal fade" role="dialog">
<div class="modal-dialog modal-dialog-centered" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title">Add Department</h5>
								<button type="button" class="close" data-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								
    <div class="col-md-12">
        <div class="form-group">
            <label for="worker_name">worker_name  <span class="text-danger">*</span></label>
            <input id="worker_name" name="worker_name" class="form-control" type="text">
        </div>
    </div>

   <div class="col-md-12">
        <div class="form-group">
            <label class="col-form-label">phno  <span class="text-danger">*</span></label>
            <input name="phno" required class="form-control" type="text">
        </div>
    </div>

  <div class="col-md-12">
        <div class="form-group">
            <label class="col-form-label">address <span class="text-danger">*</span></label>
            <input name="address" required class="form-control" type="text">
        </div>
    </div>
<div class="col-md-12">
        <div class="form-group">
            <label class="col-form-label">salary <span class="text-danger">*</span></label>
            <input name="salary" required class="form-control" type="text">
        </div>
    </div>
<div class="col-md-12">
        <div class="form-group">
            <label class="col-form-label">department <span class="text-danger">*</span></label>
            <input name="department" required class="form-control" type="text">
        </div>
    </div>
    <div class="submit-section">
        <button type="submit"  class="btn btn-primary submit-btn">Submit</button>
    </div>
     </div>
    </div> 
</div> 
</div>
</form>
