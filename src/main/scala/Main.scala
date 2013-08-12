package avocet
import models._
import scala.reflect.internal.pickling._
import scala.tools.nsc.util.ShowPickled
import java.util.Arrays
import java.io.{PrintStream, File}

object Main extends App {
//write entries
  ClassInfo//Begin class entries
  val valueMembers = List(ValueMember("x"))//begin value member entries
  ClassMethods(valueMembers)//Begin Method Entries
  ModuleInfo(valueMembers)/////Begin MODULE entries
  ModuleMethods(valueMembers)//Module Methods
//
  
  val myPickleBuffer = new PickleBuffer(ScalaSig.bytes, 0, ScalaSig.bytes.length)

  val ps = new PrintStream(new File("output/ShowPickled.myPickleBuffer"))
  ShowPickled.printFile(myPickleBuffer, ps)

}


