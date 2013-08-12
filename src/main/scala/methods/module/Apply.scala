package avocet
package methods
package module

import tags._
import cls._

case class Apply(valueMembers: List[ValueMember], init: Init) {
  val valSymPosition = Position.current
  ValSym(7, Position.current + 1, ClassSym_Module.position, 2097728L, Position.current + 2).write
  TermName("Apply").write
  val valueMembersAsParamsPositions = (Position.current + 1 to Position.current + valueMembers.length).toList
  MethodTpe(init.typeRefTpePosition :: valueMembersAsParamsPositions).write
  valueMembers.foreach(vm => ValSym(5, vm.termNamePosition, this.valSymPosition, 8192L, vm.typeRefPosition).write)
  
}
