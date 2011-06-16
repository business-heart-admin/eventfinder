<%@ page import="org.businessheart.Event" %>
<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
         <meta name="layout" content="no-img-skin" />
         <title>Event List</title>
    </head>
    <body>
        <div class="body">
            <div class="titleSection">
            <h1 class="title">Event List</h1>
            <div class="pageActions">
            <span class="actionButton"><g:link action="create">Create</g:link></span></div>
            </div>
            <g:if test="${flash.message}">
                <div class="message">
                    ${flash.message}
                </div>
            </g:if>
            <g:renderDomain domain="${Event.class}" 
                            template="list" 
                            value="${eventInstanceList}" 
                            order="['name', 'description', 'venue', 'trainer', 'startTime', 'endTime', 'keywords', 'level', 'trainerComments', 'studentComments', 'attachment']"
                            exceptWhen="${ { prop -> prop.type == Set.class } }"
                            style="[actions:[[show:'Show'], [edit: 'Edit']] ]" />
            <div class="paginateButtons">
                <g:paginate total="${Event.count()}" />
            </div>
        </div>
    </body>
</html>
