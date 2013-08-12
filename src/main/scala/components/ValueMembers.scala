package avocet
import tags._
import types._

case class ValueMember(termName: String) {

  val tpe = "String"
  ValSym(8, Position.current + 1, ClassSym.position, 692060672L, Position.current + 2).write
  val termNamePosition = Position.current
  TermName(termName).write
  val polyTpe_StringPosition = Position.current
  PolyTpe(TypeRefTpe_AnyRef).write

  val typeRefPosition = Position.current
  TypeRefTpe_String.write

  ValSym(8, Position.current + 1, ClassSym.position, 554172420L, typeRefPosition).write
  TermName(termName + " ").write
}
