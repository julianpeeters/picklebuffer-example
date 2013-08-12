picklebuffer-example
====================

Uses a PickleBuffer to read and write Scala signatures, towards the goal of figuring out how to write an arbitrary Scala signature.

Please see other branches for more examples.

----------------------------------------------------

In this example we:

1) Create a `PickleBuffer` and write the header and first entry(i.e. the CLASSsym)

2) Read the bytes back out of the `PickleBuffer` using `ShowPickled` from `scala.tools.nsc.util` compiler utils to interpret the output.

3) To interpret the output, compare it with the output from using using `ShowPickled` on a preexisting `PickleBuffer` that we'd like to mimic.
