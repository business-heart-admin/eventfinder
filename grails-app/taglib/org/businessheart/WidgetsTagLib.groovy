package org.businessheart

class WidgetsTagLib {
    static namespace = 'ef'

    def widget = {attrs, body ->
        boolean isTrainerWidget = (attrs.id == 'newTrainers')
        boolean isEventsWidget = (attrs.id == 'upcomingEvents')

        out << "<div id='${attrs.id}' class='widget'>"
        out << "<div class='titleSection'><h1 class='title'>${attrs.title}</h1></div>"
        if (isTrainerWidget) {
            out << '<ul>'
			def newTrainers
			newTrainers = Trainer.listOrderByDateCreated(max:3 , order:"desc") 
			newTrainers.each{it ->listItem(it.owner.profile.firstName + " " + it.owner.profile.lastName)}
            out << '</ul>'
        }
        if (isEventsWidget) {
            out << '<ul>'
			def newEvents
			newEvents = Event.findAllByStartTimeGreaterThanEquals(new Date())
			newEvents.each{it ->listItem(it.name)}
            out << '</ul>'
        }
        out << '</div>'

    }

    void listItem(String item) {
        out << '<li>'
        out << item
        out << '</li>'
    }


}
