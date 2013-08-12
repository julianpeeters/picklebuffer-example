package avocet
package tags

object ThisTpe_scala      extends ThisTpe(Position.current + 1)
object ThisTpe_package    extends ThisTpe(Position.current + 1)
object ThisTpe_lang       extends ThisTpe(Position.current + 1)
object ThisTpe_javaLang   extends ThisTpe(Position.current + 1)
object ThisTpe_root       extends ThisTpe(Position.current + 1) 
object ThisTpe_unchecked  extends ThisTpe(Position.current + 1)
object ThisTpe_collection extends ThisTpe(Position.current + 1)
object ThisTpe_runtime    extends ThisTpe(Position.current + 1) 
object ThisTpe_owner      extends ThisTpe(ExtModClassRef_owner.position)

class ThisTpe(ref: Int) {
  var position = 0
  def write =  {
  position = Position.current  
  //tag
    PB.myBuf.writeByte(13)
  //len
    if (Position.current + 1 > 127 || ref > 127) PB.myBuf.writeNat(2); else PB.myBuf.writeNat(1)
  //data {
    //reference to the head of the type's typereftype chain             
      ref match {
        case 0      => PB.myBuf.writeNat(Position.current + 1)//TYPEREFs for types not already defined need to be added next
        case i: Int => PB.myBuf.writeNat(i)       
      }
  //}
      Position.current += 1
  }
}  
