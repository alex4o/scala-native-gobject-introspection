# GObject introspection library for scala-native

Dependancies: 
- girepository-2.0.so to introspect the GObject libraries
- and scala.meta to generate source code 

At the moment the program can be used to create bindings for itself, but needs some work to generate fully working bindings that look like native classes, and are useffull for actual projects.

It is possible to parse gir files directly, but they are inconsistent, so in the future it might be easyer to just use libvala's girparser to generate better bindings.
