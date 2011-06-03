
<%@ page import="org.businessheart.Trainer" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'trainer.label', default: 'Trainer')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="id" title="${message(code: 'trainer.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="name" title="${message(code: 'trainer.name.label', default: 'Name')}" />
                        
                            <g:sortableColumn property="email" title="${message(code: 'trainer.email.label', default: 'Email')}" />
                            
                            <g:sortableColumn property="displayGravatar" title="Current Gravatar"/>
                        
                            <g:sortableColumn property="displayGravatar" title="${message(code: 'trainer.displayGravatar.label', default: 'Display Gravatar')}" />
                        
                            <g:sortableColumn property="phone" title="${message(code: 'trainer.phone.label', default: 'Phone')}" />
                        
                            <g:sortableColumn property="address1" title="${message(code: 'trainer.address1.label', default: 'Address1')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${trainerInstanceList}" status="i" var="trainerInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${trainerInstance.id}">${fieldValue(bean: trainerInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: trainerInstance, field: "name")}</td>
                        
                            <td>${fieldValue(bean: trainerInstance, field: "email")}</td>
                            
                            <td><avatar:gravatar email="${trainerInstance.email}" size="60"/></td>
                        
                            <td><g:formatBoolean boolean="${trainerInstance.displayGravatar}" /></td>
                        
                            <td>${fieldValue(bean: trainerInstance, field: "phone")}</td>
                        
                            <td>${fieldValue(bean: trainerInstance, field: "address1")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${trainerInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
