package avocet 
import scala.reflect.internal.pickling._

object PB {
  val myBuf = new PickleBuffer(new Array[Byte](4096), -1, 0)//get an array ready to be written to
  var position = 0
}
