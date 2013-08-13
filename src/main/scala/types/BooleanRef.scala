package avocet 
package types
import tags._

object TypeRefTpe_Boolean extends Tpe {
  var position = 0
  var polyTpePosition = 0
  def write = {  
    position = Position.current
    TypeRefTpe_nonGeneric(ThisTpe_scala.position, Position.current + 1).writeEntry 
    ExtRef_nested(Position.current + 1, ExtModClassRef_scala.position).write
    TypeName("Boolean").write
  }
}
