<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%@attribute name="exception"%>

<c:if test="${not empty exception}">
    <div class="box error gap-bottom gap-top">
        ${exception.message}
    </div>
</c:if>
    

