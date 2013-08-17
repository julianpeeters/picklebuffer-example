package avocet 

import models._
import java.util.Arrays
import scala.reflect.internal.pickling._

import org.specs2._
import mutable._
import specification._
import execute.Success

class UnitSpec_DataTypes extends mutable.Specification {
  
//  val mySig = new ScalaSig(List("models", "MyRecord_Byte"), List(("a", "Byte")))
 // val mySig = new ScalaSig(List("models", "MyRecord_Short"), List(("b", "Short")))
  val mySig = new ScalaSig(List("models", "MyRecord_Int"), List(("c", "Int")))
 // val mySig = new ScalaSig(List("models", "MyRecord_Long"), List(("d", "Long")))
 // val mySig = new ScalaSig(List("models", "MyRecord_Float"), List(("e", "Float")))
//  val mySig = new ScalaSig(List("models", "MyRecord_Double"), List(("f", "Double")))
//  val mySig = new ScalaSig(List("models", "MyRecord_Char"), List(("g", "Char")))
//  val mySig = new ScalaSig(List("models", "MyRecord_String"), List(("h", "String")))
//  val mySig = new ScalaSig(List("models", "MyRecord_Boolean"), List(("i", "Boolean")))
 // val mySig = new ScalaSig(List("models", "MyRecord_Unit"), List(("j", "Unit")))
//  val mySig = new ScalaSig(List("models", "MyRecord_Null"), List(("k", "Null")))
//  val mySig = new ScalaSig(List("models", "MyRecord_Nothing"), List(("l", "Nothing")))
  //val mySig = new ScalaSig(List("models", "MyRecord_Any"), List(("m", "Any")))
  //val mySig = new ScalaSig(List("models", "MyRecord_AnyRef"), List(("n", "AnyRef")))


 // val mySig = new ScalaSig(List("models", "MyRecord_Short"), List(("l", "Short")))

/*
  val mySig = new ScalaSig(List("models", "MyRecord_AllDatatypes"), List(
    ("a", "Byte"),
    ("b", "Short"),
    ("c", "Int"),
    ("d", "Long"),
    ("e", "Float"),
    ("f", "Double"),
    ("g", "Char"),
    ("h", "String"),
    ("i", "Boolean"),
    ("j", "Unit"),
    ("k", "Null"),    
    ("l", "Nothing"),
    ("m", "Any"),
    ("n", "AnyRef")                 
  ))
*/

  val correctBytes: Array[Byte] = {
    val scalaSigAnnot = classOf[MyRecord_Int].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes.getBytes
    val len           = ByteCodecs.decode(encodedBytes)

    Arrays.copyOf(encodedBytes, len)
  }



  "a ScalaSig for a case class with all supported datatypes" should {
    "have the correct bytes" in {
      mySig.bytes === correctBytes
    }
  }
 


}

