package avocet
package tags
import types._

case class PolyTpe[X <: Tpe](typeRef: X) {
  //var position = 0
  def write {
  //tag
    PB.myBuf.writeByte(21)
  //len
    if (Position.current + 1 > 127 || typeRef.position > 127) PB.myBuf.writeNat(2); else PB.myBuf.writeNat(1)
  //data {
    //reference to the head of the type's typereftype chain             
      typeRef.position match {//TYPEREFs for types not already defined need to be added next
        case 0      => PB.myBuf.writeNat(Position.current + 1); typeRef.polyTpePosition = Position.current
        case i: Int => PB.myBuf.writeNat(i); typeRef.polyTpePosition = Position.current
      }
  //}
      Position.current += 1
  }
}


