package avocet

object ScalaSig {
  val bytes = Array.concat(SigHeader.bytes, PB.myBuf.bytes)
}
