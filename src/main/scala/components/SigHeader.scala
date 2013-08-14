package avocet
import scala.reflect.internal.pickling._
import PickleFormat._


object SigHeader {

//write version
  //Version
    HB.headerBuffer.writeNat(PickleFormat.MajorVersion)
    HB.headerBuffer.writeNat(PickleFormat.MinorVersion)

//write # of entries
    HB.headerBuffer.writeNat(Position.current)

    val bytes = if (Position.current > 127) HB.headerBuffer.bytes.take(4); else HB.headerBuffer.bytes.take(3)
}
