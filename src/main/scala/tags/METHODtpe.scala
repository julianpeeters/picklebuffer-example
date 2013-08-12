package avocet
package tags

case class MethodTpe(typeRefs: List[Int]) {
  val position = Position.current
  def write  = {
  //tag
    PB.myBuf.writeByte(20)
  //len
    PB.myBuf.writeNat(typeRefs.length + typeRefs.filter(tr => tr > 127).length)
  //data {
    //write type references
    typeRefs.foreach(tr => PB.myBuf.writeNat(tr))

    Position.current += 1
  }
}
