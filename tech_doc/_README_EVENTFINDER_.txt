=============================================================================
Deployment/Configuration Info for...                              EventFinder
=============================================================================
7-Jul-2011 CLJ

This text file is the official knowledge-base for all configuration management
details pertaining to the eventfinder project.

------------------------------------
Table of Contents
------------------------------------
1. Programmer's Notes - How to Maintain/Extend this Application
2. Programming Environment Notes
3. Integrator's Notes - How the Continuous Integration is Set Up
4. System Operator's Notes - how to deploy this application and keep it running
5. Technology Specifications

------------------------------------
Status of this File
------------------------------------
As of 3-Jun-2011, this application has not yet been deployed.  Any information
that implies that it has been deployed is actually just predicting how it will
work (based on how similar Grails applications have been deployed in the past).



=============================================================================
1. Programmer's Notes
=============================================================================

------------------------------------
Programming Maintenance
------------------------------------
- Advancing the app's version number requires changing it in 2 places (see below)
- The HTML is generated from GSP templates in grails-app/views/**/*.gsp
- Any pages that are added to  grails-app/views/info/*.gsp are automatically served by the InfoController.
  Pages added to any other folder require a corresponding action to be defined in a controller somewhere.
- The main CSS is webapps/css/eventfinder.css.
- [TODO not true yet] The text of the e-mails that go out are in grails-app/views/email/*.gsp (currently, they are HTML-only emails).
- [TODO not true yet] The Google Analytics code is in grails-app/views/layouts/_footer.gsp
- See also Updating the Terms of Service and Privacy Policy, below.

----------------------------------
Basic Page Layouts
----------------------------------
There are 3 basic sitemesh layouts to choose from:

  layouts/eventfinder.gsp   - Most pages in the application.  This layout consists of a header (#header), footer
                              (#footer), and sidebar (#sidebar, .columnSmall).  Some pages that use this layout opt to
                              include a second sidebar (#info, .columnMedium).

  layouts/landing.gsp       - The non-logged-in info-only pages like FAQs and the terms of service.  This layout consists
                              of just a header (#header), and a footer (#footer).

  layouts/system.gsp        - Only used for the two error-message pages (errors/error.gsp and pageNotFound.gsp).
                              ([TODO: Not yet] Note that errors/messages.gsp uses eventfinder.gsp.)

  layouts/_footer.gsp       - All three sitemesh layouts above share this footer template.

  layouts/_upcoming.gsp, etc. - The widgets that can appear in the sidebars (#sidebar or #info) are each defined in
                                their own file.  They are "included" using the <g:render> tag.


----------------------------------
CSS
----------------------------------
eventfinder.css     - the main (currently, only) CSS page -- based on the no-img-skin.css skin provided by Nimble.

------------------------------------
Grails-Standard CSS Style Definitions
------------------------------------
.info           - The panel at the top of a page that contains status messages and/or error messages.

.message        - The DIV at the top of a page that displays a status message to the user

div.errors      - The DIV at the top of the page that summarizes the validation errors.

span.errors     - The SPAN that surrounds whatever INPUT has an invalid value that needs to be addressed.

.odd, .even     - Every-other row in a listing (e.g a search result).

.paginateButtons - DIV that contains the pagination buttons (Previous, Next, etc.).

.buttons        - DIV that contains any action buttons (Save, Register, Delete, etc.).

.dialog         - DIV that contains the meat of most interactive pages. Usually appears after the DIV.message.


------------------------------------
Nimble-Standard CSS Style Definitions
------------------------------------

??? TODO

------------------------------------
EventFinder-Specific CSS Style Definitions
------------------------------------
.constrained    - Any DIV that is to be constrained to 960px (centered).  Usually, the first DIV nested in a BODY, and
                  all other content is nested within it. (e.g. about.gsp).

.columnSmall    - The DIV that contains the "navigation sidebar."  This sidebar appears on almost every page.  Notable
                  exceptions are: external-link landing pages, the various error pages.
                  .columnSmall contains .widget's.

.columnMedium   - The DIV that contains the "additional information sidebar."  Whether or not this column appears
                  depends on the page.  It may be omitted either because the main content requires extra room, or
                  if it would be distracting to the user.
                  .columnMedium contains .widget's.

.columnBig      - The DIV that contains the "meat" of the web page.
                  .columnBig contains .article's and/or .widget's.

.widget         - A DIV that is nested directly within one of the 3 columns.  Widgets can be moved around between
                  columns as desired.  Most .widget styling depends on which column its in.

.article        - A DIV that contains an informative "article" consisting of paragraphs (P), headers (H2), sub-headers
                  (H3), block quotes (BLOCKQUOTE), etc.  For example, a how-to article, an FAQ page, or an advertising
                  promotion.  Articles are usually directly nested in a .columnBig.  There may be multiple Articles on
                  a single page (within a single .columnBig).  H1 is reserved for the title of the whole page, so the
                  title of an individual article should be an H2 (with H3 and H4 subheadings).

.instructions   - Any P or DIV that contains instructions to the user, such as what to enter into a particular field.

------------------------------------
Updating the Terms of Service
and Privacy Policy
------------------------------------
The Terms of Service and Privacy Policy text is maintained as [TODO]




=============================================================================
2. Programming Environment Notes
=============================================================================

------------------------------------
MySQL
------------------------------------
The application connects via grails-app\datasources.groovy
	IP:   localhost
	User: eventfinder
	Pass: secret
	Database: eventfinder

------------------------------------
How to connect to the Test db via a SSH tunnel
(See: http://souptonuts.sourceforge.net/sshtips.htm)
------------------------------------
1. Install putty and start it, bringing up the Configuration window.
2. In the Session Category: Setup a connection to test.businessheart.org, port [TODO], and Save the session as "test.businessheart.org"
3. Click Load to load the saved session.
3. In the Connection>SSH>Tunnels Category: Add a new forwarding port to map localhost:3366 to the private IP of the test db: port 3306 as follows:
   * Source port: 3366 (this is a made up local port number. We choose a number kinda similar to 3306, the port MySql is on)
   * Destination: localhost:3306 (localhost is actually the private IP of the test db FROM THE SSH SERVER'S PERSPECTIVE)
   * Click Add
5. Back in the Session Category: Click Save to save the tunnel in the "test.businessheart.org" session.
6. Click Open to start the test.businessheart.org session with the configured tunnel for MySql. Username sa, password <ask craig>

In SQLYog:
----------
Configure a new connection for test.businessheart.org:
    * host: localhost
    * username: EventFinder
    * password: secret
    * port: 3366

Save and test the connection. localhost:3366 will get picked up and put through the SSH tunnel to localhost:3306 on the db server.

------------------------------------
Eclipse-Specific Environment Setup
------------------------------------
Make sure all of the following folders are included in the Build Path:

grails-app\domain
grails-app\controller
grails-app\service
grails-app\conf
grails-app\taglib

test\unit
test\integration




=============================================================================
3. Integrator's Notes
=============================================================================

------------------------------------
Advancing the app's version number
------------------------------------
1. Tag GIT for the last build of the last iteration. (In case we need to start
   a maintenance branch based on the tag.)

2. Change the build configuration in Jenkins:

   a. http://dev.businessheart.org/jenkins/job/Event%20Finder/configure
   b. Scroll down to the Build section.
   c. One of the targets in the Targets field is set-version, e.g.:

     "set-version 0.1.18.${env['BUILD_NUMBER']}"

   Change the argument there to reflect the new iteration.

3. Edit application.properties to reflect the new iteration and commit (this is
   just a default for using with localhost), e.g.:

   app.version=0.1.19


------------------------------------
Event Finder Build Process
------------------------------------

      1. Browse http://jenkins.clj-consulting.com/job/EventFinder/ and make sure the latest Jenkins build is good
            jenkins.clj-consulting.com is 206.125.168.82
      2. ssh jenkins.clj-consulting.com -p 27382 -l sa
      3. cd ~/war_files
      4. ./ef_fetch_latest.sh (you'll be asked for the sa password)

      If there are no schema changes, and if you don't care about clearing the Tomcat logs, then just do this:

      5. ./ef_fast_deploy_latest.sh
      6. Skip to 11, below

      OTHERWISE, do this

      5. (Back in the browser) Manage Jenkins | Prepare for ShutDown
      6. (Back in the ssh window) tstop (tstop is an alias for "/etc/init.d/tomcat stop")
      7. tps (tps is an alias for "ps aux | grep catalina") -- repeat until clear
      8. ./ef_deploy_latest.sh
      9. TODO IMPORTANT: Make sure the DB is backed up and aligned with the latest release
            - Any password changes?
            - All patches executed
     10. tstart (tstart is an alias for "/etc/init.d/tomcat start")

     11. TODO Don't forget to add the new app.version in Trac.
	 12. TODO Run the selenium smoke test (see below)
	 13. TODO Run the manual smoke test
	 14. Send out an email pointing to the release notes on Jenkins

To push a build from DEV to production,

      1. ssh jenkins.clj-consulting.com -p 27382 -l sa
      2. ./ef_push_latest.sh
      3. (In another window) ssh alpha61.clj-consulting.com -p 27361 -l sa
            alpha61.clj-consulting.com is 206.125.168.61
      4. cd ~/war_files
      5. tstop
      6. tps
      7. ./ef_deploy_latest.sh
      8. TODO IMPORTANT: Make sure the DB is backed up and aligned with the latest release
            - Any password changes?
            - All patches executed
      9. tstart
	 10. TODO Run the selenium smoke test (see below)
	 11. TODO Run the manual smoke test
	 12. Send out an email pointing to the release notes on Jenkins



------------------------------------
Jenkins Configuration
------------------------------------
*/30 * * * *
git@github.com:business-heart-admin/eventfinder.git
Grails Latest
"clean --non-interactive" "set-version 0.0.1.${env['BUILD_NUMBER']}" "test-app -coverage -xml --non-interactive" "war --non-interactive"
**/test/reports/cobertura/coverage.xml
Consider only stable builds [x]

