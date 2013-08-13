package avocet
package methods
package cls

import tags._
import types._

case class Init(valueMembers: List[ValueMember]) {
  var termNamePosition = 0
  val typeRefTpePosition = Position.current + 3
  def write  = {
    ValSym(5, Position.current + 1, ClassSym.position, 512L, Position.current + 2).write
    TermName("<init>").write
    
  
        val paramPositions = (1 to valueMembers.length).toList.map(vm => Position.current + 2 + vm)
        ThisTpe_owner.position match {//ThisTpe_owner should already have been written if the member's type is custom and local
          case 0      => {
            MethodTpe(Position.current + 1 :: paramPositions).write;
            TypeRefTpe_modelsMyRecord.write;
            ThisTpe_owner.write }
          case i: Int => { // is already defined, so won't need to be defined next
            MethodTpe(List(Position.current + 1, Position.current + 2)).write; 
            TypeRefTpe_modelsMyRecord.write 
          }
        }
      
      valueMembers.foreach(vm => ValSym(5, vm.termNamePosition, 30, 8192L, vm.typeRefPosition).write)
      

      
    
  }
}
