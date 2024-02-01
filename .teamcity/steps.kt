
import jetbrains.buildServer.configs.kotlin.BuildType
import jetbrains.buildServer.configs.kotlin.DslContext
import jetbrains.buildServer.configs.kotlin.buildSteps.script

object CommonSteps {

    fun BuildType.createParameters(
    ) {
        params {
            param("teamcity.pullRequest.number", "")
            param("teamcity.git.fetchAllHeads", "true")
        }
    }

    fun BuildType.printPullRequestNumber(
    ) {
        steps {
            script {
                name = "Print Pull Request Number teamcity-sonar"
                scriptContent = """
                #!/bin/bash
                id=%teamcity.pullRequest.number%
                echo "Id is: ${'$'}id"
                branch="pull/${'$'}id"
                echo "Branch is: ${'$'}branch"
            """.trimIndent()
            }
        }
    }

    fun BuildType.printDeployNumber(bts: BuildType, gts: GitTesting
    ) {
//        echo "Owner: ${gts.getOwner()}"
//        echo "Repo: ${gts.getRepo()}"

        var xyz = "NOT SET"

        val vcsRoot = bts.params.findRawParam("vcsroot.url")
        if (vcsRoot != null && vcsRoot.value.isNotBlank()) {
            xyz = vcsRoot.value
        }

        steps {
            script {
                name = "Print Deploy Number teamcity-sonar"
                scriptContent = """
                #!/bin/bash
                echo "Running deployment"
                counter=%build.counter%
                echo "Counter is: ${'$'}counter"
            """.trimIndent()
            }
            script {
                name = "Print Git"
                scriptContent = """
                #!/bin/bash
                echo "DslContext: ${DslContext.getParameter("vcsroot.url", "NOT SET")}"
                echo "System: ${System.getProperty("vcsroot.url", "NOT SET")}"
                //echo "XYZ: $xyz"
                echo "Owner: ${gts.getOwner()}"
                echo "Repo: ${gts.getRepo()}"
            """.trimIndent()
            }
        }
    }

}
