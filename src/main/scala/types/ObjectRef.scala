package avocet 
package types
import tags._

object TypeRefTpe_Object extends Tpe {
  var position = 0
  def write = {
    position = Position.current
    TypeRefTpe_nonGeneric(ThisTpe_scala.position + 1, Position.current + 6).writeEntry
    ThisTpe_lang.write
    ExtModClassRef_lang.write
    TermName("lang").write
    ExtModClassRef_java.write
    TermName("java").write
    ExtRef_nested(Position.current + 1, ExtModClassRef_lang.position).write
    TypeName("Object").write
  }
}
object TypeRefTpe_ObjectReadResolve extends Tpe {
  var position = 0
  def write = {
    position = Position.current
    TypeRefTpe_nonGeneric(ThisTpe_javaLang.position, Position.current + 1).writeEntry
    ExtRef_nested(Position.current + 1, ExtModClassRef_lang.position).write
    TypeName("Object").write
  }
}
