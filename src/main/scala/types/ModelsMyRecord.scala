package avocet 
package types
import tags._

object TypeRefTpe_modelsMyRecord extends Tpe {
  var position = 0
  var polyTpePosition = 0
  def write = {
    position = Position.current
    TypeRefTpe_nonGeneric(Position.current + 1, ClassSym.position).writeEntry//0 references the CLASSsym, in this case MyRecord
  }
}

