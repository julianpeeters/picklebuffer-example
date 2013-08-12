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



//To interpret the output, Compare it with output from `ShowPickled` of `scala.tools.nsc.util` compiler utils:
  val duplicateBuffer = new PickleBuffer(bytes, 0, bytes.length)
  val ps = new PrintStream(new File("ShowPickled.output"))
  ShowPickled.printFile(duplicateBuffer, ps)

/*
Notice that the numbers that represent the flags are different between our reading and `ShowPickled`.  This means that `ShowPickled` is an imperfect guide for how to write a Scala sig, we'll have to use `readByte`, `readNat`, and `ReadLongNat` directly. 

However problem arises from working with low-level tools: Only so many bytes can be read using the technique above. If one wishes to look further ahead than a few entries (e.g. to see how to represent a flag in a deeper VALsym), one must create an index of the entries and inspect each index position like so:
*/
  val triplicateBuffer = new PickleBuffer(bytes, 0, bytes.length)
  val index: Array[Int] = {
    val i = triplicateBuffer.createIndex
    triplicateBuffer.readIndex = 0
    i
  }
  val entryNumber = 129//an arbitrary entry to inspect
  val entryBuffer = new PickleBuffer(triplicateBuffer.toIndexedSeq(entryNumber)._2, 0, triplicateBuffer.toIndexedSeq(entryNumber)._2.length)
  entryBuffer.readNat
  entryBuffer.readNat
  println("flag: " + entryBuffer.readLongNat)
}
