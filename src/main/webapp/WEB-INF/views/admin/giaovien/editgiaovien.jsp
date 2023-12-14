<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="giaovienURL" value="/quan-tri/bai-viet/danh-sach-giao-vien" />
<c:url var="editgiaovienURL" value="/quan-tri/bai-viet/chinh-sua-giao-vien" />
<c:url var="giaovienAPI" value="/api/giaovien" />
<html>
<head>
<title>Chỉnh sửa Giáo Viên</title>
</head>
<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs" id="breadcrumbs">
				<script type="text/javascript">
					try {
						ace.settings.check('breadcrumbs', 'fixed')
					} catch (e) {
					}
				</script>

				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href='<c:url value='/quan-tri/trang-chu'/>'>Trang Chủ</a>
					</li>
					<li><a href='<c:url value='/quan-tri/bai-viet/danh-sach-giao-vien?page=1&limit=10'/>'>Danh sách giáo viên</a></li>
					<li><a class="active">Chỉnh sửa</a></li>
				</ul>
				<!-- /.breadcrumb -->

			</div>
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
						<c:if test="${not empty message}">
							<div class="alert alert-${alert}">${message}</div>
						</c:if>
						<form:form class="form-horizontal" role="form" id="formSubmit"
							modelAttribute="model">
							<div class="form-group ">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> ID </label>
								<div class="col-sm-9">
									<form:input path="id" cssClass="col-xs-10 col-sm-5" id="id" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> Mã giáo viên </label>
								<div class="col-sm-9">
									<form:input path="code" cssClass="col-xs-10 col-sm-5" id="code" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> Họ và tên </label>
								<div class="col-sm-9">
									<form:input path="name" cssClass="col-xs-10 col-sm-5" id="name" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> Ngày sinh</label>
								<div class="col-sm-9">
									<form:input path="dateOfBirth" cssClass="col-xs-10 col-sm-5"
										id="dateOfBirth" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> Mã khoa </label>
								<div class="col-sm-9">
									<form:input path="facultyCode" cssClass="col-xs-10 col-sm-5"
										id="facultyCode" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> Giới tính </label>
								<div class="col-sm-9">
									<form:input path="gender" cssClass="col-xs-10 col-sm-5"
										id="gender" />
								</div>
							</div>
							<form:hidden path="id" id="giaoVienId" />
							
								<div class="col-md-offset-3 col-md-9"  >
									<c:if test="${not empty model.id}">
										<button class="btn btn-info" type="button"
											id="btnAddOrUpdateGiaoVien">
											<i class="ace-icon fa fa-check bigger-110"></i> Cập nhật giáo viên
										</button>
									</c:if>
									<c:if test="${empty model.id}">
										<button class="btn btn-info" type="button"
											id="btnAddOrUpdateGiaoVien">
											<i class="ace-icon fa fa-check bigger-110"></i> Thêm giáo viên
										</button>
									</c:if>

									&nbsp; &nbsp; &nbsp;
									<button class="btn" type="reset">
										<i class="ace-icon fa fa-undo bigger-110"></i> Reset
									</button>
								</div>
							
					</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
	</div>

	<script>
		$('#btnAddOrUpdateGiaoVien').click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});
			var id = $('#giaoVienId').val();
			if (id == "") {
				addGiaoVien(data);
			} else {
				updateGiaoVien(data);
			}
		});

		function addGiaoVien(data) {
			$.ajax({
						url : '${giaovienAPI}',
						type : 'POST',
						contentType : 'application/json',
						data : JSON.stringify(data),
						dataType : 'json',
						success : function(result) {
							window.location.href = "${editgiaovienURL}?id="
									+ result.id + "&message=insert_success";
						},
						error : function(error) {
							window.location.href = "${giaovienURL}?page=1&limit=10&message=error_system";
						}
					});
		}

		function updateGiaoVien(data) {
			$.ajax({
						url : '${giaovienAPI}',
						type : 'PUT',
						contentType : 'application/json',
						data : JSON.stringify(data),
						dataType : 'json',
						success : function(result) {
							window.location.href = "${editgiaovienURL}?id="
									+ result.id + "&message=update_success";
						},
						error : function(error) {
							window.location.href = "${editgiaovienURL}?page=1&limit=10&message=error_system";
						}
					});
		}
	</script>
</body>
</html>