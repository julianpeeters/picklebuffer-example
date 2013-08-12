package avocet
package methods
package module

import tags._
import types._
import cls._

case class Unapply(valueMembers: List[ValueMember], init: Init) {
  val valSymPosition = Position.current
  val valueMemberTypeRefPositions = valueMembers.map(vm => vm.typeRefPosition)

  ValSym(7, Position.current + 1, ClassSym_Module.position, 2097728L, Position.current + 2).write
  TermName("Unapply").write
  TypeRefTpe_Option.position match {
    case 0     => {
      MethodTpe(List(Position.current + 1, Position.current + 4)).write
      tupledValueMemberRef(Position.current + 1, Position.current + 3)
      ExtRef_nested(Position.current + 1, ExtModClassRef_scala.position).write
      TypeName("Option").write

    }
    case i: Int => {
      MethodTpe(List(Position.current + 1, Position.current + 2)).write  
      tupledValueMemberRef(TypeRefTpe_Option.position + 1, Position.current + 1)
    }
  }
  ValSym(6, Position.current + 1, 121, 8192L, init.typeRefTpePosition).write
  TermName("x$0").write

  def tupledValueMemberRef(optionExtRef: Int, optionTupledTypeRef: Int)= {
    valueMembers.length match {
      case 1          => TypeRefTpe_unapplyOption(ThisTpe_scala.position, optionExtRef, valueMembers(0).typeRefPosition).writeEntry
      case x if x > 1 => TypeRefTpe_unapplyOption(ThisTpe_scala.position, optionExtRef, optionTupledTypeRef).writeEntry
      case _          => println("Hmm... what's wrong with your value members? Do you have any?") 
    }
  }
}
