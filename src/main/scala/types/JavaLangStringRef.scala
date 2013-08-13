package avocet 
package types
import tags._

object TypeRefTpe_javaLangString extends Tpe{
  var position = 0
  var polyTpePosition = 0
  def write = {
    position = Position.current
    TypeRefTpe_nonGeneric(Position.current + 1, Position.current + 6).writeEntry
  }
}
