<%@ page pageEncoding="utf-8"%>
<script type="text/javascript">
	$(function() {
		$("#tijiao").linkbutton({
			onClick : function() {
				$("#addform").form("submit", {
					url : "${pageContext.request.contextPath}/banner/add",
					onSubmit : function() {
						return $("#addform").form("validate");
					},
					success : function() {
						$.messager.show({
							title : "标题",
							msg : "保存成功"
						});
						$("#dgbanner").edatagrid("load");
					}
				});
				$("#banneradddiv").dialog("close");
			}
		});
		$("#chongzhi").linkbutton({
			onClick : function() {
				$("#addform").form("reset");
			}
		});
		$("#put1").textbox({
			required : true,
		});
		$("#put2").textbox({
			required : true,
		});
		$("#put3").textbox({
			required : true,
		});
		$("#put4").textbox({
			required : true,
		});


	});
</script>
<form method="post" id="addform" enctype="multipart/form-data">
	title：<input id="put1" name="title" /><br>
	商品的图片路径  ：<input type="file"  name="srcpath"/><br/>
	stauts：<input id="put3" name="stauts" /><br>
	descriptlon：<input id="put4" name="descriptlon" /><br>
	<a id="tijiao">提交</a> <a id="chongzhi">重置</a>
</form>
