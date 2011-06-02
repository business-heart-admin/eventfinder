

<%@ page import="org.businessheart.Trainer" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'trainer.label', default: 'Trainer')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${trainerInstance}">
            <div class="errors">
                <g:renderErrors bean="${trainerInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="name"><g:message code="trainer.name.label" default="Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: trainerInstance, field: 'name', 'errors')}">
                                    <g:textField name="name" value="${trainerInstance?.name}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="email"><g:message code="trainer.email.label" default="Email" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: trainerInstance, field: 'email', 'errors')}">
                                    <g:textField name="email" value="${trainerInstance?.email}" />
                                </td>
                            </tr><%--
                                                         
                            
                        
                            --%><tr class="prop">
                                <td valign="top" class="name">
                                    <label for="displayGravatar"><g:message code="trainer.displayGravatar.label" default="Display Gravatar" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: trainerInstance, field: 'displayGravatar', 'errors')}">
                                    <g:checkBox name="displayGravatar" value="${trainerInstance?.displayGravatar}" />
                                </td>
                            </tr>
                            
                            
                            <tr class="prop">
                         
                            <td valign="top" class="name">Don't have a Gravatar? </td>
                            <td valign="top" class="value" >Click Here: <a href="http://gravatar.com"><p style="color:blue;">gravatar.com</p></a>
                            
                            </td>
                        </tr>
                        
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="phone"><g:message code="trainer.phone.label" default="Phone" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: trainerInstance, field: 'phone', 'errors')}">
                                    <g:textField name="phone" value="${trainerInstance?.phone}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="address1"><g:message code="trainer.address1.label" default="Address1" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: trainerInstance, field: 'address1', 'errors')}">
                                    <g:textField name="address1" value="${trainerInstance?.address1}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="address2"><g:message code="trainer.address2.label" default="Address2" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: trainerInstance, field: 'address2', 'errors')}">
                                    <g:textField name="address2" value="${trainerInstance?.address2}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="city"><g:message code="trainer.city.label" default="City" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: trainerInstance, field: 'city', 'errors')}">
                                    <g:textField name="city" value="${trainerInstance?.city}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="state"><g:message code="trainer.state.label" default="State" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: trainerInstance, field: 'state', 'errors')}">
                                    <g:textField name="state" value="${trainerInstance?.state}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="country"><g:message code="trainer.country.label" default="Country" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: trainerInstance, field: 'country', 'errors')}">
                                    <g:textField name="country" value="${trainerInstance?.country}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="zip"><g:message code="trainer.zip.label" default="Zip" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: trainerInstance, field: 'zip', 'errors')}">
                                    <g:textField name="zip" value="${trainerInstance?.zip}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="organization"><g:message code="trainer.organization.label" default="Organization" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: trainerInstance, field: 'organization', 'errors')}">
                                    <g:textField name="organization" value="${trainerInstance?.organization}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="certifications"><g:message code="trainer.certifications.label" default="Certifications" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: trainerInstance, field: 'certifications', 'errors')}">
                                    <g:textField name="certifications" value="${trainerInstance?.certifications}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="active"><g:message code="trainer.active.label" default="Active" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: trainerInstance, field: 'active', 'errors')}">
                                    <g:checkBox name="active" value="${trainerInstance?.active}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="categories"><g:message code="trainer.categories.label" default="Categories" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: trainerInstance, field: 'categories', 'errors')}">
                                    <g:textField name="categories" value="${trainerInstance?.categories}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="comments"><g:message code="trainer.comments.label" default="Comments" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: trainerInstance, field: 'comments', 'errors')}">
                                    <g:textArea name="comments" cols="40" rows="5" value="${trainerInstance?.comments}" />
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
