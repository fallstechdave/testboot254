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