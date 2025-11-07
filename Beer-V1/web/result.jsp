<%@ page import="java.util.*" %>
<!doctype html>
<html>
<head>
	<title>Beer Advice</title>
	<style>
		@media print {
			.d-print-none {
				display:none;
			}
		}
		
		@media screen {
			.d-screen-none {
				display:none;
			}
			
			.blue-border {
				border: 1.5px solid blue;
			}
		}
	</style>
</head>
<body>
<h1 align="center" class="d-print-none">Beer Recommendations JSP</h1>
<h3 align="center" style="color:blue;" class="d-screen-none">Beer Recommendations JSP</h3>
<%
if(request.getAttribute("brands") != null) {
%>
<ul class="blue-border">
<%
	out.append("<h4>Brands found.</h4><ul>");
	List<String> styles = (ArrayList<String>)request.getAttribute("brands");
	Iterator<String> it = styles.iterator();
	while(it.hasNext()) {
		
		out.append("<li>try: " + it.next() + "</li>");
	}
%>
</ul>
<%
} else {
%>
<h4>No Brands found.</h4>
<%
}
%>
<div style="margin:100px 0 0;"><a href="form.html">Back</a></div>
</body>
</html>