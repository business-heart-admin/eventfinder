<% /*
<img src="${createLinkTo(dir:'images/tree/check',file:value?'check2.gif':'check0.gif')}"/>
*/ %>&nbsp;<br/><avatar:gravatar email="${trainerInstance.email}" size="60"/><input type="checkbox" disabled="disabled" ${value?"checked=checked":""} /> ${trainerInstance?.displayGravatar?'Yes':'No'}<br/>
Don't have a Gravatar? Click Here: <A href="http://gravatar.com">gravatar.com</A><br/>&nbsp;