package avocet
package tags

object ClassSym_Module {
  var position = 0
  def write = {
    position = Position.current
  //tag
      PB.myBuf.writeByte(6)
  //len
     // PB.myBuf.writeNat(7)
    if (Position.current + 1 > 127) PB.myBuf.writeNat(8); else PB.myBuf.writeNat(7)
  //data {
    //reference to entry 1, the class name                 
      PB.myBuf.writeByte(1)

    //reference to the owner of the class
      PB.myBuf.writeNat(2)
    //pickledflags 
      PB.myBuf.writeLongNat(2098176L)
    //reference
      PB.myBuf.writeNat(Position.current + 1)

      Position.current += 1
  }
}


