<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="core" tagdir="/WEB-INF/tags/core/" %>
<%@taglib prefix="publications" tagdir="/WEB-INF/tags/publications/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<core:layout title="${publication.title}">   
    <div class="row gap-bottom">
    <publications:view publication="${publication}"/>    
    </div>
    <div class=" row pull-right">
    <c:if test="${sessionScope.user == publication.author.email}">
        <core:link location="/publication/edit?id=${publication.id}" title="Edit publication" classes = "button"/>
        <core:link location="/publication/delete?id=${publication.id}" title="Delete publication" classes = "button"/>
    </c:if>          
    </div>
</core:layout>
