package avocet
package methods
package cls

import tags._
import types._

object HashCode {
  val valSymPosition = Position.current
 // ValSym(7, Position.current + 1, ClassSym.position, 2097696L, Position.current + 2).write
  ValSym(Position.current + 1, ClassSym.position, 2097696L, Position.current + 2).write
  TermName("hashCode").write
  MethodTpe(List(TypeRefTpe_Int.position)).write
}
