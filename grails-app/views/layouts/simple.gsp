<html>
<head>
    <title><g:layoutTitle default="Event Finder"/></title>
    <link rel="stylesheet" href="${createLinkTo(dir: 'css', file: 'eventfinder.css')}"/>
    <g:layoutHead/>
    <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
    <META HTTP-EQUIV="Expires" CONTENT="-1">
</head>

<body>
<div class="page"><a id="top"></a>
    <g:render template="/layouts/header"/>
    <div class="pageinner constrained">
        <div id="pageBody" class="body ">
            <g:layoutBody/>
            <div id="footerPlaceholder">&nbsp;</div>
        </div>
    </div>
</div>
<g:render template="/layouts/footer"/>

</body>
</html>