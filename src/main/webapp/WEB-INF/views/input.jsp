<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form action="/emp" method="POST" modelAttribute="employee">
        LastName: <form:input path="lastName"/>
        <br>
        Email: <form:input path="email"/>
        <br>
        <%
            Map<String, String> genders = new HashMap();
            genders.put("1", "Male");
            genders.put("0", "Female");
            request.setAttribute("genders", genders);
        %>
        Genders: <form:radiobuttons path="gender" items="${genders}"/>
        <br>
        Department: <form:select path="department" items="${departments}" itemLabel="departmentName"
                                 itemValue="id"></form:select>
        <br>
        <input type="submit" value="Submit">
    </form:form>
</body>
</html>
