package avocet 
package types
import tags._

case class TypeRefTpe_AbstractFunction(valueMembers: List[ValueMember]) extends Tpe {
  var position = 0
  var polyTpePosition = 0
  def write = {
    position = Position.current
    TypeRefTpe_function(Position.current + 1, Position.current + 4, valueMembers.map(_.typeRefPosition), TypeRefTpe_modelsMyRecord.position).writeEntry
    ThisTpe_runtime.write
    ExtModClassRef_runtime.write
    TermName("runtime").write
    ExtRef_nested(Position.current + 1, Position.current - 2).write
    TypeName("AbstractFunction" + valueMembers.length).write
  }
}
