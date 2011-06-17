<%@ page import="org.businessheart.Event" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="no-img-skin" />
        <title>Show Event</title>
    </head>
    <body>
        <div class="body">
            <div class="titleSection">
                <h1 class="title">Show Event</h1>
                <div class="pageActions">
                    <span class="actionButton"><g:link action="list">Back to List</g:link></span>
                </div>
            </div>
            <g:if test="${flash.message}">
                 <div class="message">${flash.message}</div>
            </g:if>
            <g:if test="${eventInstance}">
                <g:renderDomain domain="${Event.class}" 
                                template="show" 
                                value="${eventInstance}" 
                                order="['name', 'description', 'venue', 'trainer', 'startTime', 'endTime', 'keywords', 'level', 'trainerComments', 'studentComments', 'attachment']"
                                style="[actions:[[edit: 'Edit'], [delete: 'Delete']] ]"/>
            </g:if>
        </div>
    </body>
</html>
