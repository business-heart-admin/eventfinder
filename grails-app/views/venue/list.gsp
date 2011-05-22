
<%@ page import="org.businessheart.Venue" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'venue.label', default: 'Venue')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'venue.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="name" title="${message(code: 'venue.name.label', default: 'Name')}" />
                        
                            <g:sortableColumn property="address1" title="${message(code: 'venue.address1.label', default: 'Address1')}" />
                        
                            <g:sortableColumn property="address2" title="${message(code: 'venue.address2.label', default: 'Address2')}" />
                        
                            <g:sortableColumn property="city" title="${message(code: 'venue.city.label', default: 'City')}" />
                        
                            <g:sortableColumn property="state" title="${message(code: 'venue.state.label', default: 'State')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${venueInstanceList}" status="i" var="venueInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${venueInstance.id}">${fieldValue(bean: venueInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: venueInstance, field: "name")}</td>
                        
                            <td>${fieldValue(bean: venueInstance, field: "address1")}</td>
                        
                            <td>${fieldValue(bean: venueInstance, field: "address2")}</td>
                        
                            <td>${fieldValue(bean: venueInstance, field: "city")}</td>
                        
                            <td>${fieldValue(bean: venueInstance, field: "state")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${venueInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
