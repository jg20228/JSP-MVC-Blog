<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/nav.jsp"%>

<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<div class="container">
	<div id="summernote">
		<p>Hello Summernote</p>
	</div>
	<script>
		$(document).ready(function() {
			$('#summernote').summernote({
				tabsize : 2,
				height : 300
			});
		});
	</script>
</div>
<%@ include file="../include/footer.jsp"%>


