package avocet 
package types
import tags._

object TypeRefTpe_String extends Tpe {
  var position = 0
  var typeNamePosition = 0
  def write = {
    position = Position.current
    TypeRefTpe_nonGeneric(ThisTpe_scala.position + 1, Position.current + 4).writeEntry
    SingleTpe(ThisTpe_scala.position, Position.current + 1).write 
    ExtRef_nested(Position.current + 1, ExtModClassRef_scala.position).write
    TermName("Predef").write
    ExtRef_nested(Position.current + 1, Position.current + 2).write
    typeNamePosition = Position.current
    TypeName("String").write
    ExtModClassRef_predef.write
  }
}


