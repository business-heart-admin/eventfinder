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
            listItem('John Q. Trainer')
            listItem('Jane R. Instructor')
            listItem('Jack S. Coach')
            out << '</ul>'
        }
        if (isEventsWidget) {
            out << '<ul>'
            listItem('CI for a Dollar a Day')
            listItem('TDD There and Back Again')
            listItem('The Kanban Can-Can')
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
