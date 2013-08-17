package avocet
import tags._
import types._

//object ClassInfo {
case class ClassInfo(fullName: List[String]) {
//entry 0 CLASSsym 
  ClassSym.write
//entry 1
  TypeName(fullName(1)).write
//entry 2 EXTMODCLASSref: the immediate enclosing package 
  ExtModClassRef_owner.write
//entry 3 TERMname of Ext Mod: the immediate owner's name, i.e. the name of the immediate enclosing package
  fullName.length match {
    case 1          =>  TermName("<empty>").write        //if there is only one name in the fullName list
    case x if x > 1 =>  TermName(fullName(0)).write   
    case _          =>  println("whoops, no class name?")
  }
//entry 4 NONEsym
  NoneSym.write
//entry 5 CLASSINFOtpe
  ClassInfoTpe.write
//entry 6 TYPEREFtpe
  TypeRefTpe_AnyRef.write
//entry 12 TYPEREFtpe: Product
  TypeRefTpe_Product.write
//entry 15 TYPEREFtpe: Serializable
  TypeRefTpe_Serializable.write
}
