package avocet
package methods
package cls

import tags._
import types._

object Equals {
  val valSymPosition = Position.current
//  ValSym(7, Position.current + 1, ClassSym.position, 2097696L, Position.current + 2).write
  ValSym(Position.current + 1, ClassSym.position, 2097696L, Position.current + 2).write
  TermName("equals").write
  MethodTpe(List(TypeRefTpe_Boolean.position, Position.current + 1)).write
//  ValSym(7, ProductElement.termNamex1Position, valSymPosition, 2105344L, TypeRefTpe_Any.position).write
  ValSym(ProductElement.termNamex1Position, valSymPosition, 2105344L, TypeRefTpe_Any.position).write
}
