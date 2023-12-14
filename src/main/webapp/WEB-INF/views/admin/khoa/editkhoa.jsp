<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="khoaURL" value="/quan-tri/bai-viet/danh-sach-khoa" />
<c:url var="editkhoaURL" value="/quan-tri/bai-viet/chinh-sua-khoa" />
<c:url var="khoaAPI" value="/api/khoa" />
<html>
<head>
<title>Chỉnh sửa Khoa</title>
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
					<li><a href='<c:url value='/quan-tri/bai-viet/danh-sach-khoa?page=1&limit=10'/>'>Danh sách khoa</a></li>
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
									for="form-field-1"> Mã khoa </label>
								<div class="col-sm-9">
									<form:input path="code" cssClass="col-xs-10 col-sm-5" id="code" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1">Khoa</label>
								<div class="col-sm-9">
									<form:input path="name" cssClass="col-xs-10 col-sm-5" id="name" />
								</div>
							</div>
							
							
							<form:hidden path="id" id="khoaId" />
							
								<div class="col-md-offset-3 col-md-9"  >
									<c:if test="${not empty model.id}">
										<button class="btn btn-info" type="button"
											id="btnAddOrUpdateKhoa">
											<i class="ace-icon fa fa-check bigger-110"></i> Cập nhật khoa
										</button>
									</c:if>
									<c:if test="${empty model.id}">
										<button class="btn btn-info" type="button"
											id="btnAddOrUpdateKhoa">
											<i class="ace-icon fa fa-check bigger-110"></i> Thêm Khoa
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
		$('#btnAddOrUpdateKhoa').click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});
			var id = $('#KhoaId').val();
			if (id == "") {
				addKhoa(data);
			} else {
				updateKhoa(data);
			}
		});

		function addKhoa(data) {
			$.ajax({
						url : '${khoaAPI}',
						type : 'POST',
						contentType : 'application/json',
						data : JSON.stringify(data),
						dataType : 'json',
						success : function(result) {
							window.location.href = "${editkhoaURL}?id="
									+ result.id + "&message=insert_success";
						},
						error : function(error) {
							window.location.href = "${khoaURL}?page=1&limit=10&message=error_system";
						}
					});
		}

		function updateKhoa(data) {
			$.ajax({
						url : '${khoaAPI}',
						type : 'PUT',
						contentType : 'application/json',
						data : JSON.stringify(data),
						dataType : 'json',
						success : function(result) {
							window.location.href = "${editkhoaURL}?id="
									+ result.id + "&message=update_success";
						},
						error : function(error) {
							window.location.href = "${editkhoaURL}?page=1&limit=10&message=error_system";
						}
					});
		}
	</script>
</body>
</html>