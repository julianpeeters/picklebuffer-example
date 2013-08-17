package avocet
package methods
package cls

import tags._
import types._

object ProductElement {
  val valSymPosition = Position.current
//  ValSym(7, Position.current + 1, ClassSym.position, 2097664L, Position.current + 2).write
  ValSym(Position.current + 1, ClassSym.position, 2097664L, Position.current + 2).write
  TermName("productElement").write
  TypeRefTpe_Any.position match {
    case 0      => MethodTpe(List(Position.current + 1, Position.current + 4)).write
    case i: Int => MethodTpe(List(i, Position.current + 1)).write
  }
  TypeRefTpe_Any.write
//  ValSym(7, Position.current + 1, valSymPosition, 2105344L, TypeRefTpe_Int.position).write
  ValSym(Position.current + 1, valSymPosition, 2105344L, TypeRefTpe_Int.position).write
  val termNamex1Position = Position.current
  TermName("x$1").write
}
