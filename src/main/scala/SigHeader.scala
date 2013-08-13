package avocet

object SigHeader {

//write version
  //Version
    HB.headerBuffer.writeNat(5)//major
    HB.headerBuffer.writeNat(0)//minor

//write # of entries
    HB.headerBuffer.writeNat(Position.current)

    val bytes = if (Position.current > 127) HB.headerBuffer.bytes.take(4); else HB.headerBuffer.bytes.take(3)
}
