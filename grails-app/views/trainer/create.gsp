<%@ page import="org.businessheart.Trainer" %>
<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
         <meta name="layout" content="eventfinder" />
         <title>Create Trainer</title>
    </head>
    <body>
        <div class="body">
            <div class="titleSection">
                <h1 class="title">Create Trainer</h1>
                <div class="pageActions">
                    <span class="actionButton"><g:link action="list">Back to List</g:link></span>
                </div>
            </div>
            <g:if test="${flash.message}">
                 <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${trainerInstance}">
                <div class="errors">
                    <g:renderErrors bean="${trainerInstance}" as="list" />
                </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <g:renderDomain domain="${Trainer.class}"
                                template="editor"
                                value="${trainerInstance}"
                                order="['firstName' , 'lastName' , 'email' , 'displayGravatar' , 'phone' , 'address1' , 'address2' , 'city' , 'state' , 'country' , 'zip' , 'organization' , 'website' ,'certifications' , 'active' , 'keywords' , 'comments' ]"
                                except="['id']"
                                exceptWhen="${ { prop -> prop.type == Set.class } }"
                                style="[actions:[[save: 'Create']] ]" />
            </g:form>
        </div>
    </body>
</html>
