
<div class="header">
	<h1 class="logo">Event Finder</h1>
	<span class="skinDescription">Connecting experienced Agilists
		with anyone who wants to learns...</span>
</div>
<div class="nav">
	<div class="navLeft">
		<span class="menuButton"><a href="${createLinkTo(dir:'')}">Home</a>
		</span> <span class="menuButton"><g:link controller="trainer">Trainers </g:link>
		</span> <span class="menuButton"><g:link controller="event">Events </g:link>
		</span>
		<span class="menuButton"><g:link controller="info" action="about">About Us </g:link>
		</span>
		
	</div>
	<div class="navRight">
		<n:isNotLoggedIn>
			<span class="menuButton"><g:link controller="auth"
					action="login">Login </g:link> </span>
		</n:isNotLoggedIn>
		<n:isLoggedIn>
			<span class="menuButton"><g:link controller="auth"
					action="logout">Logout </g:link> </span>
		</n:isLoggedIn>
	</div>
	<div class="clear"></div>
</div>