
import jetbrains.buildServer.configs.kotlin.BuildType
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

    fun BuildType.printDeployNumber(
    ) {
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
        }
    }

}