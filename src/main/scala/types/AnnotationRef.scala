package avocet 
package types
import tags._

case class Annotation(valueMember: ValueMember) extends Tpe {
  var position = 0
  var polyTpePosition = 0
  def write = {
    position = Position.current

    AnnotatedTpe(valueMember).write
    AnnotInfo.position match {
      case 0 => AnnotInfo.write
      case _ =>
    }
  
  }
}

