
<%@ page import="org.businessheart.Trainer" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'trainer.label', default: 'Trainer')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="trainer.id.label" default="Id" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: trainerInstance, field: "id")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="trainer.name.label" default="Name" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: trainerInstance, field: "name")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="trainer.email.label" default="Email" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: trainerInstance, field: "email")}</td>
                            
                        </tr>
                        
                        <tr class="prop">
                            <td valign="top" class="name">Your current Gravatar: </td>
                            
                            <td valign="top" class="value"><avatar:gravatar email="${trainerInstance.email}" size="60"/></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="trainer.displayGravatar.label" default="Display Gravatar" /></td>
                            
                            <td valign="top" class="value">${trainerInstance?.displayGravatar?'Yes':'No'}</td>
                            
                        </tr>
                        
                         <tr class="prop">

                            <td valign="top" class="name">Don't have a Gravatar? </td>
                            
                            <td valign="top" class="value">Click Here: <A href="http://gravatar.com">gravatar.com</A></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="trainer.phone.label" default="Phone" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: trainerInstance, field: "phone")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="trainer.address1.label" default="Address1" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: trainerInstance, field: "address1")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="trainer.address2.label" default="Address2" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: trainerInstance, field: "address2")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="trainer.city.label" default="City" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: trainerInstance, field: "city")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="trainer.state.label" default="State" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: trainerInstance, field: "state")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="trainer.country.label" default="Country" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: trainerInstance, field: "country")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="trainer.zip.label" default="Zip" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: trainerInstance, field: "zip")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="trainer.organization.label" default="Organization" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: trainerInstance, field: "organization")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="trainer.certifications.label" default="Certifications" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: trainerInstance, field: "certifications")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="trainer.active.label" default="Active" /></td>
                            
                            <td valign="top" class="value"><g:formatBoolean boolean="${trainerInstance?.active}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="trainer.categories.label" default="Categories" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: trainerInstance, field: "categories")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="trainer.comments.label" default="Comments" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: trainerInstance, field: "comments")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="trainer.dateCreated.label" default="Date Created" /></td>
                            
                            <td valign="top" class="value"><g:formatDate date="${trainerInstance?.dateCreated}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="trainer.lastUpdated.label" default="Last Updated" /></td>
                            
                            <td valign="top" class="value"><g:formatDate date="${trainerInstance?.lastUpdated}" /></td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${trainerInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
