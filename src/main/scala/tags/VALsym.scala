package avocet
package tags
import scala.math._

//case class ValSym(len: Int, termNamePos: Int, classSymPos: Int, flags: Long, typeRefPos: Int) {
case class ValSym(termNamePos: Int, classSymPos: Int, flags: Long, typeRefPos: Int) {
  val args = List(termNamePos, classSymPos, flags, typeRefPos)
  def write = {
  //tag
    PB.myBuf.writeByte(8)
  //len
    val byteBoundaries = (1 to 10).map(power => pow(128,power))//for filtering values that will require more than one byte to write,
    val extraLength = byteBoundaries.map(byteBoundary => args.filter(arg => arg > byteBoundary-1).length).sum//sums the lengths of each filter
    PB.myBuf.writeNat(4 + extraLength)
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
