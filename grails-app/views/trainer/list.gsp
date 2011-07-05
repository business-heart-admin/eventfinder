<%@ page import="org.businessheart.Trainer" %>
<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
         <meta name="layout" content="eventfinder" />
         <title>Trainer List</title>
    </head>
    <body>
        <div class="body">
            <div class="titleSection">
            <h1 class="title">Trainer List</h1>
            <div class="pageActions">
            <span class="actionButton"><g:link action="create">Create</g:link></span></div>
            </div>
            <g:if test="${flash.message}">
                <div class="message">
                    ${flash.message}
                </div>
            </g:if>
            <g:renderDomain domain="${Trainer.class}"
                            template="list"
                            value="${trainerInstanceList}"
                            exceptWhen="${ { prop -> prop.type == Set.class } }"
                            order="['firstName' , 'lastName' , 'email' , 'displayGravatar' , 'phone' , 'address1' , 'address2' , 'city' , 'state' , 'country' , 'zip' , 'organization' , 'website' ,'certifications' , 'active' , 'keywords' , 'comments' ]"
                            style="[actions:[[show:'Show'], [edit: 'Edit']] ]" />
            <div class="paginateButtons">
                <g:paginate total="${Trainer.count()}" />
            </div>
        </div>
    </body>
</html>
