import java.io.File
import scala.io.Source

class csvParser(file: File) extends Iterable[Drone] {

  val lines = Source.fromFile(file).getLines()
  val header = lines.next().split(";").filter(_.nonEmpty)

  override def iterator = new Iterator[Drone] {
    def hasNext = lines.hasNext

    def next = {

      val tab = lines.next().split(";")

      new Drone(tab(0).toInt, tab(1).substring(1, tab(1).length()-1),
        tab(2).substring(1, tab(2).length()-1), tab(3).toInt, tab(4).toInt, tab(5).toInt)
    }
  }
}