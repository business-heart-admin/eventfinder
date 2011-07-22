<html>

<head>
  <meta name="layout" content="${grailsApplication.config.nimble.layout.application}"/>
  <title><g:message code="nimble.view.account.registeraccount.initiate.title" /></title>
  <nh:pstrength />
</head>

<body>
<div class="columnBig">
    <h2><g:message code="nimble.view.account.registeraccount.initiate.heading" /></h2>
    <p>
      <g:message code="nimble.view.account.registeraccount.initiate.descriptive" />
    </p>

    <n:errors bean="${user}"/>
    <n:errors bean="${user.profile}"/>

    <n:errors bean="${user.profile}"/>

    <g:form action="saveuser">
      <table>
        <tbody>

        <tr>
          <td valign="top" class="name"><label for="username"><g:message code="nimble.label.username" /></label></td>
          <td valign="top" class="value ${hasErrors(bean: user, field: 'username', 'errors')}">
			<n:verifyfield id="username" class="easyinput" name="username" value="${fieldValue(bean: user, field: 'username')}" required="true" controller="account" action="validusername" validmsg="valid" invalidmsg="invalid" />
			<a href="#" id="usernamepolicybtn" rel="usernamepolicy" class="empty icon icon_help"></a>
          </td>
        </tr>

        <tr>
          <td valign="top" class="name"><label for="pass"><label for="username"><g:message code="nimble.label.password" /></label></td>
          <td valign="top" class="value ${hasErrors(bean: user, field: 'pass', 'errors')}">
            <input type="password" size="30" id="pass" name="pass" value="${user.pass?.encodeAsHTML()}" class="password easyinput"/> <span class="icon icon_bullet_green">&nbsp;</span><a href="#" id="passwordpolicybtn" rel="passwordpolicy" class="empty icon icon_help"></a>
          </td>
        </tr>

        <tr>
          <td valign="top" class="name"><label for="passConfirm"><g:message code="nimble.label.password.confirmation" /></label></td>
          <td valign="top" class="value ${hasErrors(bean: user, field: 'passConfirm', 'errors')}">
            <input type="password" size="30" id="passConfirm" name="passConfirm" value="${user.passConfirm?.encodeAsHTML()}" class="easyinput"/> <span class="icon icon_bullet_green">&nbsp;</span>
          </td>
        </tr>
        
        <tr>
          <td valign="top" class="name"><label for="firstName"><g:message code="nimble.label.firstname" /></label></td>
          <td valign="top" class="value ${hasErrors(bean: user, field: 'profile.firstName', 'errors')}">
            <input type="text" size="30" id="firstName" name="firstName" value="${user.profile?.firstName?.encodeAsHTML()}" class="easyinput"/>
          </td>
        </tr>
        
        
         <tr>
          <td valign="top" class="name"><label for="lastName"><g:message code="nimble.label.lastname" /></label></td>
          <td valign="top" class="value ${hasErrors(bean: user, field: 'profile.lastName', 'errors')}">
           <g:renderProperty template="editor" domain="${user.profile.class}" name="lastName" prop="lastName" value="${user.profile.lastName}" />
          </td>
        </tr>
        <tr>
        
  


          <td valign="top" class="name"><label for="email"><g:message code="nimble.label.email" /></label></td>
          <td valign="top" class="value ${hasErrors(bean: user, field: 'profile.email', 'errors')}">
            <input type="text" size="30" id="email" name="email" value="${user.profile?.email?.encodeAsHTML()}" class="easyinput"/> <span class="icon icon_bullet_green">&nbsp;</span>
          </td>
        </tr>
        
         <tr>
          <td valign="top" class="name"><label for="phone"><g:message code="nimble.label.phone" /></label></td>
          <td valign="top" class="value ${hasErrors(bean: user, field: 'profile.phone', 'errors')}">
            <input type="text" size="30" id="phone" name="phone" value="${user.profile?.phone?.encodeAsHTML()}" class="easyinput"/>
          </td>
        </tr>
        

        <tr>
          <td valign="top" class="name"><label for="displayGravatar"><g:message code="nimble.label.displaygravatar" /></label></td>
          <td valign="top" class="value ${hasErrors(bean: user, field: 'profile.displayGravatar', 'errors')}">
           <g:renderProperty template="editor" domain="${user.profile.class}" prop="displayGravatar" value="${user.profile.displayGravatar}" />
          </td>
        </tr>

        <tr>
          <td valign="top" class="name"><label for="address2"><g:message code="nimble.label.address2" /></label></td>
          <td valign="top" class="value ${hasErrors(bean: user, field: 'profile.address2', 'errors')}">
            <input type="text" size="30" id="address2" name="address2" value="${user.profile?.address2?.encodeAsHTML()}" class="easyinput"/> <span class="icon icon_bullet_green">&nbsp;</span>
          </td>
        </tr>
        
              <tr>
          <td valign="top" class="name"><label for="state"><g:message code="nimble.label.state" /></label></td>
          <td valign="top" class="value ${hasErrors(bean: user, field: 'profile.state', 'errors')}">
            <input type="text" size="30" id="state" name="state" value="${user.profile?.state?.encodeAsHTML()}" class="easyinput"/> <span class="icon icon_bullet_green">&nbsp;</span>
          </td>
        </tr>
        
              <tr>
          <td valign="top" class="name"><label for="country"><g:message code="nimble.label.country" /></label></td>
          <td valign="top" class="value ${hasErrors(bean: user, field: 'profile.country', 'errors')}">
            <input type="text" size="30" id="country" name="country" value="${user.profile?.country?.encodeAsHTML()}" class="easyinput"/> <span class="icon icon_bullet_green">&nbsp;</span>
          </td>
        </tr>
        
              <tr>
          <td valign="top" class="name"><label for="zip"><g:message code="nimble.label.zip" /></label></td>
          <td valign="top" class="value ${hasErrors(bean: user, field: 'profile.zip', 'errors')}">
            <input type="text" size="30" id="zip" name="zip" value="${user.profile?.zip?.encodeAsHTML()}" class="easyinput"/> <span class="icon icon_bullet_green">&nbsp;</span>
          </td>
        </tr>
        
        

        <n:recaptcharequired>
          <tr>
            <th><g:message code="nimble.label.captcha" /></th>
            <td>
              <n:recaptcha/>
            </td>
          </tr>
        </n:recaptcharequired>

        <tr>
          <td/>
          <td>
            <button class="button icon icon_user" type="submit"><g:message code="nimble.link.registeraccount" /></button>
          </td>  
        </tr>

        </tbody>
      </table>
    </g:form>


</div>
<script type="text/javascript">
nimble.createTip('usernamepolicybtn','<g:message code="nimble.template.usernamepolicy.title" />','<g:message code="nimble.template.usernamepolicy" encodeAs="JavaScript"/>');
nimble.createTip('passwordpolicybtn','<g:message code="nimble.template.passwordpolicy.title" />','<g:message code="nimble.template.passwordpolicy" encodeAs="JavaScript"/>');
</script>
</body>

</html>