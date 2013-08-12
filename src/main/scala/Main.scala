import models._
import scala.reflect.internal.pickling._
import scala.tools.nsc.util.ShowPickled
import java.util.Arrays
import java.io.{PrintStream, File}

object Main extends App {

  val myBuf = new PickleBuffer(new Array[Byte](4096), -1, 0)//get an array ready to be written to
  myBuf.writeNat(5)
  myBuf.writeNat(0)
  myBuf.writeNat(135)
  myBuf.writeNat(6)
  myBuf.writeNat(4)
  myBuf.writeNat(1)
  myBuf.writeNat(2)
  myBuf.writeNat(64)
  myBuf.writeNat(5)

//To check the output, view the pickle buffer with `ShowPickled` from `scala.tools.nsc.util` compiler utils:
  val myPickleBuffer = new PickleBuffer(myBuf.bytes, 0, myBuf.bytes.length)
  val myPS = new PrintStream(new File("output/ShowPickled_my.output"))
  ShowPickled.printFile(myPickleBuffer, myPS)

//To interpret the output, compare it with output from our real pickle buffer from our `models` class:
  val clazz = classOf[MyRecord]

  val bytes: Array[Byte] = {
    val scalaSigAnnot = clazz.getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes.getBytes
    val len           = ByteCodecs.decode(encodedBytes)

    Arrays.copyOf(encodedBytes, len)
  }
  val modelPickleBuffer = new PickleBuffer(bytes, 0, bytes.length)
  val modelPS = new PrintStream(new File("output/ShowPickled_model.output"))
  ShowPickled.printFile(modelPickleBuffer, modelPS)
}
