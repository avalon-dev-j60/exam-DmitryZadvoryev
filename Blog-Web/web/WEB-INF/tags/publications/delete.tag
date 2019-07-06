<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@taglib prefix="core" tagdir="/WEB-INF/tags/core/" %>
<%@taglib prefix="publications" tagdir="/WEB-INF/tags/publications/" %>

<form action ="${pageContext.servletContext.contextPath}/publication/delete" method="post">
    
    <c:if test = "${not empty publication}">
        <input type="hidden" name="id" value="${publication.id}">
    </c:if> 
        
    <c:choose>       
        <c:when test="${not empty sessionScope.user}" > 
            <div class ="del-style">
                <h2 class="align-center">
                    Are you sure you want to delete this publication?
                </h2>
                <div class="one half centered">
                    <p class=" pull-left">                      
                        <button>
                            Yes
                        </button>      
                    </p>
                    <div class=" pull-right">
                        <core:link location="/" title="Back" classes = "button"/>         
                    </div>        
                </div>              
            </div>
        </c:when>
        <c:otherwise>
            <jsp:forward page="/publications"/>
        </c:otherwise>
    </c:choose>     
</form>