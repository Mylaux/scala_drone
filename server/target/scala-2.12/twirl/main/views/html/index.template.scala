
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
          <td> is_working </td>
          <td> longitude </td>
          <td> latitude </td>
          <td> temperature </td>
          <td> battery </td>
          <td> weight </td>
          <td> is_occupied </td>
        </tr>
        """),_display_(/*21.10*/for(d <- drones) yield /*21.26*/{_display_(Seq[Any](format.raw/*21.27*/("""
        """),format.raw/*22.9*/("""<tr>
          <td> """),_display_(/*23.17*/d/*23.18*/.id),format.raw/*23.21*/(""" """),format.raw/*23.22*/("""</td>
          <td> """),_display_(/*24.17*/d/*24.18*/.is_working),format.raw/*24.29*/(""" """),format.raw/*24.30*/("""</td>
          <td> """),_display_(/*25.17*/d/*25.18*/.longitude),format.raw/*25.28*/(""" """),format.raw/*25.29*/("""</td>
          <td> """),_display_(/*26.17*/d/*26.18*/.latitude),format.raw/*26.27*/(""" """),format.raw/*26.28*/("""</td>
          <td> """),_display_(/*27.17*/d/*27.18*/.temperature),format.raw/*27.30*/(""" """),format.raw/*27.31*/("""</td>
          <td> """),_display_(/*28.17*/d/*28.18*/.battery),format.raw/*28.26*/(""" """),format.raw/*28.27*/("""</td>
          <td> """),_display_(/*29.17*/d/*29.18*/.weight),format.raw/*29.25*/(""" """),format.raw/*29.26*/("""</td>
          <td> """),_display_(/*30.17*/d/*30.18*/.is_occupied),format.raw/*30.30*/(""" """),format.raw/*30.31*/("""</td>
        </tr>
        """)))}),format.raw/*32.10*/("""
        """),format.raw/*33.9*/("""</tbody>
      </table>

    </article>
  </div>
</section>
""")))}),format.raw/*39.2*/("""
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
                  DATE: Sun Jul 07 17:51:53 CEST 2019
                  SOURCE: /Users/lucasmarty/Desktop/temp/scala_drone/server/app/views/index.scala.html
                  HASH: e2387e6080a77810ad8a601abd7c71f4deda277e
                  MATRIX: 778->1|938->68|965->70|988->85|1027->87|1054->89|1101->128|1151->141|1179->143|1577->514|1609->530|1648->531|1684->540|1732->561|1742->562|1766->565|1795->566|1844->588|1854->589|1886->600|1915->601|1964->623|1974->624|2005->634|2034->635|2083->657|2093->658|2123->667|2152->668|2201->690|2211->691|2244->703|2273->704|2322->726|2332->727|2361->735|2390->736|2439->758|2449->759|2477->766|2506->767|2555->789|2565->790|2598->802|2627->803|2687->832|2723->841|2814->902
                  LINES: 21->1|26->2|27->3|27->3|27->3|28->4|28->4|28->4|30->6|45->21|45->21|45->21|46->22|47->23|47->23|47->23|47->23|48->24|48->24|48->24|48->24|49->25|49->25|49->25|49->25|50->26|50->26|50->26|50->26|51->27|51->27|51->27|51->27|52->28|52->28|52->28|52->28|53->29|53->29|53->29|53->29|54->30|54->30|54->30|54->30|56->32|57->33|63->39
                  -- GENERATED --
              */
          