---------------------------------------
Smoke Tests
---------------------------------------
[TODO: Not true yet] The Selenium automated smoke tests are in test/selenium.  The main smoke test suite is

    (wildcard the whole org.businessheart package)

Instructions for running the Selenium automated smoke tests can be found in

    tech_doc/environment_setup/selenium_testing_setup.txt

The list of what needs to be tested every time we deploy a new build is in
tech_doc/quality_assurance/advanced_testing.txt.  Whatever isn't covered by
the Selenium automated smoke tests needs to be tested manually.




=============================================================================
4. System Operator's Notes
=============================================================================

------------------------------------
Weekly Upkeep
------------------------------------
 1. See Bandwidth Monitoring, below
    - Make sure we're not going to exceed our monthly allotment of __________ [TODO]
 2. See AWStats, below
    - Look for _________________ [TODO]
    - ??? what else
 3. support@businessheart.org emails are currently being forwarded to __________ [TODO]
    - Standard responses are in ____________
    - Update the FAQ
    - ??? what else
 4. Daily, Weekly, and Monthly MySQL backups are currently going to __________ [TODO]
 5. Daily off-disk backups are currently going to __________ [TODO]

------------------------------------
Server Crashes
------------------------------------
The main Tomcat log is [Tomcat Home]/logs/catalina.out and the access log is
/var/log/apache2/access.log
(Note: There is usually a symlink from /var/log/tomcat6 to [Tomcat Home]/logs)

