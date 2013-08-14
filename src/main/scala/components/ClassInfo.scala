package avocet 
import tags._
import types._

object ClassInfo {
//entry 0 CLASSsym 
  ClassSym.write
//entry 1
  TypeName("MyRecord").write
//entry 2 EXTMODCLASSref: the immediate enclosing package 
  ExtModClassRef_owner.write
//entry 3 TERMname of Ext Mod: the immediate owner's name, i.e. the name of the immediate enclosing package
  TermName("models").write
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
