package avocet
package tags

object AnnotInfo {
  def write = {
//tag
  PB.myBuf.writeByte(43)
//len
  if (Position.current + 1 > 127) PB.myBuf.writeNat(2); else PB.myBuf.writeNat(1)
//data {
  //reference to the next entry, EXTMODCLASSref                 
  PB.myBuf.writeNat(Position.current + 1)
//}  
  Position.current += 1 
  }  
}  
