package avocet 
package types
import tags._

object TypeRefTpe_moduleClass extends Tpe {
  var position = 0
  def write = {
    position = Position.current
    TypeRefTpe_nonGeneric(ThisTpe_owner.position, Position.current + 1).writeEntry
  }
}
