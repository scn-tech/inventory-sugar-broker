<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<%@page import="java.util.*" import="com.inventory.entity.*"%>
<html lang="en" class="light-style layout-menu-fixed" dir="ltr"
	data-theme="theme-default" data-assets-path="../assets/"
	data-template="vertical-menu-template-free">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />

<title>Add Stock Page</title>

<meta name="description" content="" />

<!-- Favicon -->
<link rel="icon" type="image/x-icon"
	href="../assets/img/favicon/favicon.ico" />

<!-- Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=Public+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
	rel="stylesheet" />

<!-- Common CSS -->
<%@ include file="common-css.jsp"%>
<!-- / Common CSS -->

<!-- Helpers -->
<script src="../assets/vendor/js/helpers.js"></script>

<!--! Template customizer & Theme config files MUST be included after core stylesheets and helpers.js in the <head> section -->
<!--? Config:  Mandatory theme config file contain global vars & default theme options, Set your preferred theme option in this file.  -->
<script src="../assets/js/config.js"></script>
<script src="../js/stock.js"></script>
</head>

<body onload="onLoadActivity()">
	<!-- Layout wrapper -->
	<div class="layout-wrapper layout-content-navbar">
		<div class="layout-container">
			<!-- Menu -->
			<%@ include file="side-menu.jsp"%>
			<!-- / Menu -->

			<!-- Layout container -->
			<div class="layout-page">
				<!-- Navbar -->
				<%@ include file="nav-bar.jsp"%>
				<!-- / Navbar -->

				<!-- Content wrapper -->
				<div class="content-wrapper">
					<!-- Content -->

					<div class="container-xxl flex-grow-1 container-p-y">
						<!-- Basic Layout & Basic with Icons -->
						<div class="row">
							<!-- Basic with Icons -->
							<div class="col-xxl">
								<div class="card mb-4">
									<div
										class="card-header d-flex align-items-center justify-content-between">
										<h5 class="mb-0">Book New Stock</h5>
									</div>
									<div class="card-body">

                                    <c:if test="${requestScope.code eq '401'}">
                                       <div class="alert alert-danger alert-dismissible" role="alert">
                                           Fail to add Stock.
                                           <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                                       </div>
                                    </c:if>

                                    <c:if test="${param.code eq '201'}">
                                       <div class="alert alert-success alert-dismissible" role="alert">
                                           Stock Added Successfully..!!!
                                           <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                                       </div>
                                    </c:if>

										<form method="post" action="/save-stock">


                                            <div class="row mb-3">
                                            <label for="seasonSelect" class="col-sm-2 col-form-label">Factory Name</label>
                                                <div class="col-sm-8">
                                                    <div class="input-group input-group-merge">
                                                        <input
                                                          name="factoryName"
                                                          class="form-control"
                                                          list="datalistOptions"
                                                          id="factoryNameList"
                                                          placeholder="Type to search..."
                                                        />
                                                        <datalist id="datalistOptions">

                                                            <%
                                                                List<Factory> factoryList = (List) request.getAttribute("factoryList");
                                                                for (Factory f : factoryList) {
                                                            %>
                                                            <option data-value="<%=f.getId()%>"><%=f.getFactoryName()%></option>
                                                            <%
                                                                }
                                                            %>
                                                        </datalist>
                                                        <input id="factoryId" type="hidden" name="factoryId.id"/>
                                                    </div>
                                                </div>
                                             </div>

                                             <div class="row mb-3">
                                               <label for="seasonSelect" class="col-sm-2 col-form-label">Party Name</label>
                                                   <div class="col-sm-8">
                                                       <div class="input-group input-group-merge">
                                                           <input
                                                             name="partyName"
                                                             class="form-control"
                                                             list="partyNameOptions"
                                                             id="partyNameList"
                                                             placeholder="Type to search..."
                                                           />
                                                           <datalist id="partyNameOptions">

                                                               <%
                                                                   List<Party> partiesList = (List) request.getAttribute("partiesList");
                                                                   for (Party p : partiesList) {
                                                               %>
                                                               <option data-value="<%=p.getId()%>"><%=p.getPartyName()%></option>
                                                               <%
                                                                   }
                                                               %>
                                                           </datalist>
                                                           <input id="partyId" type="hidden" name="partyId.id"/>
                                                       </div>
                                                </div>
                                           </div>

											<div class="row mb-3">
												<label for="seasonSelect" class="col-sm-2 col-form-label">Season</label>
												<div class="col-sm-3">
													<div class="input-group input-group-merge">

														<select class="form-select" id="seasonSelect"
															aria-label="Default select example" name="season">

															<option selected>Select Season</option>

															<%
                                                                Set<String> seasonList = (Set) request.getAttribute("seasonslist");
                                                                for (String season : seasonList) {
                                                            %>
                                                            <option value="<%=season%>"><%=season%></option>
                                                            <%
                                                                }
                                                            %>

														</select>
													</div>
												</div>
											</div>
											<div class="mb-3 row">
												<label for="tenderDate" class="col-md-2 col-form-label">Tender
													Date</label>
												<div class="col-md-3">
													<input class="form-control" type="date" value="2021-06-18"
														name="tenderDate" id="tenderDate" />
												</div>
											</div>
											<div class="mb-3 row">
												<label for="purchaseDate" class="col-md-2 col-form-label">Purchase
													Date</label>
												<div class="col-md-3">
													<input class="form-control" type="date" id="purchaseDate"
														name="purchaseDate" />

												</div>
											</div>
											<div class="row mb-3">
												<label for="grade" class="col-sm-2 col-form-label">Grade</label>
												<div class="col-sm-3">
													<div class="input-group input-group-merge">

														<select class="form-select" id="grade"
															aria-label="Default select example" name="grade">

															<option selected>Select Grade</option>

															<%
                                                                Set<String> gradelist = (Set) request.getAttribute("gradelist");
                                                                for (String grade : gradelist) {
                                                            %>
                                                            <option value="<%=grade%>"><%=grade%></option>
                                                            <%
                                                                }
                                                            %>
														</select>
													</div>
												</div>
											</div>

											<div class="mb-3 row">
												<label for="liftingDate" class="col-md-2 col-form-label">Lifting
													Date</label>
												<div class="col-md-3">
													<input class="form-control" type="date" value="2021-06-18"
														id="liftingDate" name="liftingDate" />
												</div>
											</div>

											<div class="row mb-3">
												<label class="col-sm-2 col-form-label"
													for="basic-icon-default-company">Quantity(in
													Quintal)</label>
												<div class="col-sm-3">
													<div class="input-group input-group-merge">

														<input required name="purchaseQuantity" type="number"
															id="basic-icon-default-company" class="form-control"
															placeholder="Enter quantity in quintal"
															aria-label="Enter quantity in quintal"
															aria-describedby="basic-icon-default-company2" />
													</div>
												</div>
											</div>
											<div class="row mb-3">
                                                <label class="col-sm-2 col-form-label"
                                                    for="basic-icon-default-company">Mill Rate</label>
                                                <div class="col-sm-3">
                                                    <div class="input-group input-group-merge">

                                                        <input required name="millRate" type="number"
                                                            id="basic-icon-default-company" class="form-control"
                                                            placeholder="Mill Rate" aria-label="MillRate"
                                                            aria-describedby="basic-icon-default-company2" />
                                                    </div>
                                                </div>
                                            </div>
											<div class="row mb-3">
												<label class="col-sm-2 col-form-label"
													for="basic-icon-default-company">Rate</label>
												<div class="col-sm-3">
													<div class="input-group input-group-merge">

														<input required name="rate" type="number"
															id="basic-icon-default-company" class="form-control"
															placeholder="Rate" aria-label="Rate"
															aria-describedby="basic-icon-default-company2" />
													</div>
												</div>
											</div>
											<div class="row mb-3">
												<label class="col-sm-2 col-form-label"
													for="basic-icon-default-company">Notes</label>
												<div class="col-sm-8">
													<div class="input-group input-group-merge">
														<span id="basic-icon-default-message2"
															class="input-group-text"><i class="bx bx-comment"></i></span>

														<textarea id="basic-icon-default-message"
															class="form-control" placeholder="Enter some notes here"
															aria-label="Enter some notes here"
															aria-describedby="basic-icon-default-message2"
															name="notes"></textarea>
													</div>
												</div>
											</div>

											<div class="row justify-content-end">
												<div class="col-sm-10">
													<button type="submit" class="btn btn-primary">SAVE</button>
												</div>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- / Content -->

					<!-- Common JS -->
					<%@ include file="footer.jsp"%>
					<!-- / Common JS -->

					<div class="content-backdrop fade"></div>
				</div>
				<!-- Content wrapper -->
			</div>
			<!-- / Layout page -->
		</div>

		<!-- Overlay -->
		<div class="layout-overlay layout-menu-toggle"></div>
	</div>
	<!-- / Layout wrapper -->
	<!-- 
    <div class="buy-now">
      <a
        href="https://themeselection.com/products/sneat-bootstrap-html-admin-template/"
        target="_blank"
        class="btn btn-danger btn-buy-now"
        >Upgrade to Pro</a
      >
    </div> -->

	<!-- Common JS -->
	<%@ include file="common-js.jsp"%>
	<!-- / Common JS -->

	<script type="text/javascript">
        //get Party Id based on Party Name selection
        document.querySelector('#partyNameList').addEventListener('change', function(e) {
            var input = e.target,
                list = input.getAttribute('list'),
                options = document.querySelectorAll('#' + list + ' option'),
                hiddenInput = document.getElementById("partyId"),
                inputValue = input.value;

            hiddenInput.value = inputValue;

            for(var i = 0; i < options.length; i++) {
                var option = options[i];

                if(option.innerText === inputValue) {
                    hiddenInput.value = option.getAttribute('data-value');
                    break;
                }
            }
        });


	    document.querySelector('#factoryNameList').addEventListener('change', function(e) {
            var input = e.target,
                list = input.getAttribute('list'),
                options = document.querySelectorAll('#' + list + ' option'),
                hiddenInput = document.getElementById("factoryId"),
                inputValue = input.value;

            hiddenInput.value = inputValue;

            for(var i = 0; i < options.length; i++) {
                var option = options[i];

                if(option.innerText === inputValue) {
                    hiddenInput.value = option.getAttribute('data-value');
                    break;
                }
            }
        });
	</script>

</body>
</html>
