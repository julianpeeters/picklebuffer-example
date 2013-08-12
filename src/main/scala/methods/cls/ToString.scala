package avocet
package methods
package cls

import tags._
import types._

object ToString {
  val valSymPosition = Position.current
  ValSym(7, Position.current + 1, ClassSym.position, 2097696L, Position.current + 2).write
  val termNamePosition = Position.current
  TermName("ToString").write
  val MethodTpePositition = Position.current
  MethodTpe(List(TypeRefTpe_javaLangString.position)).write
}
