package avocet
package tags

case class TypeRefTpe_nonGeneric(ownerRef: Int, extRef: Int) {
  val args = List(ownerRef, extRef)
  def writeEntry = {
  //tag
    PB.myBuf.writeByte(16)
  //len
    PB.myBuf.writeNat(2 + args.filter(arg => arg > 127).length)
  //data {
    //refs             
      args.foreach(arg => PB.myBuf.writeNat(arg))
    //}
      Position.current += 1
  }
}

case class TypeRefTpe_generic(ownerRef: Int, ExtRef: Int, boxedTypeRef: Int) {
  val args = List(ownerRef, ExtRef, boxedTypeRef)
  def writeEntry = {
  //tag
    PB.myBuf.writeByte(16)
  //len
    PB.myBuf.writeNat(3 + args.filter(arg => arg > 127).length)
  //data {
    //ref to type
      args.foreach(arg => PB.myBuf.writeNat(arg))
  //}
      Position.current += 1
  }
}
 
case class TypeRefTpe_function(runtimeRef: Int, abstractFunctionRef: Int, memberTypeRefs: List[Int], modelMyRecordRef: Int) {
  val args = runtimeRef :: abstractFunctionRef :: modelMyRecordRef :: memberTypeRefs
  def writeEntry = {
  //tag
    PB.myBuf.writeByte(16)
  //len
    PB.myBuf.writeNat(3 + memberTypeRefs.length + args.filter(arg => arg > 127).length)
  //data {
      args.foreach(arg => PB.myBuf.writeNat(arg))
  //}
      Position.current += 1
  }
}

case class TypeRefTpe_tuple(scalaThisTpeRef: Int, tupleExtRefRef: Int, memberTypeRefs: List[Int]) {
  val args = scalaThisTpeRef :: tupleExtRefRef :: memberTypeRefs
  def writeEntry = {
  //tag
    PB.myBuf.writeByte(16)
  //len
    PB.myBuf.writeNat(2 + memberTypeRefs.length + args.filter(arg => arg > 127).length)
  //data {
      args.foreach(arg => PB.myBuf.writeNat(arg))
  //}
      Position.current += 1
  }
} 
 

case class TypeRefTpe_unapplyOption(scalaRef: Int, optionExtRef: Int, tupledValueMembersRef: Int) {
  val args = List(scalaRef, optionExtRef, tupledValueMembersRef)
  def writeEntry = {
  //tag
    PB.myBuf.writeByte(16)
  //len
    PB.myBuf.writeNat(3 + args.filter(arg => arg > 127).length)
  //data {
    //reference to the owner, e.g. CLASSsym or "scala", an EXTMODCLASS                 
      args.foreach(arg => PB.myBuf.writeNat(arg))
  //}
      Position.current += 1
  }
} 



