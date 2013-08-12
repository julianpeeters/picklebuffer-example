package avocet
package tags


object ExtModClassRef_scala extends ExtModClassRef_topLevel(Position.current + 1){
  //val position = Position.current
}
object ExtModClassRef_owner extends ExtModClassRef_topLevel(Position.current + 1){
  //val position = Position.current
}
object ExtModClassRef_java extends ExtModClassRef_topLevel(Position.current + 1){
  //val position = Position.current
}
object ExtModClassRef_predef extends ExtModClassRef_nested(Position.current - 3, ExtModClassRef_scala.position){
 // val position = Position.current
      //Position.current += 1
}
object ExtModClassRef_lang extends ExtModClassRef_nested(Position.current + 1, Position.current + 2) {
  //val position = Position.current
      //Position.current += 1
}
object ExtModClassRef_root extends ExtModClassRef_nested(Position.current + 1, NoneSym.position) {
 // val position = Position.current
     // Position.current += 1
}
object ExtModClassRef_package extends ExtModClassRef_nested(Position.current - 3, ExtModClassRef_scala.position) {
  //val position = Position.current
      //Position.current += 1
}
object ExtModClassRef_unchecked extends ExtModClassRef_nested(Position.current + 1, Position.current + 2) {
  //val position = Position.current
      //Position.current += 1
}
object ExtModClassRef_annotation extends ExtModClassRef_nested(Position.current + 1, ExtModClassRef_scala.position) {
 // val position = Position.current
      //Position.current += 1
}
object ExtModClassRef_collection extends ExtModClassRef_nested(Position.current + 1, ExtModClassRef_scala.position) {
 // val position = Position.current
      //Position.current += 1
}
object ExtModClassRef_runtime extends ExtModClassRef_nested(Position.current + 1, ExtModClassRef_scala.position) {
  //val position = Position.current
      //Position.current += 1
}
object ExtModClassRef_javaLang extends ExtModClassRef_nested(Position.current + 1, Position.current + 2) {

}


class ExtModClassRef_topLevel(ref: Int){
  var position = 0
  def write = {
    position = Position.current
  //tag
    PB.myBuf.writeByte(10)
  //len
    if (ref > 127) PB.myBuf.writeNat(2);  PB.myBuf.writeNat(1)
  //data {
    //reference to the next entry, TERMname 
    PB.myBuf.writeNat(ref)
  //}
    Position.current += 1
  }
}

class ExtModClassRef_nested(nestedRef: Int, topLevelRef: Int){
  var position = 0
  def write = {
    position = Position.current
  //tag
    PB.myBuf.writeByte(10)
  //len
    if (nestedRef > 127 && topLevelRef > 127) PB.myBuf.writeNat(4);  
    else if (nestedRef > 127 || topLevelRef > 127) PB.myBuf.writeNat(3);  
    else PB.myBuf.writeNat(2)
  //data {
    //reference to the next entry, TERMname 
    PB.myBuf.writeNat(nestedRef)
    //reference to the next entry, TERMname 
    PB.myBuf.writeNat(topLevelRef)
  //}
    Position.current += 1
  }
}
