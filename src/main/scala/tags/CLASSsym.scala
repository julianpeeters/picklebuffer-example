package avocet
package tags

object ClassSym {
  var position = 0
  def write = {
    position = Position.current
  //tag
      PB.myBuf.writeByte(6)
  //len
      PB.myBuf.writeNat(4)
  //data {
    //reference to entry 1, the class name                 
      PB.myBuf.writeByte(1)

    //reference to the owner of the class
      new ExtModClassRef_topLevel(Position.current + 3).position match {
        case 0      => PB.myBuf.writeNat(Position.current + 2)//TYPEREFs for types not already defined need to be added next
        case i: Int => PB.myBuf.writeNat(i)//should point to "models" if this is for a Salat and Play2 App
      }

    //pickledflags 
      PB.myBuf.writeNat(64)//(64 represents the "case" modifier)
    //reference to entry 5, the class info 
      PB.myBuf.writeNat(5)

      Position.current += 1
  }
}

    //optional reference to 2nd level package, i.e., if the immediate owner has a dot, e.g. "com.MyOrg"
      //myBuf.writeByte()//TODO write immediate as well as top level owners
      //myBuf.writeByte()//TODO write the TERMname