------------------------------------
Bouncing the Server
------------------------------------
1. To bounce just Tomcat:

	sudo /etc/init.d/tomcat restart

2. To gracefully bounce Apache, too:

	sudo /etc/init.d/apache2 reload

3. To hard-bounce Apache (rarely necessary):

	sudo /etc/init.d/apache2 restart

4. If the entire host server crashes, then the Remote Reboot is:

    [TODO]


------------------------------------
Memory Settings
------------------------------------
If catalina.out indicates out-of-memory, first determine if it's talking about
PermGen memory or heap space memory.  Then, check that enough of that kind of
memory has been allocated in /etc/init.d/tomcat, in the line that declares
CATALINA_OPTS, e.g.:

  export CATALINA_OPTS="-Xms256m -Xmx512m -XX:PermSize=128m -XX:MaxPermSize=256m"

If so, then the problem must be a memory leak. Add "-verbose:gc" to the
CATALINA_OPTS, and then use "tail -F" to follow the catalina.out log and watch
the memory levels as reported every time Java does a garbage collection.

[See also "Bouncing the Server", below.]

------------------------------------
Automatic Backups
------------------------------------
The automatic backup script is /src/sh/automysqlbackup_EventFinder.sh

It's deployed to /etc/cron.daily/ as automysqlbackup_EventFinder (no extension)

IMPORTANT: On Ubuntu (and other Linux distros) any script with a period in the
name that is placed in the /etc/cron.xx folders are silently ignored.  See
https://help.ubuntu.com/community/CronHowto and
https://bugs.launchpad.net/ubuntu/+source/debianutils/+bug/38022

