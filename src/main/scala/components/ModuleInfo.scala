package avocet 
import tags._
import types._

case class ModuleInfo(valueMembers: List[ValueMember]) {
  ModuleSym.write
  TermName("MyRecord").write
  TypeRefTpe_moduleClass.write
  ClassSym_Module.write
  ClassInfoTpe_Module(valueMembers).write
  TypeRefTpe_AbstractFunction(valueMembers).write
}
