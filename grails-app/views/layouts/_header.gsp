<div id="navLogin" class="nav">
    <div class="constrained">
        <ul>
            <n:isLoggedIn>
                <li>You are signed in as <b><n:principalName/></b></li>
                <li class="click"><g:link controller="logout">sign out</g:link></li>
            </n:isLoggedIn>
            <n:isNotLoggedIn>
                <li>not a member? <g:link controller="register" class="register">register now.</g:link></li>
                <li class="click"><g:link controller="auth">sign in</g:link></li>
            </n:isNotLoggedIn>
        </ul>
    </div>
</div>

<div class="header">
    <div class="constrained">
        <h1 class="logo">Event Finder</h1>
        <span class="skinDescription">Connecting experienced Agilists
        with anyone who wants to learns...</span>
    </div>
</div>

<div id="navApp" class="nav">
    <div class="constrained">
        <ul>
            <li class="menuButton"><a href="${createLinkTo(dir: '')}">Home</a>
            </li> <li class="menuButton"><g:link controller="trainer">Trainers</g:link>
        </li> <li class="menuButton"><g:link controller="event">Events</g:link>
        </li>
            <li class="menuButton"><g:link controller="info" action="about">About Us</g:link>
            </li>
        </ul>
    </div>
</div>