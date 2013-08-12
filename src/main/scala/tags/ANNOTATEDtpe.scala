package avocet
package tags

case class AnnotatedTpe(valueMember: ValueMember) {
  def write = {
//tag
  PB.myBuf.writeByte(42)
//len
  if (valueMember.typeRefPosition > 127 && Position.current + 1 > 127) PB.myBuf.writeNat(4)
  else if (valueMember.typeRefPosition > 127 || Position.current + 1 > 127) PB.myBuf.writeNat(3)
  else PB.myBuf.writeNat(2)
//data {
  //reference to the next entry, EXTMODCLASSref                 
  PB.myBuf.writeNat(valueMember.typeRefPosition)
  //reference to the next entry, EXTMODCLASSref                 
  PB.myBuf.writeNat(Position.current + 1)
//} 
  Position.current += 1 
  } 
}  
