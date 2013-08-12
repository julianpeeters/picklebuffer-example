package avocet 
package types
import tags._

object TypeRefTpe_Iterator extends Tpe{
  var position = 0
  def write = {
  position = Position.current

  TypeRefTpe_generic(Position.current + 1, Position.current + 4, TypeRefTpe_Any.position).writeEntry
  ThisTpe_collection.write
  ExtModClassRef_collection.write
  TermName("collection").write
  ExtRef_nested(Position.current + 1, ExtModClassRef_collection.position).write
  TypeName("Iterator").write
}
}

