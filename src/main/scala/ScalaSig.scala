package avocet
import methods.cls._
import methods.module._

class ScalaSig(names: List[String], args: List[(String, String)]) { //takes a list of names and type names
  
 //write entries

  ClassInfo(names)
  val valueMembers = args.map(arg => ValueMember(arg._1, arg._2))
  val init = Init(valueMembers) 
  init.write
  Copy(valueMembers)
  CopyDefault(valueMembers)
  ProductPrefix
  ProductArity
  ProductElement
  ProductIterator
  CanEqual
  HashCode
  ToString
  Equals
  
  ModuleInfo(names, valueMembers)
  Init_Module(init)
  ToString_Module(valueMembers)
  Apply(valueMembers, init)
  Unapply(valueMembers, init)
  ReadResolve

  val entriesNumber = Position.current
//write header last because we need to know #entries, then concat the header with the entries
  val bytes = Array.concat(SigHeader.bytes, PB.myBuf.bytes).reverse.dropWhile(byte => byte == 0).reverse:+(0.toByte)//trim the excess 0s
}
