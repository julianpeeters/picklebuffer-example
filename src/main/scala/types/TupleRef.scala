package avocet 
package types
import tags._

case class TypeRefTpe_Tuple(valueMembers: List[ValueMember]) extends Tpe {
  var position = 0
  var polyTpePosition = 0
  def write = {
    position = Position.current
    TypeRefTpe_tuple(ThisTpe_scala.position + 1, Position.current + 1, valueMembers.map(_.typeRefPosition)).writeEntry
    ExtRef_nested(Position.current + 1, ExtModClassRef_scala.position).write
    TypeName("Tuple" + valueMembers.length).write
  }
}
