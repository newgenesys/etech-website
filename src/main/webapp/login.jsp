<%-- 
    Document   : login
    Created on : Jun 10, 2022, 6:12:58 PM
    Author     : ngt
--%>

<%@ include file="header.jsp" %>
<div th:if="${param.error}">
    Invalid username and password.
</div>
<div th:if="${param.logout}">
    You have been logged out.
</div>
<form th:action="@{/login}" method="post">
    <div><label> User Name : <input type="text" name="username"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <div><input type="submit" value="Sign In"/></div>
</form>

<%@ include file="footer.jsp" %> 