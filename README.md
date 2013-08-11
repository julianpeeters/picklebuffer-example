picklebuffer-example
====================

Uses a PickleBuffer to read and write Scala signatures, towards the goal of figuring out how to write an arbitrary Scala signature.

Please see other branches for more examples.

----------------------------------------------------

In this example we:

1) Take a simple case class and load the bytes from its Scala sig annotation into a `PickleBuffer`.
2) Read the bytes back out of the `PickleBuffer` "manually", printing to console.
3) Read the bytes back out of the `PickleBuffer` using `ShowPickled` from `scala.tools.nsc.util` compiler utils.
