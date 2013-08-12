package avocet
package tags

case class TermName (name: String){
  def write = {
  //tag
    PB.myBuf.writeByte(1)
  //len
    PB.myBuf.writeNat(name.length)
  //data {
    //write the bytes of the string to the pickle buffer                 
      name.getBytes.foreach(b => PB.myBuf.writeNat(b))
  //}
      Position.current += 1
  }
}
