package avocet
package methods
package cls

import tags._
import types._

object ProductPrefix {
  val valSymPosition = Position.current
  ValSym(7, Position.current + 1, ClassSym.position, 2097696L, Position.current + 2).write
  TermName("ProductPrefix").write
  PolyTpe(TypeRefTpe_javaLangString).write
  TypeRefTpe_javaLangString.write
  ThisTpe_javaLang.write
  ExtModClassRef_lang.write
  TermName("lang").write
  ExtModClassRef_java.write
  TermName("java").write
  TypeRefTpe_String.typeNamePosition match {
    case 0      => ExtRef_nested(Position.current + 1, ExtModClassRef_lang.position).write; TypeName("String").write
    case i: Int => ExtRef_nested(TypeRefTpe_String.typeNamePosition, ExtModClassRef_lang.position).write
  }
}
