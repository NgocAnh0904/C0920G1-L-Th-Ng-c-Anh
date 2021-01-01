<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 12/28/2020
  Time: 9:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Benh An</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
          integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA=="
          crossorigin="anonymous"/>
    <jsp:include page="/shared/libCss.jsp"/>
</head>
<body>
<div id="head">
    <div id="head_top">
        <p>NgocAnh0904</p>
    </div>
    <div id="headbottom">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#"><h4 style="color: blueviolet">Home</h4></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul id="abc" class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="/employees">Benh An<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="/customers">Benh Nhan<span class="sr-only">(current)</span></a>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
</div>
<div id="content">
    <center>
        <h1>Admin</h1>
        <h2>
            <a href="/customers?action=create">Add New BenhAn</a>
        </h2>
    </center>
    <table class="table table-striped" id="tableBenhAn">
        <thead>
        <tr>
            <th scope="col">ID-BenhAn</th>
            <th scope="col">ID-BenhNhan</th>
            <th scope="col">Name-BenhNhan</th>
            <th scope="col">DateIn</th>
            <th scope="col">DateOut</th>
            <th scope="col">ReasonIn</th>
            <th scope="col">Edit</th>
            <th scope="col">Delete</th>

        </thead>
        <tbody>
        <c:forEach items="${benhAnList}" var="cus">
            <tr>
                <td><c:out value="${cus.idBenhAn}"/></td>
                <td><c:out value="${cus.dateIn}"/></td>
                <td><c:out value="${cus.dateOut}"/></td>
                <td><c:out value="${cus.reasonIn}"/></td>
                <td>
                    <a href="/customers?action=edit&id=${cus.idBenhAn}" class="btn btn-primary">Edit</a>
                </td>
                <td>
                    <button type="button" class="btn btn-danger" onclick="getIdBenhAn('${cus.idBenhAn}')"
                            data-toggle="modal" data-target="#modelDeleteCustomer">Delete</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <h2 style="text-align: center;color: yellow">${messageConfig}</h2>
</div>

<div class="modal fade" id="modelDeleteCustomer" tabindex="-1" role="dialog" aria-labelledby="modelTitleId"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Delete</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form method="get" action="/customers">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="BenhAnId" id="idBenhAn">
                <div class="modal-body">
                    Are You Sure?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">cancel</button>
                    <button type="submit" class="btn btn-primary">OK!</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
<script>
    function getIdBenhAn(id) {
        $('#idBenhAn').val(id);
    }
</script>
    <jsp:include page="/shared/libJs.jsp"/>
</html>
