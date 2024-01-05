<form action="./AddServiceSrv" method="post">
<div id="addservice" class="modal custom-modal fade" role="dialog">

 <!--    <div class="col-md-6">
        <div class="form-group">
            <label for="serviceID">service ID <span class="text-danger">*</span></label>
            <input id="serviceID" name="serviceID" class="form-control" type="text">
        </div>
    </div> -->

    <div class="col-sm-6">
        <div class="form-group">
            <label for="servicename">servicename  <span class="text-danger">*</span></label>
            <input id="servicename" name="servicename" class="form-control" type="text">
        </div>
    </div>

    <div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">description  <span class="text-danger">*</span></label>
            <input name="description" required class="form-control" type="text">
        </div>
    </div>

    <div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">price <span class="text-danger">*</span></label>
            <input name="price" required class="form-control" type="text">
        </div>
    </div>
      <div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">discount <span class="text-danger">*</span></label>
            <input name="discount" required class="form-control" type="text">
        </div>
    </div>
      <div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">coupons <span class="text-danger">*</span></label>
            <input name="coupons" required class="form-control" type="text">
        </div>
    </div>

    <div class="submit-section">
        <button type="submit"  class="btn btn-primary submit-btn">Submit</button>
    </div>
</div>
</form>
