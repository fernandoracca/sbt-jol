# sbt-jol

Use OpenJDK's [*Java Object Layout*](https://github.com/openjdk/jol) within your SBT project and determine object sizes.

Get the latest via:

 ```
 // project/plugins.sbt
 addSbtPlugin("com.github.fernandoracca" % "sbt-jol" % pluginVersionHere)
 ```
 
 Which allows you to inspect classes within SBT 

[!TIP] Auto-completion works nicely
 
 ```
 > jol:internals example.Entry
 
[info] # Running 64-bit HotSpot VM.
[info] # Using compressed oop with 3-bit shift.
[info] # Using compressed klass with 3-bit shift.
[info] # WARNING | Compressed references base/shifts are guessed by the experiment!
[info] # WARNING | Therefore, computed addresses are just guesses, and ARE NOT RELIABLE.
[info] # WARNING | Make sure to attach Serviceability Agent to get the reliable addresses.
[info] # Objects are 8 bytes aligned.
[info] # Field sizes by type: 4, 1, 1, 2, 2, 4, 4, 8, 8 [bytes]
[info] # Array element sizes: 4, 1, 1, 2, 2, 4, 4, 8, 8 [bytes]
[info]
[info] VM fails to invoke the default constructor, falling back to class-only introspection.
[info]
[info] example.Entry object internals:
[info]  OFFSET  SIZE   TYPE DESCRIPTION                    VALUE
[info]       0    12        (object header)                N/A
[info]      12     4    int Entry.value                    N/A
[info]      16     4 String Entry.key                      N/A
[info]      20     4        (loss due to the next object alignment)
[info] Instance size: 24 bytes
[info] Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
 ```

  Currently uses jol `0.17`




Contribute!
-----------

Original Plugin was written by [Konrad "ktoso" Malawski](https://github.com/ktoso/sbt-jol), to whom credit should go towards. 
I've decided to fork and lightly maintain this since it's a useful tool. Contributions welcomed, however, it's not a high priority project!


The example above runs as follows. 

First, build the plugin, run

```
> scripted
```

Then, 

```
cd sbt-jol/src/sbt-test/sbt-jol/estimates
sbt -Dproject.version=0.3.0-SNAPSHOT
```




License
-------
 
Apache v2
