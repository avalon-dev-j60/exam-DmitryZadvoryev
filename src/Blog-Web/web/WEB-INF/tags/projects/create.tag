
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="core" tagdir="/WEB-INF/tags/core/"%>

<form action="${pageContext.servletContext.contextPath}/create" method="post"> 

    <core:error/>
    
    <p class="row gap-bottom">
        Publication title
    </p>
    <p>
        <input type="text" name="headline" placeholder="Заголовок публикации" required="" >
    </p>    
    <p>
        <textarea class="centered" name="publication_text" style="width:900px; height:450px;"></textarea></p>
    <p>
        <input type="submit" value="Опубликовать" class="asphalt">
        <input type="reset" value="Очистить" class="asphalt">
        <button class="pull-right">
        <a href="${pageContext.servletContext.contextPath}/projects">
            back
        </a>
    </button>
    </p>
</form>