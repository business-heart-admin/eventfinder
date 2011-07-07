<%@ page import="org.businessheart.Event" %>
<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
         <meta name="layout" content="eventfinder" />
         <title>Create Event</title>         
    </head>
    <body>
        <div class="body">
            <div class="titleSection">
                <h1 class="title">Create Event</h1>
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
            <g:form action="save" method="post"  enctype="multipart/form-data">
                <g:renderDomain domain="${Event.class}" 
                                template="editor" 
                                value="${eventInstance}" 
                                order="['name', 'description', 'venue', 'trainer', 'startTime', 'endTime', 'keywords', 'level', 'trainerComments', 'studentComments', 'attachment']"
                                except="['id']"
                                exceptWhen="${ { prop -> prop.type == Set.class } }"
                                style="[actions:[[save: 'Create']] ]" />
            </g:form>
        </div>
    </body>
</html>
