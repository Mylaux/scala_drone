// @GENERATOR:play-routes-compiler
// @SOURCE:/home/lucas/scala/scala_drone/server/conf/routes
// @DATE:Sat May 11 17:24:18 CEST 2019


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
