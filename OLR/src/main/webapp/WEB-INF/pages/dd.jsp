<html>
<head>
<script type="text/javascript">
var count=1;
function addMore(){
	var node = document.getElementById("stypeDiv");
	var newNode = document.createElement("input");
	newNode.setAttribute("type","text");
	newNode.setAttribute("name","stype"+(++count));
	newNode.setAttribute("size","50");
	node.appendChild(newNode);
}

var count1=1;
function addMore1(){
	var node = document.getElementById("ctypeDiv");
	var newNode = document.createElement("input");
	newNode.setAttribute("type","text");
	newNode.setAttribute("name","ctype"+(++count1));
	newNode.setAttribute("size","50");
	node.appendChild(newNode);
}
</script>
<style type="text/css">
input{
	margin-top:10px;
}

label{
font-weight:bold;
}
</style>
</head>
<body>
<h2>One Line Requirement</h2>

<form action="<%=request.getContextPath()%>/addEntity" method="POST">
<div id="mainDiv" style="width:500px;">
	<label>Name :</label> <input type="text" name="name" size="50"/>
	<br><br>
	<label>Simple Types :</label> <a href="#" onclick="javascript:addMore();" style="text-decoration: none;">+</a><br><br>
	<div style="padding-left:50px;" id="stypeDiv">
		<input type="text" name="stype1" size="50"/> 
	</div>
	<br><br>
	<label>Complex Types :</label> <a href="#" onclick="javascript:addMore1();" style="text-decoration: none;">+</a><br><br>
	<div style="padding-left:50px;" id="ctypeDiv">
		<input type="text" name="ctype1" size="50"/> 
	</div>
	<br><br>
	<input type="submit" name="sbtn" value="Save">
</div>
</form>
</body>
</html>
