package avocet
package tags

case class TypeName (name: String) {
  def write = {
  //tag
    PB.myBuf.writeByte(2)
  //len
    PB.myBuf.writeNat(name.length)
  //data {
    //               
      name.getBytes.foreach(b => PB.myBuf.writeNat(b))
  //}
      Position.current += 1
  }
}
