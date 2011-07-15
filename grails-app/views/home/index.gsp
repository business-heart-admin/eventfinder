<html>
<head>
<title>Event Finder</title>
<meta name="layout" content="eventfinder" />
</head>
<body>
		<div class="columnMedium">
            <div id="testimonials" class="widget">
                <div class="titleSection">
                    <h1 class="title">Testimonials</h1>
                </div>
                <blockquote>This is the greatest training seminar I
                    have ever attended...</blockquote>
                <br />
            </div>
			<div id="controllerList" class="widget">
				<h1>Available Controllers:</h1>
				<ul>
					<g:each var="c"
						in="${grailsApplication.controllerClasses.sort { it.fullName } }">
						<li class="controller"><g:link
								controller="${c.logicalPropertyName}">
								${c.fullName}
							</g:link>
						</li>
					</g:each>
				</ul>
			</div>
		</div>
		<div class="columnBig">
			<div id="aboutUs" class="widget">
				<div class="titleSection">
					<h1 class="title">About Us</h1>
				</div>
				<p>Business Heart is an emergent, untethered and entirely
					unowned entity. Its mission is to socialize the new business
					paradigm as expressed in many disciplines currently being applied
					in a growing number of work enviroments, incuding Chaos Theory,
					Complex Adaptive Systems, Emotional Intelligence, Integral and
					Co-active Coaching, Stewardship, Agile, Scrum, Kanban, Artful
					Making and Business Craftsmanship. Practitioners in all these
					fields share a passion to create a more humane, organic and
					trustful workplace.</p>
			</div>
		</div>

		<div class="clear"/>

</body>
</html>
