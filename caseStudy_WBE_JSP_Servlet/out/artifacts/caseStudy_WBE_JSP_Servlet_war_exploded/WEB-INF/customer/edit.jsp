<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 12/25/2020
  Time: 1:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit customer</title>
</head>
<body>
<center>
    <h2>
        <a href="/customers">List All Customer</a>
    </h2>
</center>
<div align="center">
    <form method="post" action="/customers">
        <input type="hidden" name="action" value="edit">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Customer
                </h2>
            </caption>
            <tr>
                <th>ID:</th>
                <td>
                    <input type="text" name="customer_id" size="45"
                           value="<c:out value='${cus.idCustomer}' />" readonly/>
                </td>
            </tr>
            <tr>
                <th>Type-:</th>
                <td>
                    <select name="customer_type_id">
                        <c:forEach items="${customerTypeList}" var="type">
                            <%--                            <c:if test="${type.id == customer.customerTypeId}">--%>
                            <%--                                <option value="${type.id}" selected>${type.name}</option>--%>
                            <option value="${type.idCustomerType}"}>${type.nameCustomerType}</option>
                            <%--                            </c:if>--%>
                            <%--                            <c:if test="${type.id != customer.customerTypeId}">--%>
                            <%--                                <option value="${type.id}">${type.name}</option>--%>
                            <%--                            </c:if>--%>

                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>name:</th>
                <td>
                    <input type="text" name="customer_name" size="45"
                           value="<c:out value='${cus.nameCustomer}'/>"/>
                </td>
            </tr>
            <tr>
                <th>Birthday:</th>
                <td>
                    <input type="date" name="customer_birthday" size="45"
                           value="<c:out value='${cus.birthday}' />"/>
                </td>
            </tr>
            <tr>
                <th>Gender:</th>
                <td>
                    <%--                    <input type="text" name="gender" size="45"--%>
                    <%--                           value="<c:out value='${customer.customerGender}' />"/>--%>
                    <select name="customer_gender">
                        <%--                        <option value="1" >nam</option>--%>
                        <%--                        <option value="0" >nu</option>--%>
                        <option value="0" ${customer.gender == 0 ? 'selected':''}>Nu</option>
                        <option value="1" ${customer.gender == 1 ? 'selected':''}>Nam</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>ID-Card:</th>
                <td>
                    <input type="text" name="Customer_id_card" size="45"
                           value="<c:out value='${cus.idCard}' />"/>
                </td>
            </tr>
            <tr>
                <th>Phone:</th>
                <td>
                    <input type="text" name="customer_phone" size="45"
                           value="<c:out value='${cus.phoneNumber}' />"/>
                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <input type="text" name="customer_email" size="45"
                           value="<c:out value='${cus.email}' />"/>
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input type="text" name="customer_address" size="45"
                           value="<c:out value='${cus.address}' />"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
