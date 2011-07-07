<html>
	<head>
		<title><g:layoutTitle default="Grails No-Images Skin" /></title>
		<link rel="stylesheet" href="${createLinkTo(dir:'css',file:'eventfinder.css')}"></link>
		<g:layoutHead />
        <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
        <META HTTP-EQUIV="Expires" CONTENT="-1">
	</head>
	<body>
        <div class="page">
            <div class="pageinner constrained">
                <g:render template="/layouts/header"/>
        		<g:layoutBody />
                <g:render template="/layouts/footer"/>
            </div>

        </div> 
      	</body>
</html>