
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="core" tagdir="/WEB-INF/tags/core/"%>

<form action="${pageContext.servletContext.contextPath}/edit" method="post">

    <core:error/>

    <p class="row gap-bottom">
        Editing publication
    </p>
    <input type="text" name="id" value="${param.id}" hidden="true">
    <p>
        <input type="text" name="headline" value="${param.title}" placeholder="Заголовок публикации" required="" >
    </p>    
    <p>
        <textarea class="centered" name="publication_text" style="width:900px; height:450px;">
            ${param.content}
        </textarea></p>       
    <p>
        <input type="submit" value="Edit" class="asphalt">
        <input type="reset" value="Clear" class="asphalt">
        <button class="pull-right">
            <a href="${pageContext.servletContext.contextPath}/projects">
                back
            </a>
        </button>
    </p>
</form>