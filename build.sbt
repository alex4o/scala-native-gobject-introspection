
scalaVersion := "2.11.12"

// Set to false or remove if you want to show stubs as linking errors
nativeLinkStubs := true
libraryDependencies += "org.scalameta" %% "scalameta_native0.3" % "4.0.0-M2"

resolvers += Resolver.sonatypeRepo("releases")
//nativeLinkingOptions := Seq("-flto")



addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)
enablePlugins(ScalaNativePlugin)
