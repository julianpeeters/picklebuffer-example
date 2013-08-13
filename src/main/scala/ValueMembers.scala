package avocet
import tags._
import types._

case class ValueMember(termName: String, typeName: String) {
  var polyTpePosition = 0
  var typeRefPosition = 0
  var termNamePosition = 0

  def writeTpe[X <: Tpe](typeRef:X) = {//if type is previous value member's, ref previous member's polytype
    typeRef.position match { //polytpe position is determined by TypeRef position (all types but AnyRef follow a polytpe)
      case 0      => { //if it doesn't exist, write it next
        polyTpePosition = Position.current + 2
        ValSym(8, Position.current + 1, ClassSym.position, 692060672L, polyTpePosition).write
        termNamePosition = Position.current
        TermName(termName).write
        PolyTpe(typeRef).write
        typeRefPosition = Position.current
        typeRef.write
      }
      case 6      => {//AnyRef gets special treatement, since it the only type defined before all other value member types
        polyTpePosition = Position.current + 2
        typeRefPosition = typeRef.position
        ValSym(8, Position.current + 1, ClassSym.position, 692060672L, polyTpePosition).write
        termNamePosition = Position.current
        TermName(termName).write
        PolyTpe(typeRef).write
      }
      case i: Int => {//if the type has been previously 
        polyTpePosition = typeRef.position - 1
        typeRefPosition = typeRef.position
        ValSym(8, Position.current + 1, ClassSym.position, 692060672L, polyTpePosition).write
        termNamePosition = Position.current
        TermName(termName).write
      }
    }
  }

  typeName match {
    case "Byte" => writeTpe(TypeRefTpe_Byte) 
    case "Short" => writeTpe(TypeRefTpe_Short) 
    case "Int" => writeTpe(TypeRefTpe_Int) 
    case "Long" => writeTpe(TypeRefTpe_Long) 
    case "Float" => writeTpe(TypeRefTpe_Float) 
    case "Double" => writeTpe(TypeRefTpe_Double)
    case "Char" => writeTpe(TypeRefTpe_Char)
    case "String" => writeTpe(TypeRefTpe_String) 
    case "Boolean" => writeTpe(TypeRefTpe_Boolean) 
    case "Unit" => writeTpe(TypeRefTpe_Unit) 
    case "Null" => writeTpe(TypeRefTpe_Null) 
    case "Nothing" => writeTpe(TypeRefTpe_Nothing) 
    case "Any" => writeTpe(TypeRefTpe_Any) 
    case "AnyRef" => writeTpe(TypeRefTpe_AnyRef)
    case "Object" => writeTpe(TypeRefTpe_Object) 
    //generics
    case "Option" => writeTpe(TypeRefTpe_Option) 
    case "Iterator" => writeTpe(TypeRefTpe_Iterator) 
    case "List" => writeTpe(TypeRefTpe_List) 
    case "Stream" => writeTpe(TypeRefTpe_Stream) 
  }

  ValSym(8, Position.current + 1, ClassSym.position, 554172420L, typeRefPosition).write
  TermName(termName + " ").write
}