The backups are saved in /backups/daily, weekly, and monthly.
A copy (symbolic link?) of the latest backups are also saved in /backups/latest.

The DB User is "automysqlbackup".  See /src/sql/resources/grant_system_user.sql

TODO: Write WinSCP scripting to pull down /backups/latest/*




=============================================================================
5. Technology Specifications
=============================================================================

------------------------------------
The Stack
------------------------------------
Grails 1.3.7
Tomcat 6
MySQL 5
Apache 2

------------------------------------
Grails plugins (alphabetical)
------------------------------------
Avatar          - A simple wrapper around the Gravatar API
                - Docs: http://grails.org/plugin/avatar

Hibernate       - (required by Grails)

Mail            - Wrapper around the java libraries for sending out e-mails
                - Docs: http://grails.org/plugin/mail

Nimble          - (Not Yet) Manages User profiles, roles, permissions, etc.
                - Authenticate via Local Account, OpenID, LDAP, Facebook
                - (Depends on Mail, Shiro)
                - Docs: http://sites.google.com/site/nimbledoc/

Scaffold-Tags   - Dynamically builds web pages based according to field type
                - Docs: http://grails.org/plugin/scaffold-tags
                        http://grails.snowmochi.com/grails/scaffoldtags

Searchable      - (Not Yet) Wrapper around the Apache Lucene libraries for full-text searching
                - Docs: http://grails.org/plugin/searchable

Shiro           - (Not Yet) Wrapper around the Apache Shiro security framework
                - Docs: http://grails.org/plugin/shiro

Tomcat          - (required by Grails)



------------------------------------
LINUX SERVERS
------------------------------------
qa1.businessheart.org runs in a VM hosted on [TODO], which is a dedicated Linux server provided by a
company called [TODO]:

IP Address       (Sub)Domain                        Domain Registrar / DNS Authority / Hosting
---------------  ---------------------------------  ----------------------------------
[TODO]



------------------------------------
Bandwidth Monitoring
------------------------------------
Usage graphs are located at:

    http://[TODO]
    username: [TODO]
    password: [TODO]

1. Click the one graph that comes up.  The view will change to show you four
   graphs: Daily, Weekly, Monthly, Yearly.
2. Look at the 3rd graph (Monthy), where the last line of the legend says
   "95th Percentile (___ mbit in+out)".  Make sure it's under our limit of
   [TODO] mbps (sustained).

We're allowed to burst up to [TODO] mbps, but the sustained rate has to be stay
under [TODO], unless we buy more bandwidth in advance, of course.

------------------------------------
AWStats
------------------------------------
To view the AWStats,

1. browse to

    http://businessheart.org/awstats/awstats.pl

   (NOTE: Do NOT include a leading "www." subdomain or awstats.pl won't be able
   to find the config file)

2. It will ask for a username & password. The only user that can view them is
   "sa" (usual password).

3. The stats are updated every hour, around :55 past the hour.  (The last 5
   minutes of each week may be skipped as the log rolls over.)

Note: awstats is installed on [TODO]

Here's how it's configured [TODO]




------------------------------------
Web Server Setup - Apache/Tomcat Proxying
------------------------------------
The Event Finder site runs on Tomcat & Apache.  Some key configuration
settings are:

[Tomcat Home]/config/server.xml -- config file for the Tomcat side of the
                                  Apache/Tomcat proxy

/etc/apache2/http.conf         -- overrides to the standard settings in
                                  apache2.conf

    1. Make sure that KeepAlive is OFF

/etc/apache2/sites-enabled/eventfinder -- config file for the Apache
                                  side of the Apache/Tomcat proxy

/var/www/eventfinder/images/*    -- the one set of files served directly by
                                  Apache (Note that /var/www/EventFinder/images
                                  is currently just a symbolic link to the
                                  images folder in the tomcat webapp.
                                  See src/sh/serve_directly.sh for further
                                  details.)



---------------------------------------
E-MAIL
---------------------------------------

The BusinessHeart/Event Finder mail server is http://mail.businessheart.org [TODO true?]

To fetch mail with a webmail interface:
    http://mail.businessheart.org

To fetch mail with POP:
	mail.businessheart.org
	port 110

To send mail with SMTP (optional):
	mail.businessheart.org
	port 25

When you bring up webmail for the first time, you need to accept the self-signed certificate.

To install the mail.businessheart.org certificate in your local dev
environment, see tech_doc/environment_setup/installing_email_certificates.txt
