<%@page import="Models.studentmodel"%>
<%@page import="java.util.List"%>
<%@page import="Dbconnection.studentdb"%>
<%@page import="Services.studentservice"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student List</title>
<!-- Bootstrap CSS CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
    body {
        background-color: #f8f9fa;
        display: flex;
        flex-direction: column;
        align-items: center;
        padding: 20px;
    }
    .container {
        background-color: #fff;
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }
    .table-container {
        margin-top: 20px;
    }
    .table th, .table td {
        vertical-align: middle;
    }
    .btn-custom {
        margin-right: 5px;
    }
</style>
</head>
<body>
<div class="container">
    <a href="register.jsp" class="btn btn-primary mb-3">REGISTER</a>
    <div class="table-container">
        <table class="table table-bordered table-hover">
            <thead class="thead-dark">
                <tr>
                    <th>PIN</th>
                    <th>NAME</th>
                    <th>EMAIL</th>
                    <th>BRANCH</th>
                    <th>ACTIONS</th>
                </tr>
            </thead>
            <tbody>
            <%
            studentservice service = new studentservice(studentdb.conn());
            List<studentmodel> st = service.fetchall();
            for(studentmodel s : st) {
            %>
                <tr>
                    <td><%=s.getPinno() %></td>
                    <td><%=s.getName() %></td>
                    <td><%=s.getEmail() %></td>
                    <td><%=s.getBranch() %></td>
                    <td>
                        <a href="update.jsp?pinno=<%=s.getPinno() %>">
                       <button class="btn btn-warning btn-custom">UPDATE</button>
                        </a>
                       <a href="delete?pinno=<%=s.getPinno() %>">
                        <button class="btn btn-danger">DELETE</button>
                       </a>
                    </td>
                </tr>
            <%
            }
            %>
            </tbody>
        </table>
    </div>
</div>
<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
