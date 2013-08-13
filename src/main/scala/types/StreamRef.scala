package avocet 
package types
import tags._

object TypeRefTpe_Stream extends Tpe {
  var polyTpePosition = 0
  var position = Position.current
  def write = {
    TypeRefTpe_generic(Position.current + 1, Position.current + 9, Position.current + 12) 
    SingleTpe(Position.current + 1, Position.current + 6)
    SingleTpe(Position.current + 1, Position.current + 4)
    ThisTpe_root
    ExtModClassRef_root
    TermName("<root>")
    ExtRef_topLevel(9)
    ExtRef_nested(Position.current + 1, ExtModClassRef_scala.position)
    TermName("package")
    ExtRef_nested(Position.current + 1, Position.current + 2)
    TypeName("Stream")
  }
}
