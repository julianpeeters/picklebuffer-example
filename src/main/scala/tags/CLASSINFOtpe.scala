package avocet
package tags
import types._

object ClassInfoTpe {
  val position = Position.current
  def write = {
//tag
    PB.myBuf.writeByte(19)
//len
    PB.myBuf.writeNat(4)
//data {
  //reference to entry 1, the CLASSsym                 
    PB.myBuf.writeNat(ClassSym.position)
  //reference to entry 6, AnyRef typereftype
    TypeRefTpe_AnyRef.position match {
        case 0      => PB.myBuf.writeNat(Position.current + 1)//TYPEREFs for types not already defined need to be added next
        case i: Int => PB.myBuf.writeNat(i)
      }
  //reference to entry 12, Product typereftype 
    TypeRefTpe_Product.position match {
        case 0      => PB.myBuf.writeNat(Position.current + 7)//TYPEREFs for types not already defined need to be added next
        case i: Int => PB.myBuf.writeNat(i)
    }
  //reference to entry 15, Serializable typereftype
    TypeRefTpe_Serializable.position match {
        case 0      => PB.myBuf.writeNat(Position.current + 10)//TYPEREFs for types not already defined need to be added next
        case i: Int => PB.myBuf.writeNat(i)
    }

    Position.current += 1
  }
}
