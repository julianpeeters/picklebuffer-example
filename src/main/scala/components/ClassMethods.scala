package avocet 
import tags._
import types._
import methods.cls._

case class ClassMethods(valueMembers: List[ValueMember]) {
  val init = Init(valueMembers)  //TODO turn val into an object that extends Init(xs)?
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
}
