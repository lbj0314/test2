<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="./imgWrite" method="post" id="frm" enctype="multipart/form-data">

				<div id="files">
					<div class="form-group" title="parent">
						<label for="file">File : </label>
						<input type="file" name="file" class="form-control" id="file">
						<input type="button" class="btn btn-danger del" value="Del">
					</div>
				</div>
				
				<input type="button" class="btn btn-success" value="Add File" id="add">
				<button type="submit" class="btn btn-default">Write</button>
				

	</form>
<script type="text/javascript">
	var files = $("#files").html();
	var num = 0;
	//var index = 1;
	
	$("#files").empty();
	
		$("#files").on("click", ".del", function() {
			
			//$(this).parent().remove();
			$(this).parents(".form-group").remove();
			//var i = $(this).attr('title');
			//$("#"+i).remove();
			num--;
		});
		
		
	$("#add").click( function() {
		//var files='<div id="f'+index+'"><input type="file"><input type="button" title="f'+index+'" class="del" value="del">';
		if (num > 4) {
			alert("파일의 갯수는 5개까지 올릴 수 있습니다.");
		}
		$("#files").append(files);
		num++;
	});
	

</script>
</body>
</html>