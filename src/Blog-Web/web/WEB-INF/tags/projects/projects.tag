
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="core" tagdir="/WEB-INF/tags/core/"%>

<core:error/>

<c:choose>
    <c:when test = "${not empty sessionScope.user}">

        <div class="two thirds centered padded"">
            <button>
                <a href="${pageContext.servletContext.contextPath}/create">
                    Create publication
                </a>           
            </button>
        </div>
    </c:when>
    <c:otherwise>
        <div class="two thirds centered padded">
            Зарегистрируйтесь, чтобы создавать публикации. <br>                         
        </div>
    </c:otherwise>
</c:choose>           
<div class=" two thirds centered padded">
    <c:choose>
        <c:when test="${not empty projects}">
            <c:forEach items="${projects}" var="item">

                <div style="padding-bottom: 10; padding-top: 10">
                    <h6>
                        <b>${item.title}</b><br>                                
                    </h6>
                    ${item.content}<br>               
                    <c:if test="${sessionScope.user == item.author.email}">
                        <button>
                            <a href="${pageContext.servletContext.contextPath}/edit?title=${item.title}&content=${item.content}&id=${item.id}"/>
                            Edit
                            </a>                                        
                        </button> 
                    </c:if>
                </div>                              
            </c:forEach>             
        </c:when>
        <c:otherwise>
            There are no projects
        </c:otherwise>        
    </c:choose>           
</div>