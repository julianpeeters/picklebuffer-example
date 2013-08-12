package avocet
package tags

case class ExtRef_topLevel(ref: Int) {
  //Write entry  EXTref
  def write = {
  //tag
    PB.myBuf.writeByte(9)
  //len
    if (ref > 127) PB.myBuf.writeNat(2)
    else PB.myBuf.writeNat(1)
  //data {
    //reference               
      PB.myBuf.writeNat(ref)
  //}
      Position.current += 1
  }
}

case class ExtRef_nested(nameRef: Int, ownerRef: Int) {
  //Write entry  EXTref
  def write = {
  //tag
    PB.myBuf.writeByte(9)
  //len
    if (nameRef > 127 && ownerRef > 127) PB.myBuf.writeNat(4);  
    else if (nameRef > 127 || ownerRef > 127) PB.myBuf.writeNat(3);  
    else PB.myBuf.writeNat(2)
  //data {
    //reference to the next entry,              
     PB.myBuf.writeNat(nameRef)
    //reference to the next entry,              
     PB.myBuf.writeNat(ownerRef)
  //}
      Position.current += 1
  }
}
