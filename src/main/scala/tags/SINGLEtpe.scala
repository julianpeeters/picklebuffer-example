package avocet
package tags

case class SingleTpe(scalaRef: Int, modRef: Int) {
  def write = {
  //tag
    PB.myBuf.writeByte(14)
  //len
    if (scalaRef > 127 && modRef > 127) PB.myBuf.writeNat(4);  
    else if (scalaRef > 127 || modRef > 127) PB.myBuf.writeNat(3);  
    else PB.myBuf.writeNat(2)
  //data {
    //reference 
    PB.myBuf.writeNat(scalaRef)
    //reference 
    PB.myBuf.writeNat(modRef)
  //}
      Position.current += 1
  
}}
