package avocet
package methods
package module

import tags._
import types._
import cls._

case class Unapply(valueMembers: List[ValueMember], init: Init) {
  val valSymPosition = Position.current
  val valueMemberTypeRefPositions = valueMembers.map(vm => vm.typeRefPosition)

//  ValSym(7, Position.current + 1, ClassSym_Module.position, 2097728L, Position.current + 2).write
  ValSym(Position.current + 1, ClassSym_Module.position, 2097728L, Position.current + 2).write
  TermName("unapply").write
  
  valueMembers.length match {
    case 1          => {  // if there is only 1 value member, have the option typereftpe ref the value member
      TypeRefTpe_Option.position match {
        case 0      => {
          MethodTpe(List(Position.current + 1, Position.current + 4)).write
          TypeRefTpe_unapplyOption(ThisTpe_scala.position, Position.current + 1, valueMembers(0).typeRefPosition).writeEntry
          ExtRef_nested(Position.current + 1, ExtModClassRef_scala.position).write
          TypeName("Option").write

        }
        case i: Int => {
          MethodTpe(List(Position.current + 1, Position.current + 2)).write  
          TypeRefTpe_unapplyOption(ThisTpe_scala.position, TypeRefTpe_Option.position + 1, valueMembers(0).typeRefPosition).writeEntry
        }
      }
    }
    case x if x > 1 =>{ // if there is more than 1 value member, have the option's typereftpe ref TupleRef
      TypeRefTpe_Option.position match {
        case 0      => {
          MethodTpe(List(Position.current + 1, Position.current + 4)).write
          TypeRefTpe_unapplyOption(ThisTpe_scala.position, Position.current + 1,  Position.current + 3).writeEntry
          ExtRef_nested(Position.current + 1, ExtModClassRef_scala.position).write
          TypeName("Option").write
          TypeRefTpe_Tuple(valueMembers).write
        }
        case i: Int => {
          MethodTpe(List(Position.current + 1, Position.current + 2)).write  
          TypeRefTpe_unapplyOption(ThisTpe_scala.position, TypeRefTpe_Option.position + 1, Position.current + 1).writeEntry
        }
      }
    }
    case _          => println("Hmm... what's wrong with your value members? Do you have any?") 
  }


//  ValSym(7, Position.current + 1, valSymPosition, 2105344L, init.typeRefTpePosition).write
  ValSym(Position.current + 1, valSymPosition, 2105344L, init.typeRefTpePosition).write
  TermName("x$0").write

}
