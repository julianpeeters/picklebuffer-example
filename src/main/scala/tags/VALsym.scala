package avocet
package tags

case class ValSym(len: Int, termNamePos: Int, classSymPos: Int, flags: Long, typeRefPos: Int) {
  val intArgs = List(termNamePos, classSymPos, typeRefPos)
  def write = {
  //tag
    PB.myBuf.writeByte(8)
  //len
    PB.myBuf.writeNat(len + intArgs.filter(arg => arg > 127).length)
  //data {
    //reference 
      PB.myBuf.writeNat(termNamePos)
    //reference 
      PB.myBuf.writeNat(classSymPos)
    //reference 
      PB.myBuf.writeLongNat(flags)
    //reference 
      PB.myBuf.writeNat(typeRefPos)

    Position.current += 1
  }
}
