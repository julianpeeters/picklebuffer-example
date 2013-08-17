package avocet
package methods
package cls

import tags._
import types._

object ProductArity {
  val valSymPosition = Position.current
  TypeRefTpe_Int.position match {
    case 0      => {
      ValSym(Position.current + 1, ClassSym.position, 2097664L, Position.current + 2).write
      //ValSym(7, Position.current + 1, ClassSym.position, 2097664L, Position.current + 2).write
      PolyTpe(TypeRefTpe_Int).write
      TypeRefTpe_Int.write
    }
//    case i: Int => ValSym(7, Position.current + 1, ClassSym.position, 2097664L, i - 1).write
    case i: Int => ValSym(Position.current + 1, ClassSym.position, 2097664L, i - 1).write
  }
  TermName("productArity").write

}
