package avocet 
package types
import tags._

object TypeRefTpe_Byte extends Tpe{
  var position = Position.current
  def write = {
  TypeRefTpe_nonGeneric(ThisTpe_scala.position, Position.current + 1) 
  ExtRef_nested(Position.current + 1, ExtModClassRef_scala.position)
  TypeName("Byte")
}
}
