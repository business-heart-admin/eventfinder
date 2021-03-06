<%@ page import="org.businessheart.Venue" %>
<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
         <meta name="layout" content="eventfinder" />
         <title>Edit Venue</title>
    </head>
    <body>
        <div class="body">
            <div class="titleSection">
                <h1 class="title">Edit Venue</h1>
                <div class="pageActions">
                    <span class="actionButton"><g:link action="list">Back to List</g:link></span>
                </div>
            </div>
            <g:if test="${flash.message}">
                 <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${venueInstance}">
                <div class="errors">
                    <g:renderErrors bean="${venueInstance}" as="list" />
                </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:renderDomain domain="${Venue.class}" 
                                template="editor" 
                                value="${venueInstance}" 
                                order="['name' , 'address1' , 'address2' , 'city' , 'state' , 'country' , 'zip' , 'contactName' , 'contactPhone' ,'capacity' , 'trainerComments' , 'studentComments' ]"
                                style="[id: [readonly: true], actions:[[update: 'Update'], [delete: 'Delete']] ]" />
            </g:form>
        </div>
    </body>
</html>
