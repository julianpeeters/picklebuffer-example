package avocet
package tags

case class ValSym(len: Int, termNamePos: Int, classSymPos: Int, flags: Long, typeRefPos: Int) {
  def write = {
  //tag
    PB.myBuf.writeByte(8)
  //len
    PB.myBuf.writeNat(len)
  //data {
    //reference 
      PB.myBuf.writeNat(termNamePos)
    //reference 
      PB.myBuf.writeLong(classSymPos)
    //reference 
      PB.myBuf.writeLongNat(flags)
    //reference 
      PB.myBuf.writeNat(typeRefPos)

    Position.current += 1
  }
}
