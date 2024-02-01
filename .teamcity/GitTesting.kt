open class GitTesting() {
    lateinit var vcsRootUrl: String
    constructor(init: GitTesting.() -> Unit) : this(){
        init()
    }

    internal fun getOwner(): String
    {
            return vcsRootUrl.split("/")[3];
    }

    internal fun getRepo(): String
    {
            return vcsRootUrl.split("/")[4];
    }
}