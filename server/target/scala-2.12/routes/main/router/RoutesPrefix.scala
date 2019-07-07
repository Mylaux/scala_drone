// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/lucasmarty/Desktop/scia/spark/projet/temp/scala_drone/server/conf/routes
// @DATE:Sun Jul 07 19:50:30 CEST 2019


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
