package avocet
import models._
import methods.cls._
import methods.module._
import scala.reflect.internal.pickling._
import scala.tools.nsc.util.ShowPickled
import java.util.Arrays
import java.io.{PrintStream, File}

object Main extends App {

//write entries

  ClassInfo
  val valueMembers = List(ValueMember("x", "String"), ValueMember("y", "AnyRef"))//write value member entries
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
  
  ModuleInfo(valueMembers)
  Init_Module(init)
  ToString_Module(valueMembers)
  Apply(valueMembers, init)
  Unapply(valueMembers, init)
  ReadResolve


  val myPickleBuffer = new PickleBuffer(ScalaSig.bytes, 0, ScalaSig.bytes.length)

  val ps = new PrintStream(new File("output/ShowPickled.myPickleBuffer"))
  ShowPickled.printFile(myPickleBuffer, ps)

}


