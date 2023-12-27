<form action="./AddCustomerSrv" method="post">

   <!--  <div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">Vehicle ID</label>
            <input name="vehicleID" required class="form-control" type="text">
        </div>
    </div> -->

    <div class="col-md-6">
        <div class="form-group">
            <label>customername  <span class="text-danger">*</span></label>
            <input  name="customername" class="form-control" type="text">
        </div>
    </div>

    <div class="col-sm-6">
        <div class="form-group">
            <label >email  <span class="text-danger">*</span></label>
            <input  name="email" class="form-control" type="text">
        </div>
    </div>

    <div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">phno <span class="text-danger">*</span></label>
            <input name="phno" required class="form-control" type="text">
        </div>
    </div>

    <div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">firstname <span class="text-danger">*</span></label>
            <input name="firstname" required class="form-control" type="text">
        </div>
    </div>
 <div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">lastname <span class="text-danger">*</span></label>
            <input name="lastname" required class="form-control" type="text">
        </div>
    </div>
    
    
    <table class="table table-hover table-white" id="itemTable" >
												<thead>
													<tr>
														<th style="width: 20px">ID</th>
														<th class="col-sm-2">street</th>
														<th class="col-md-6">city</th>
														<th style="width:100px;">postal_code </th>
														<th style="width:80px;">state</th>
														<th>hno</th>
														<th> </th>
													</tr>
												</thead>
    <tbody>
												<tr>
													<td>1</td>
													<td>
													<!-- 	<input name="items" class="form-control" type="text" style="min-width:150px"> -->
														 <input name="street" id="street" required class="form-control" type="text"  >
                                                        <span id="itemsError" style="display: none; color: red;"></span>
                              
													</td>
													<td>
														<input name="city" class="form-control" type="text" style="min-width:150px">
													</td>
													<td>
														<input name="postal_code" class="form-control" style="width:100px" type="text">
													</td>
													<td>
														<input name="state" class="form-control" style="width:80px" type="text"  >
													</td>
													<td>
														<input name="hno" class="form-control" style="width:100px" type="text" >
													</td>
													 <td>
										                <a href="javascript:void(0)" class="text-success font-18" title="Add" onclick="addItem(this)"><i class="fa fa-plus"></i> </a>
										            </td>
										            <td>
										                <a href="javascript:void(0)" class="text-danger font-18 disabled-link"  title="Remove" ><i class="fa fa-trash-o"></i> </a>
										            </td>
										
												</tr>

</tbody>
 </table>   
    <!--  <div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">street <span class="text-danger">*</span></label>
            <input name="street" required class="form-control" type="text">
        </div>
    </div>
     <div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">city <span class="text-danger">*</span></label>
            <input name="city" required class="form-control" type="text">
        </div>
    </div>
     <div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">postal_code <span class="text-danger">*</span></label>
            <input name="postal_code" required class="form-control" type="text">
        </div>
    </div>
    <div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">state <span class="text-danger">*</span></label>
            <input name="state" required class="form-control" type="text">
        </div>
    </div>
     <div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">hno <span class="text-danger">*</span></label>
            <input name="hno" required class="form-control" type="text">
        </div>
    </div> -->
    
    
    <div class="submit-section">
        <button type="submit" name="addcustomerprofile" class="btn btn-primary submit-btn">Submit</button>
    </div>

</form>
