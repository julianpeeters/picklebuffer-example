package avocet 
package types
import tags._

object TypeRefTpe_AnyRef  extends Tpe {
  var polyTpePosition = 0
  var position = 0
  def write = {    
    position = Position.current
    TypeRefTpe_nonGeneric(Position.current + 1, Position.current + 4).writeEntry//this type, ExtRef
    ThisTpe_scala.write
    ExtModClassRef_scala.write
    TermName("scala").write
    ExtRef_nested(Position.current + 1, ExtModClassRef_scala.position).write
    TypeName("AnyRef").write

  }
}

