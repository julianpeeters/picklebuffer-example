package avocet
package methods
package cls

import tags._
import types._

case class Copy(valueMembers: List[ValueMember]) {
  val valSymPosition = Position.current
  ValSym(7, Position.current + 1, ClassSym.position, 2097664L, Position.current + 2).write
  TermName("copy").write
  MethodTpe(List(TypeRefTpe_modelsMyRecord.position, Position.current + 1)).write
  valueMembers.foreach(m => ValSym(7, m.termNamePosition, valSymPosition, 33562624L, m.typeRefPosition).write)
}
