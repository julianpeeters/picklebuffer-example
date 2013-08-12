package avocet
package methods
package cls

import tags._
import types._

case class CopyDefault(valueMembers: List[ValueMember]) {
  val valSymPosition = Position.current
  ValSym(7, Position.current + 1, ClassSym.position, 35652096L, Position.current + 2).write
  TermName("copy$default$" + valueMembers.length).write
  PolyTpe(Annotation(valueMembers(0))).write
  Annotation(valueMembers(0)).write
  TypeRefTpe_UncheckedVariance.write
}
