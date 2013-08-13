picklebuffer-example
====================

Uses a PickleBuffer to read and write Scala signatures, towards the goal of figuring out how to write an arbitrary Scala signature.

Please see other branches for more examples.

----------------------------------------------------

In this example we:

1) Create a `PickleBuffer` and write arbitrary Scala Signatures for "simple" case classes, i.e. only basic datatypes. (TODO: collections, user-defined datatypes (i.e. other case classes as datatypes), user-defined methods?)

2) Read the bytes back out of the `PickleBuffer` using `ShowPickled` from `scala.tools.nsc.util` compiler utils to verify output.
