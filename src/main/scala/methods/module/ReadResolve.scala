package avocet
package methods
package module


import tags._
import types._

object ReadResolve {
  val valSymPosition = Position.current
  ValSym(9, Position.current + 1, ClassSym_Module.position, 2097668L, Position.current + 2).write
  TermName("ReadResolve").write

  TypeRefTpe_Object.position match {
    case 0      => MethodTpe(List(Position.current + 1)).write; TypeRefTpe_ObjectReadResolve.write
    case i: Int => MethodTpe(List(i)).write
  }



}
