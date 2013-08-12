package avocet 
package types
import tags._

object TypeRefTpe_UncheckedVariance extends Tpe {
  var position = 0
  def write = {
    position = Position.current 
    TypeRefTpe_nonGeneric(Position.current + 1, Position.current + 6).writeEntry
    ThisTpe_unchecked.write
    ExtModClassRef_unchecked.write
    TermName("unchecked").write
    ExtModClassRef_annotation.write
    TermName("annotation").write
    ExtRef_nested(Position.current + 1, Position.current - 4).write
    TypeName("uncheckedVariance").write
  }
}
