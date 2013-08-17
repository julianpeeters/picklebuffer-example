package avocet 

import models._
import java.util.Arrays
import scala.reflect.internal.pickling._

import org.specs2._
import mutable._
import specification._
import execute.Success
/*
class UnitSpec extends mutable.Specification {
  

  val mySig = new ScalaSig(List("models", "MyRecord"), List(("x", "String")))

  val correctBytes: Array[Byte] = {
    val scalaSigAnnot = classOf[MyRecord].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes.getBytes
    val len           = ByteCodecs.decode(encodedBytes)

    Arrays.copyOf(encodedBytes, len)
  }

  "a ScalaSig for `case class MyRecord(x: String)`" should {
    "contain 135 entries" in {
     mySig.entriesNumber === 135
    }

  }

  "a ScalaSig for `case class MyRecord(x: String)`" should {
    "have the correct bytes" in {
      mySig.bytes === correctBytes
    }
  }
 


}
*/
