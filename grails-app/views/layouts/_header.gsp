
<div class="header">
	<h1 class="logo">Event Finder</h1>
	<span class="skinDescription">Connecting experienced Agilists
		with anyone who wants to learns...</span>
</div>
<div class="nav">
	<span class="menuButton"><a href="${createLinkTo(dir:'')}">Home</a>
	</span>
	<g:each var="c" in="${grailsApplication.controllerClasses}">
		<span class="menuButton"><g:link
				controller="${c.logicalPropertyName}">
				${c.name}
			</g:link>
		</span>
	</g:each>
</div>