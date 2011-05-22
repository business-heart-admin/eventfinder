

<%@ page import="org.businessheart.Venue" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'venue.label', default: 'Venue')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${venueInstance}">
            <div class="errors">
                <g:renderErrors bean="${venueInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${venueInstance?.id}" />
                <g:hiddenField name="version" value="${venueInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="name"><g:message code="venue.name.label" default="Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: venueInstance, field: 'name', 'errors')}">
                                    <g:textField name="name" value="${venueInstance?.name}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="address1"><g:message code="venue.address1.label" default="Address1" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: venueInstance, field: 'address1', 'errors')}">
                                    <g:textField name="address1" value="${venueInstance?.address1}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="address2"><g:message code="venue.address2.label" default="Address2" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: venueInstance, field: 'address2', 'errors')}">
                                    <g:textField name="address2" value="${venueInstance?.address2}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="city"><g:message code="venue.city.label" default="City" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: venueInstance, field: 'city', 'errors')}">
                                    <g:textField name="city" value="${venueInstance?.city}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="state"><g:message code="venue.state.label" default="State" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: venueInstance, field: 'state', 'errors')}">
                                    <g:textField name="state" value="${venueInstance?.state}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="country"><g:message code="venue.country.label" default="Country" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: venueInstance, field: 'country', 'errors')}">
                                    <g:textField name="country" value="${venueInstance?.country}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="zip"><g:message code="venue.zip.label" default="Zip" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: venueInstance, field: 'zip', 'errors')}">
                                    <g:textField name="zip" value="${venueInstance?.zip}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="comments"><g:message code="venue.comments.label" default="Comments" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: venueInstance, field: 'comments', 'errors')}">
                                    <g:textArea name="comments" cols="40" rows="5" value="${venueInstance?.comments}" />
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
