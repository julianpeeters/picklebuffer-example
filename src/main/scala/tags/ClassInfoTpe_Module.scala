package avocet
package tags
import types._

case class ClassInfoTpe_Module(valueMembers: List[ValueMember]) {
  var position = 0
  def write = {
    position = Position.current
//tag
    PB.myBuf.writeByte(19)
//len
    if (Position.current + 1 > 127 || TypeRefTpe_AbstractFunction(valueMembers).position > 127) PB.myBuf.writeNat(4);  PB.myBuf.writeNat(3)
//data {
  //reference to a ClassSym
    PB.myBuf.writeNat(ClassSym_Module.position)  
  //reference to AbstractFuntion
    TypeRefTpe_AbstractFunction(valueMembers).position match {
        case 0      => PB.myBuf.writeNat(Position.current + 1)
        case i: Int => PB.myBuf.writeNat(i)
    }
  //reference to entry 15, Serializable typereftype
    PB.myBuf.writeNat(15)
    

    Position.current += 1
  }
}
