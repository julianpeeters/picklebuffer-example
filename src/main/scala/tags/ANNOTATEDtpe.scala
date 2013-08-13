package avocet
package tags

case class AnnotatedTpe(valueMember: ValueMember) {
  val args = List(valueMember, Position.current + 1, AnnotInfo.position)
  def write = {
    AnnotInfo.position match {
      case 0      => {
      //tag
        PB.myBuf.writeByte(42)
      //len
        if (valueMember.typeRefPosition > 127 && Position.current + 1 > 127) PB.myBuf.writeNat(4)
        else if (valueMember.typeRefPosition > 127 && Position.current + 1 > 127 ) PB.myBuf.writeNat(3)
        else PB.myBuf.writeNat(2)
      //data {
        //reference to the next entry, EXTMODCLASSref                 
          PB.myBuf.writeNat(valueMember.typeRefPosition)
        //reference to 
          PB.myBuf.writeNat(Position.current + 1)
      } 
      case i: Int => {
      //tag
        PB.myBuf.writeByte(42)
      //len
        if (valueMember.typeRefPosition > 127 && AnnotInfo.position > 127) PB.myBuf.writeNat(4)
        else if (valueMember.typeRefPosition < 127 && AnnotInfo.position > 127) PB.myBuf.writeNat(3)
        else PB.myBuf.writeNat(2)
      //data {
        //reference to the next entry, EXTMODCLASSref                 
          PB.myBuf.writeNat(valueMember.typeRefPosition)
        //reference to 
          PB.myBuf.writeNat(AnnotInfo.position)
      //}
      }
    }
    Position.current += 1 
  } 
}  
