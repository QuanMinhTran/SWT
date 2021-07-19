<%-- 
    Document   : laptopsform
    Created on : Mar 14, 2021, 9:43:07 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>laptop form</title>
    </head>
    <body>
        <h1>Add new laptop infomation</h1>
        <form action="create" method="POST">
            <table>
                <tr>
                    <td>ID</td>
                    <td>: <input type="text" name="ID" value="${param.txt}"/>
                        <font color ="red"> ${requestScope.INVALID.idError} </font></td>
                </tr>
                <tr>
                    <td>Laptop Name</td>
                    <td>: <input type="text" name="LaptopName" value="${param.txtLaptopName}"/>
                        <font color= "red">
                        ${requestScope.INVALID.LaptopNameError}</font>
                    </td>
                </tr>
                <tr>
                    <td>Technical Information</td>
                    <td>: <input type="text" name="TechnicalInformation" value="${param.txtTechnicalInformation}"/>
                        <font color= "red">
                        ${requestScope.INVALID.TechnicalInformationError}</font>
                    </td>
                </tr>
                <tr>
                    <td>Year Of Manufacture</td>
                    <td>: <input type="text" name="YearOfManufacture" value="${param.txtYearOfManufacture}"/>
                        <font color= "red">
                        ${requestScope.INVALID.YearOfManufactureError}</font>
                    </td>
                </tr>
                <tr>
                    <td>Producer</td>
                    <td>: <input type="text" name="Producer" value="${param.txtProducer}"/>
                        <font color= "red">
                        ${requestScope.INVALID.ProducerError}</font>
                    </td>
                </tr>
                <tr>
                    <td>Status</td>
                    <td>: <input type="text" name="Status" value="${param.txtStatus}"/>
                        <font color= "red">
                        ${requestScope.INVALID.StatusError}</font>
                    </td>
                </tr>
                <tr>
                    <td>Supplier</td>
                    <td>: <select>
                            <c:forEach name="Supplier" items="${requestScope.listSuppliers}" var="dto">
                                <option value="${dto.supplierID}">${dto.supplierId}-${dto.supplierName}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                <c:url value="create" var="create"></c:url>
                    <td colspan="2"> <input type="submit" value="Create"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
