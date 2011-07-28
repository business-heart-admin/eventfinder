<html>
<head>
<title>Event Finder</title>
<meta name="layout" content="eventfinder" />
</head>
<body>
	<div class="columnBig">
		<n:hasRole name="TRAINER">
			<div id="myTrainerEvents" class="widget">
				<div class="titleSection">
					<h1 class="title">Events I am Teaching</h1>
						  <br/>
					<g:each var="event" in="${trainerEvents}">
					  <g:link controller = "event" action = "show" id = "${event.id}">${event}</g:link>
					  <br/>
					</g:each>
				</div>

			</div>
		</n:hasRole>

		<n:hasRole name="STUDENT">
			<div id="myStudentEvents" class="widget">
				<div class="titleSection">
					<h1 class="title">Events I am Attending</h1>
					<g:each var="event" in="${studentEvents}">
					  ${event.toString()}
					</g:each>
				</div>

			</div>
		</n:hasRole>
	</div>

	<div class="clear" />

</body>
</html>
