<html>
<body>
<h2>One Line Requirement</h2>

<form action="<%=request.getContextPath()%>/saveAnswer" method="POST">
Question: <span><%=""%> </span><br/>
Answer : <input type="text" name="answer" size="100"/><br/>
<input type="submit" value="Submit"/><br/>
</form>
</body>
</html>
