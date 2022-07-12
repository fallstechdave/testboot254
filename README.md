# testboot254

I have a Grails 2.5.4 web application deployed to a laptop running MS Windows 10.  It is deployed as a .war
file, and Apache Tomcat 9 is the container.  The same web application was previously deployed to a laptop
running MS Windows 7.

I am concerned that the behavior of the Grails 2.5.4 web application is different under MS Windows 10 than it was
under MS Windows 7.  Specifically, I am concerned that the init method in BootStrap.groovy is not being invoked
under the same conditions in Win 10 as it was under Win 7.

So I have created this Grails 2.5.4 web application with the intent of deploying it as a .war file to Tomcat 9
on a laptop running Win 10 and powering down and powering up the laptop to see if the log files reflect that
the BootStrap init method is being run.  I will perform the same experiment a second time, this time performing
a Win 10 "restart".  Unfortunately, I no longer have a Win 7 laptop to use to comapare the results.

The issue is that the web application was written with the expectation that the BootStrap init method would run
each time a user powered down their laptop and/or restarted their laptop.

This Grails 2.5.4 web application is the default web application generated with the "grails create-app testboot"
command, except that I have modified the BootStrap.groovy file as shown below.

    class BootStrap {

      def init = { servletContext ->
        log.error("testboot254 error BootStrap.init")  // default logging level (see Config.groovy)
        log.warn( "testboot254 warn BootStrap.init")
        log.info( "testboot254 info BootStrap.init")
        log.debug("testboot254 debug BootStrap.init")
        log.trace("testboot254 trace BootStrap.init")
        println("testboot254 BootStrap.init at ${new Date()}")
      }

      def destroy = {
        log.error("testboot254 error BootStrap.destroy")  // default logging level (see Config.groovy)
        log.warn( "testboot254 warn BootStrap.destroy")
        log.info( "testboot254 info BootStrap.destroy")
        log.debug("testboot254 debug BootStrap.destroy")
        log.trace("testboot254 trace BootStrap.destroy")
        println("testboot254 BootStrap.destroy at ${new Date()}")
      }

    }

    = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = 
    = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = 

    7:33 PM 7/12/2022

    C:\Users\DavidHolberton\grailsprojects\testboot254>
    C:\Users\DavidHolberton\grailsprojects\testboot254>git remote -v
    origin  git@github.com:fallstechdave/testboot254.git (fetch)
    origin  git@github.com:fallstechdave/testboot254.git (push)

    C:\Users\DavidHolberton\grailsprojects\testboot254>
    C:\Users\DavidHolberton\grailsprojects\testboot254>dir /o:gd
    Volume in drive C is OS
    Volume Serial Number is A02F-B04A

    Directory of C:\Users\DavidHolberton\grailsprojects\testboot254

    07/12/2022  05:59 PM    <DIR>          wrapper
    07/12/2022  06:00 PM    <DIR>          ..
    07/12/2022  06:16 PM    <DIR>          web-app
    07/12/2022  06:16 PM    <DIR>          test
    07/12/2022  06:16 PM    <DIR>          lib
    07/12/2022  06:16 PM    <DIR>          src
    07/12/2022  06:16 PM    <DIR>          scripts
    07/12/2022  06:16 PM    <DIR>          grails-app
    07/12/2022  06:16 PM    <DIR>          target
    07/12/2022  06:17 PM    <DIR>          .
    07/12/2022  05:59 PM             2,273 README.md
    07/12/2022  05:59 PM               119 application.properties
    07/12/2022  05:59 PM               503 .project
    07/12/2022  05:59 PM               232 .gitignore
    07/12/2022  05:59 PM             1,021 .classpath
    07/12/2022  05:59 PM            13,615 .asscache
    07/12/2022  05:59 PM             6,158 grailsw.bat
    07/12/2022  05:59 PM             9,967 grailsw
                  8 File(s)         33,888 bytes
                  10 Dir(s)  157,375,811,584 bytes free

    C:\Users\DavidHolberton\grailsprojects\testboot254>
    C:\Users\DavidHolberton\grailsprojects\testboot254>grails --version
    Grails version: 2.5.4

    C:\Users\DavidHolberton\grailsprojects\testboot254>type application.properties
    #Grails Metadata file
    #Sun Jul 10 08:28:46 EDT 2022
    app.grails.version=2.5.4
    app.name=testboot254
    app.version=0.1

    C:\Users\DavidHolberton\grailsprojects\testboot254>grails war target\testboot254.war

    | Done creating WAR target\testboot254.war

    C:\Users\DavidHolberton\grailsprojects\testboot254>
    C:\Users\DavidHolberton\grailsprojects\testboot254>dir /o:gd target
    Volume in drive C is OS
    Volume Serial Number is A02F-B04A

    Directory of C:\Users\DavidHolberton\grailsprojects\testboot254\target

    07/12/2022  06:16 PM    <DIR>          classes
    07/12/2022  06:16 PM    <DIR>          assets
    07/12/2022  06:17 PM    <DIR>          ..
    07/12/2022  06:19 PM    <DIR>          .
    07/12/2022  06:19 PM    <DIR>          work
    07/12/2022  06:16 PM                 0 stacktrace.log
    07/12/2022  06:19 PM        49,612,981 testboot254.war
                  2 File(s)     49,612,981 bytes
                  5 Dir(s)  157,323,694,080 bytes free

    C:\Users\DavidHolberton\grailsprojects\testboot254>
    C:\Users\DavidHolberton\grailsprojects\testboot254>copy target\testboot254.war \LocalApps\apache-tomcat-9.0.64\webapps
            1 file(s) copied.

    C:\Users\DavidHolberton\grailsprojects\testboot254>
    C:\Users\DavidHolberton\grailsprojects\testboot254>

    http://localhost:8080/
    http://localhost:8080/testboot254/

    = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = 
    = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = 

