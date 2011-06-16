<%@ page import="org.businessheart.Event" %>
<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
         <meta name="layout" content="no-img-skin" />
         <title>Edit Event</title>
    </head>
    <body>
        <div class="body">
            <div class="titleSection">
                <h1 class="title">Edit Event</h1>
                <div class="pageActions">
                    <span class="actionButton"><g:link action="list">Back to List</g:link></span>
                </div>
            </div>
            <g:if test="${flash.message}">
                 <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${eventInstance}">
                <div class="errors">
                    <g:renderErrors bean="${eventInstance}" as="list" />
                </div>
            </g:hasErrors>
            <g:form method="post"  enctype="multipart/form-data">
                <g:renderDomain domain="${Event.class}" 
                                template="editor" 
                                value="${eventInstance}"
order="['name', 'description', 'venue', 'trainer', 'startTime', 'endTime', 'keywords', 'level', 'trainerComments', 'studentComments', 'attachment']"
                                style="[id: [readonly: true], actions:[[update: 'Update'], [delete: 'Delete']] ]" />
            </g:form>
        </div>
    </body>
</html>
