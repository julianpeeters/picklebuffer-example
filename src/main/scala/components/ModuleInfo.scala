package avocet 
import tags._
import types._

case class ModuleInfo(names: List[String], valueMembers: List[ValueMember]) {
  ModuleSym.write
  names.length match {
    case 1          => TermName(names(0)).write
    case x if x > 1 => TermName(names(1)).write 
    case _          => println("whoops, no class name?")
  }
  TypeRefTpe_moduleClass.write
  ClassSym_Module.write
  ClassInfoTpe_Module(valueMembers).write
  TypeRefTpe_AbstractFunction(valueMembers).write
}
