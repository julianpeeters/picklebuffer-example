package avocet
package tags

object NoneSym {
  val position = Position.current
  def write = {
  //tag
    PB.myBuf.writeByte(3)
  //len
    PB.myBuf.writeNat(0)
  //data
  //}
    Position.current += 1
  }
}

