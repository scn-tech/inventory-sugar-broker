<!DOCTYPE html>

<html
  lang="en"
  class="light-style layout-menu-fixed"
  dir="ltr"
  data-theme="theme-default"
  data-assets-path="../assets/"
  data-template="vertical-menu-template-free"
>
  <head>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0"
    />

    <title>View Party</title>

    <meta name="description" content="" />

    <!-- Favicon -->
    <link rel="icon" type="image/x-icon" href="../assets/img/favicon/favicon.ico" />

    <!-- Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Public+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
      rel="stylesheet"
    />

     <!-- Common CSS -->
        <%@ include file="common-css.jsp" %>
     <!-- / Common CSS -->

    <!-- Helpers -->
    <script src="../assets/vendor/js/helpers.js"></script>

    <!--! Template customizer & Theme config files MUST be included after core stylesheets and helpers.js in the <head> section -->
    <!--? Config:  Mandatory theme config file contain global vars & default theme options, Set your preferred theme option in this file.  -->
    <script src="../assets/js/config.js"></script>
  </head>

  <body>
    <!-- Layout wrapper -->
    <div class="layout-wrapper layout-content-navbar">
      <div class="layout-container">
        <!-- Menu -->
            <%@ include file="side-menu.jsp" %>
        <!-- / Menu -->

        <!-- Layout container -->
        <div class="layout-page">
            <!-- Navbar -->
                <%@ include file="nav-bar.jsp" %>
            <!-- / Navbar -->

          <!-- Content wrapper -->
          <div class="content-wrapper">
            <!-- Content -->

            <div class="container-xxl flex-grow-1 container-p-y">
              <!-- Striped Rows -->
                <div class="card">
                  <h5 class="card-header">Party List</h5>
                  <div class="table-responsive text-nowrap">
                    <table class="table table-striped">
                      <thead>
                        <tr>
                          <th>Name</th>
                          <th>Address</th>
                          <th>Contact</th>
                          <th>GST No.</th>
                          <th>Status</th>
                        </tr>
                      </thead>
                      <tbody class="table-border-bottom-0">
                      <c:choose>
                              <c:when test="${data.size() > 0 }">
                                  <c:forEach var="party" items="${data}">
                                      <tr>
                                          <td>${party.partyName}</td>
                                          <td>${party.partyAddress}</td>
                                          <td>${party.partyPhoneNo}</td>
                                          <td>${party.partyGstNo}</td>
                                          <td>  ${party.deletedFlag == false ? '<span class="badge bg-success">Active</span>' : '<span class="badge bg-danger">Inactive</span>'} </td>
                                      </tr>
                                  </c:forEach>
                              </c:when>
                              <c:otherwise>
                                  <tr align="center">
                                      <td colspan="4">No Record available</td>
                                  </tr>
                              </c:otherwise>
                          </c:choose>
                        </tr>
                      </tbody>
                    </table>

                    <c:if test="${data.size() > 0 }">
                        <!-- Basic Pagination -->
                        <div class="card mb-4">

                            <div class="card-body">
                              <div class="row">
                                <div class="col">
                                  <small class="text-light fw-semibold">Total Records : ${totalElements} | Showing Page [${number+1} of ${totalPages}] </small>
                                  <div class="demo-inline-spacing">
                                    <!-- Basic Pagination -->
                                    <nav aria-label="Page navigation">
                                      <ul class="pagination">
                                        <li class="page-item first">
                                          <a style="${(0 == param.pno) ? 'cursor: not-allowed;' : ''}" class="page-link"
                                          href="view-factories?pno=0&psz=10"
                                            ><i class="tf-icon bx bx-chevrons-left"></i
                                          ></a>
                                        </li>
                                        <li class="page-item prev">
                                          <a style="${(0 == param.pno) ? 'cursor: not-allowed;' : ''}" class="page-link"
                                          href="view-factories?pno=${(totalPages-1)-1}&psz=10"
                                            ><i class="tf-icon bx bx-chevron-left"></i
                                          ></a>
                                        </li>
                                        <c:forEach begin="0" end="${totalPages-1}" var="page">
                                              <li class="page-item">
                                                  <a style="${(page == param.pno) ? 'background-color:#696cff;color:#fff;' : ''}" class="page-link"
                                                  href="view-factories?pno=${page}&psz=10" class="page-link">${page+1}</a>
                                              </li>
                                        </c:forEach>
                                        <li class="page-item next">
                                          <a style="${(totalPages-1 == param.pno) ? 'cursor: not-allowed;' : ''}" class="page-link"
                                          href="view-factories?pno=${totalPages-1}&psz=10"
                                            ><i class="tf-icon bx bx-chevron-right"></i
                                          ></a>
                                        </li>
                                        <li class="page-item last">
                                          <a style="${(totalPages-1 == param.pno) ? 'cursor: not-allowed;' : ''}" class="page-link"
                                          href="view-factories?pno=${totalPages-1}&psz=10"
                                            ><i class="tf-icon bx bx-chevrons-right"></i
                                          ></a>
                                        </li>
                                      </ul>
                                    </nav>
                                  </div>
                                </div>
                              </div>
                            </div>
                          </div>
                          <!--/ Basic Pagination -->
                        </c:if>
                  </div>
                </div>
                <!--/ Striped Rows -->
            </div>
            <!-- / Content -->

            <!-- Common JS -->
                <%@ include file="footer.jsp" %>
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

    <!-- Common JS -->
        <%@ include file="common-js.jsp" %>
    <!-- / Common JS -->
  </body>
</html>
