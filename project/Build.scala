import sbt._
import Keys._
import play.Project._
import com.typesafe.sbt.SbtAtmos.{ atmosSettings, traceAkka }

object ApplicationBuild extends Build {

    val appName         = "helloworld"
    val appVersion      = "1.0"

    val appDependencies = Seq(
      javaCore
    )

    val main = play.Project(appName, appVersion, appDependencies).settings(
      // Add your own project settings here
    ).settings(traceSettings: _*)

    def traceSettings = atmosSettings ++ Seq(traceAkka("2.1.4"))
}