At 6:53 I used the "Services" window to stop and start the "Apache Tomcat 9.0 Tomcat9" process.  
Note that in the file below there are log entries for 6:53

At 6:58 I used "Shut down" to power down (and the power up) the laptop.  
Note that in the file below there are no log entries for 6:58

At 7:06 I used "Restart" to power down (and the power up) the laptop.  
Note that in the file below there are log entries for 7:06

At 7:15 I used closed the lid on my laptop, and unplugged the power cable.  
Ten minutes later I opened the lid.  
Note that in the file below there are no log entries for 7:15 or 7:25

    C:\LocalApps\apache-tomcat-9.0.64\logs\tomcat9-stdout.2022-07-12.log

    2022-07-12 16:19:08 Apache Commons Daemon procrun stdout initialized.
    2022-07-12 18:25:25,445 [Catalina-utility-2] ERROR conf.BootStrap  - testboot254 error BootStrap.init
    testboot254 BootStrap.init at Tue Jul 12 18:25:25 EDT 2022

    2022-07-12 18:33:16 Apache Commons Daemon procrun stdout initialized.
    2022-07-12 18:33:28,530 [main] ERROR conf.BootStrap  - testboot254 error BootStrap.init
    testboot254 BootStrap.init at Tue Jul 12 18:33:28 EDT 2022
    2022-07-12 18:40:59,472 [Thread-7] ERROR conf.BootStrap  - testboot254 error BootStrap.destroy
    testboot254 BootStrap.destroy at Tue Jul 12 18:40:59 EDT 2022

    2022-07-12 18:50:41 Apache Commons Daemon procrun stdout initialized.
    2022-07-12 18:51:01,762 [main] ERROR conf.BootStrap  - testboot254 error BootStrap.init
    testboot254 BootStrap.init at Tue Jul 12 18:51:01 EDT 2022
    2022-07-12 18:53:38,136 [Thread-7] ERROR conf.BootStrap  - testboot254 error BootStrap.destroy
    testboot254 BootStrap.destroy at Tue Jul 12 18:53:38 EDT 2022

    2022-07-12 18:53:48 Apache Commons Daemon procrun stdout initialized.
    2022-07-12 18:54:05,696 [main] ERROR conf.BootStrap  - testboot254 error BootStrap.init
    testboot254 BootStrap.init at Tue Jul 12 18:54:05 EDT 2022
    2022-07-12 19:06:22,345 [Thread-7] ERROR conf.BootStrap  - testboot254 error BootStrap.destroy
    testboot254 BootStrap.destroy at Tue Jul 12 19:06:22 EDT 2022

    2022-07-12 19:07:07 Apache Commons Daemon procrun stdout initialized.
    2022-07-12 19:07:22,827 [main] ERROR conf.BootStrap  - testboot254 error BootStrap.init
    testboot254 BootStrap.init at Tue Jul 12 19:07:22 EDT 2022

    = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = 
    = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = 

