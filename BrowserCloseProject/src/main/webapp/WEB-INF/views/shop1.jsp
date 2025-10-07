<%@ taglib uri="http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 <form:form action="/form1/shop1" method="POST" modelAttribute="shop1Obj">
     <h1>Vegetable Shop....</h1>
        <c:forEach var="item" items="${items}">
            <label>
                <input type="checkbox" name="selectedItems" value="${item.itemdesc}" />
                ${item.itemdesc} - Rs ${item.itemprice}
            </label><br/>
        </c:forEach>
        
			<input type="submit" value="Next Shop">
</form:form>

    <form action="${pageContext.request.contextPath}/form1/logout" method="post">
        <button type="submit">Logout</button>
    </form>