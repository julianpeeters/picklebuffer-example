package avocet
package methods
package cls

import tags._
import types._

case class CopyDefault(valueMembers: List[ValueMember]) {
  val valSymPosition = Position.current
  valueMembers.length match {
    case 1 => {
//      ValSym(7, Position.current + 1, ClassSym.position, 35652096L, Position.current + 2).write
      ValSym(Position.current + 1, ClassSym.position, 35652096L, Position.current + 2).write
      TermName("copy$default$1").write
      PolyTpe(Annotation(valueMembers(0))).write
      Annotation(valueMembers(0)).write
      TypeRefTpe_UncheckedVariance.write
    }
    case x if x > 1 => {
//      ValSym(7, Position.current + 1, ClassSym.position, 35652096L, Position.current + 2).write
      ValSym(Position.current + 1, ClassSym.position, 35652096L, Position.current + 2).write
      TermName("copy$default$1").write
      PolyTpe(Annotation(valueMembers(0))).write
      Annotation(valueMembers(0)).write
      TypeRefTpe_UncheckedVariance.write
      (2 to valueMembers.length).foreach(member => CopyDefault_plural(member))
    }
    case _ => println("what, no value members?")
  }
  def CopyDefault_plural(member: Int) = {
//    ValSym(7, Position.current + 1, ClassSym.position, 35652096L, Position.current + 2).write
    ValSym(Position.current + 1, ClassSym.position, 35652096L, Position.current + 2).write
    TermName("copy$default$" + member).write
    PolyTpe(Annotation(valueMembers(member-1))).write
    Annotation(valueMembers(member-1)).write
  }
}
