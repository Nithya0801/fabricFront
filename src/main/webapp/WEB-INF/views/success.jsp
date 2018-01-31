<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>
body {font-family: Arial;}

/* Style the tab */
.tab {
    overflow: hidden;
    border: 1px solid #ccc;
    background-color: #f1f1f1;
}

/* Style the buttons inside the tab */
.tab button {
    background-color: inherit;
    float: left;
    border: none;
    outline: none;
    cursor: pointer;
    padding: 14px 16px;
    transition: 0.3s;
    font-size: 17px;
}

/* Change background color of buttons on hover */
.tab button:hover {
    background-color: #ddd;
}

/* Create an active/current tablink class */
.tab button.active {
    background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
    display: none;
    padding: 6px 12px;
    border: 1px solid #ccc;
    border-top: none;
}
</style>
</head>
<body>

<%@page import="com.project.Model.User" %>
<%@include file="header.jsp" %>
<br>
<br>
<br>
WELCOME

<a href="getAllUser">View ALL User Details</a>
<br>
<br>
<br>
<center>
<div class="tab">
  <button class="tablinks" onclick="openCity(event, 'Product')">Product</button>
  <button class="tablinks" onclick="openCity(event, 'Category')">Category</button>
  <button class="tablinks" onclick="openCity(event, 'Supplier')">Supplier</button>
</div>

<div id="Product" class="tabcontent">
  <h3>London</h3>
  <p>London is the capital city of England.</p>
</div>

<div id="Category" class="tabcontent">
  <h3>CATEGORY DETAILS</h3>
  <%@include file="category.jsp" %>
</div>

<div id="Supplier" class="tabcontent">
  <h3>SUPPLIER DETAILS</h3>
 <%@include file="supplier.jsp" %>
</div>

<script>
function openCity(evt, cityName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(cityName).style.display = "block";
    evt.currentTarget.className += " active";
}
</script>
     
</center>

<%@include file="footer.jsp" %>
</body>
</html>