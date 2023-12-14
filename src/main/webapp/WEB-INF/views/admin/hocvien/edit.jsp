<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="hocvienURL" value="/quan-tri/bai-viet/danh-sach" />
<c:url var="edithocvienURL" value="/quan-tri/bai-viet/chinh-sua" />
<c:url var="hocvienAPI" value="/api/hocvien" />
<html>
<head>
<title>Chỉnh sửa Học Viên</title>
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
					<li><a href='<c:url value='/quan-tri/bai-viet/danh-sach?page=1&limit=10'/>'>Danh sách học viên</a></li>
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
									for="form-field-1"> MSSV </label>
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
									for="form-field-1"> Mã lớp </label>
								<div class="col-sm-9">
									<form:input path="classUITCode" cssClass="col-xs-10 col-sm-5"
										id="classUITCode" />
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
							<form:hidden path="id" id="hocVienId" />
							
								<div class="col-md-offset-3 col-md-9"  >
									<c:if test="${not empty model.id}">
										<button class="btn btn-info" type="button"
											id="btnAddOrUpdateHocVien">
											<i class="ace-icon fa fa-check bigger-110"></i> Cập nhật bài
											viết
										</button>
									</c:if>
									<c:if test="${empty model.id}">
										<button class="btn btn-info" type="button"
											id="btnAddOrUpdateHocVien">
											<i class="ace-icon fa fa-check bigger-110"></i> Thêm bài viết
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
		$('#btnAddOrUpdateHocVien').click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});
			var id = $('#hocVienId').val();
			if (id == "") {
				addHocVien(data);
			} else {
				updateHocVien(data);
			}
		});

		function addHocVien(data) {
			$.ajax({
						url : '${hocvienAPI}',
						type : 'POST',
						contentType : 'application/json',
						data : JSON.stringify(data),
						dataType : 'json',
						success : function(result) {
							window.location.href = "${edithocvienURL}?id="
									+ result.id + "&message=insert_success";
						},
						error : function(error) {
							window.location.href = "${hocvienURL}?page=1&limit=10&message=error_system";
						}
					});
		}

		function updateHocVien(data) {
			$.ajax({
						url : '${hocvienAPI}',
						type : 'PUT',
						contentType : 'application/json',
						data : JSON.stringify(data),
						dataType : 'json',
						success : function(result) {
							window.location.href = "${edithocvienURL}?id="
									+ result.id + "&message=update_success";
						},
						error : function(error) {
							window.location.href = "${edithocvienURL}?page=1&limit=10&message=error_system";
						}
					});
		}
	</script>
</body>
</html>