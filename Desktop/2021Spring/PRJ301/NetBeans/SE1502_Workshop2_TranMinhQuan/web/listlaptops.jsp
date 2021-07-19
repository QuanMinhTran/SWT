<%-- 
    Document   : listlaptops
    Created on : Mar 14, 2021, 9:33:17 PM
    Author     : Admin
--%>
<%@page import="dtos.Laptops"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Laptops List</title>
    </head>
    <body>
        <h1>Laptop Management</h1>
        <c:if test ="${requestScope.listLaptops!=null}">
            <c:if test = "${not empty requestScope.listLaptops}" var = "testEmpty">
                <table border = "1">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>LaptopName</th>
                            <th>TechnicalInformation</th>
                            <th>YearOfManufacture</th>
                            <th>Producer</th>
                            <th>Status</th>
                            <th>Supplier Name</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.listLaptops}" var="dto">
                        <form action="loadByID" method="POST">
                            <tr>
                                <td>
                                    ${dto.id}
                                </td>
                                <td>${dto.laptopName}</td>
                                <td>${dto.technicalInformation}</td>
                                <td>${dto.yearOfManufacture}</td>
                                <td>${dto.producer}</td>
                                <td>${dto.status}</td>
                                <td>${dto.supplierID.supplierName}</td>
                                <td>
                                    <c:url value="delete" var="deleteLink">
                                        <c:param name="id" value="${dto.id}"/>
                                    </c:url>    

                                    <a href="${deleteLink}" onclick="return confirmation()">Delete</a>
                                </td>
                            </tr>
                        </form>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        <c:if test="${!testEmpty}">
            <h2>No Laptops here</h2>
        </c:if>
    </c:if>
    <c:url value="loadSupplier" var="loadSupplierLink"></c:url>
        <a href="${loadSupplierLink}">Create new computer</a>
        
    <script>
        function confirmation() {
            var r = confirm("Are you sure you want to delete this?")
            return r;
        }
    </script>

</body>
</html>
