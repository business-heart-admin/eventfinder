<%@ page import="org.businessheart.Venue" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="eventfinder" />
        <title>Show Venue</title>
    </head>
    <body>
        <div class="body">
            <div class="titleSection">
                <h1 class="title">Show Venue</h1>
                <div class="pageActions">
                    <span class="actionButton"><g:link action="list">Back to List</g:link></span>
                </div>
            </div>
            <g:if test="${flash.message}">
                 <div class="message">${flash.message}</div>
            </g:if>
            <g:if test="${venueInstance}">
                <g:renderDomain domain="${Venue.class}" 
                                template="show" 
                                value="${venueInstance}" 
                                order="['name' , 'address1' , 'address2' , 'city' , 'state' , 'country' , 'zip' , 'contactName' , 'contactPhone' ,'capacity' , 'trainerComments' , 'studentComments' ]"
                                style="[actions:[[edit: 'Edit'], [delete: 'Delete']] ]"/>
            </g:if>
        </div>
    </body>
</html>
