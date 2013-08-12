package avocet
package tags

object ModuleSym {
  var position = 0
  def write = {
    position = Position.current
  //tag
    PB.myBuf.writeByte(7)
  //len
    if (Position.current + 1 > 127 && Position.current + 2 > 127) PB.myBuf.writeNat(9);  
    else if (Position.current + 1 > 127 || Position.current + 2 > 127) PB.myBuf.writeNat(8);  
    else PB.myBuf.writeNat(7)
  //data {
    //reference to entry 1, the class name                 
      PB.myBuf.writeNat(Position.current + 1)
    //reference to the owner of the class
      PB.myBuf.writeNat(2)//TYPEREFs for types not already defined need to be added next
    //pickledflags 
      PB.myBuf.writeLongNat(2098176L)//(64 represents the "case" modifier)
    //reference to entry 5, the class info 
      PB.myBuf.writeNat(Position.current + 2)


      Position.current += 1
  }
}

