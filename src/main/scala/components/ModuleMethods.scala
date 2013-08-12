package avocet 
import tags._
import types._
import methods.cls._
import methods.module._

case class ModuleMethods(valueMembers: List[ValueMember]) {
  val init = Init(valueMembers)  //TODO turn val into an object that extends Init(xs)?
  Init_Module(init)
  ToString_Module(valueMembers)
  Apply(valueMembers, init)
  Unapply(valueMembers, init)
  ReadResolve
}
