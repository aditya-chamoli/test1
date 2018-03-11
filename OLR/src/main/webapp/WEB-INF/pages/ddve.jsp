<%@ page import="com.olr.model.Entity" %>
<html>
<head>
<style type="text/css">
span{
	font-weight:normal;
}

label{
	font-weight:bold;
}
</style>
</head>
<body>
<h2>One Line Requirement</h2>
<%
Entity entity = (Entity)request.getAttribute("entity");
%>
<div id="mainDiv" style="width:500px;">
	<label>Name :</label> <span><%=entity.getName()%></span>
	<br><br>
	<label>Simple Types :</label> <br><br>
	<div style="padding-left:50px;" id="stypeDiv">
	<%if(entity.getSimpleTypes()!=null){
		for(String sType: entity.getSimpleTypes()){ %>
		<p><%=sType%></span><br>
	<%}
	}%>
	</div>
	<br><br>
	<label>Complex Types :</label><br><br>
	<div style="padding-left:50px;" id="ctypeDiv">
		<%if(entity.getComplexTypes()!=null){
		for(Entity cType: entity.getComplexTypes()){ %>
		<a href="<%=request.getContextPath()%>/viewEntity/<%=cType.getEntityId()%>"><%=cType.getName()%></a><br>
	<%}
	}%>
	</div>
	<br><br>
</div>

</body>
</html>
