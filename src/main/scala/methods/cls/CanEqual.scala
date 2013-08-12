package avocet
package methods
package cls

import tags._
import types._

object CanEqual {
  val valSymPosition = Position.current
  ValSym(7, Position.current + 1, ClassSym.position, 2097664L, Position.current + 2).write
  TermName("CanEqual").write
  MethodTpe(List(Position.current + 1, Position.current + 4)).write
  TypeRefTpe_Boolean.write
  ValSym(7, ProductElement.termNamex1Position, ClassSym.position, 2105344L, TypeRefTpe_Any.position).write
}
