import models._
import scala.reflect.internal.pickling._
import scala.tools.nsc.util.ShowPickled
import java.util.Arrays
import java.io.{PrintStream, File}

object Main extends App {

  val clazz = classOf[MyRecord]

  val bytes: Array[Byte] = {
    val scalaSigAnnot = clazz.getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes.getBytes
    val len           = ByteCodecs.decode(encodedBytes)

    Arrays.copyOf(encodedBytes, len)
  }

  val pickleBuffer = new PickleBuffer(bytes, 0, bytes.length)

//read the header
  //version major
    println(pickleBuffer.readByte)
  //version minor
    println(pickleBuffer.readByte)
  //number of entries
    println(pickleBuffer.readNat)

//read the first entry
  //tag
    println(pickleBuffer.readByte)
  //len
    println(pickleBuffer.readByte)
  //data
    println(pickleBuffer.readByte)
    println(pickleBuffer.readByte)
    println(pickleBuffer.readLongNat)//flags
    println(pickleBuffer.readByte)


}
