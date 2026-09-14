<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Khai báo JSTL để xử lý điều kiện hiển thị tốt hơn -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    <style>
        table { border-collapse: collapse; width: 50%; }
        th, td { border: 1px solid black; padding: 8px; text-align: left; }
    </style>
</head>
<body>
    <header>
        <h1>Downloads</h1>
        <!-- Xử lý hiển thị tên Album an toàn bằng EL -->
        <h2>${empty description ? 'Album not found' : description}</h2>
    </header>
    <section>
        <!-- Chỉ hiển thị bảng bài hát nếu tồn tại productCode -->
        <c:if test="${not empty productCode}">
            <table>
                <tr>
                    <th>Song title</th>
                    <th>Audio Format</th>
                </tr>
                <c:forEach var="song" items="${songs}">
                    <tr>
                        <td>${song.title}</td>
                        <td><a href="music/${productCode}/${song.file}">MP3</a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>

        <p><a href="index.jsp">Return to list of albums</a></p>
    </section>
</body>
</html>