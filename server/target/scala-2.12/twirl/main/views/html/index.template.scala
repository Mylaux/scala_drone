
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[scala.collection.mutable.MutableList[controllers.Drone],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(drones : scala.collection.mutable.MutableList[controllers.Drone]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/main("Welcome")/*3.17*/ {_display_(Seq[Any](format.raw/*3.19*/("""
"""),_display_(/*4.2*/defining(play.core.PlayVersion.current)/*4.41*/ { version =>_display_(Seq[Any](format.raw/*4.54*/("""

"""),format.raw/*6.1*/("""<section id="content">
  <div class="wrapper doc">
    <article>
      <table>
        <tbody>
        <tr>
          <td> ID </td>
          <td> longitude </td>
          <td> latitude </td>
          <td> temperature </td>
          <td> battery </td>
          <td> weight </td>
        </tr>
        """),_display_(/*19.10*/for(d <- drones) yield /*19.26*/{_display_(Seq[Any](format.raw/*19.27*/("""
        """),format.raw/*20.9*/("""<tr>
          <td> """),_display_(/*21.17*/d/*21.18*/.id),format.raw/*21.21*/(""" """),format.raw/*21.22*/("""</td>
          <td> """),_display_(/*22.17*/d/*22.18*/.longitude),format.raw/*22.28*/(""" """),format.raw/*22.29*/("""</td>
          <td> """),_display_(/*23.17*/d/*23.18*/.latitude),format.raw/*23.27*/(""" """),format.raw/*23.28*/("""</td>
          <td> """),_display_(/*24.17*/d/*24.18*/.temperature),format.raw/*24.30*/(""" """),format.raw/*24.31*/("""</td>
          <td> """),_display_(/*25.17*/d/*25.18*/.battery),format.raw/*25.26*/(""" """),format.raw/*25.27*/("""</td>
          <td> """),_display_(/*26.17*/d/*26.18*/.weight),format.raw/*26.25*/(""" """),format.raw/*26.26*/("""</td>
        </tr>
        """)))}),format.raw/*28.10*/("""
        """),format.raw/*29.9*/("""</tbody>
      </table>

    </article>
  </div>
</section>
""")))}),format.raw/*35.2*/("""
""")))}))
      }
    }
  }

  def render(drones:scala.collection.mutable.MutableList[controllers.Drone]): play.twirl.api.HtmlFormat.Appendable = apply(drones)

  def f:((scala.collection.mutable.MutableList[controllers.Drone]) => play.twirl.api.HtmlFormat.Appendable) = (drones) => apply(drones)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri May 10 11:47:11 CEST 2019
                  SOURCE: /home/lucas/scala/taxi_drone/server/play-samples-play-scala-hello-world-tutorial/app/views/index.scala.html
                  HASH: 2c76d6d67d572a36691082d47c71d3acc31f7fd6
                  MATRIX: 778->1|938->68|965->70|988->85|1027->87|1054->89|1101->128|1151->141|1179->143|1512->449|1544->465|1583->466|1619->475|1667->496|1677->497|1701->500|1730->501|1779->523|1789->524|1820->534|1849->535|1898->557|1908->558|1938->567|1967->568|2016->590|2026->591|2059->603|2088->604|2137->626|2147->627|2176->635|2205->636|2254->658|2264->659|2292->666|2321->667|2381->696|2417->705|2508->766
                  LINES: 21->1|26->2|27->3|27->3|27->3|28->4|28->4|28->4|30->6|43->19|43->19|43->19|44->20|45->21|45->21|45->21|45->21|46->22|46->22|46->22|46->22|47->23|47->23|47->23|47->23|48->24|48->24|48->24|48->24|49->25|49->25|49->25|49->25|50->26|50->26|50->26|50->26|52->28|53->29|59->35
                  -- GENERATED --
              */
          