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

