package avocet
package methods
package module

import tags._
import types._
import cls._

case class Init_Module(init: Init) {
  val position = Position.current
    ValSym(5, init.termNamePosition , ClassSym_Module.position, 512L, Position.current + 1).write
    MethodTpe(List(TypeRefTpe_moduleClass.position)).write
}

