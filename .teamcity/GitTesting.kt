open class GitTesting() {
    lateinit var vcsRootUrl: String
    constructor(init: GitTesting.() -> Unit) : this(){
        init()
    }

    internal fun getOwner(): String
    {
        if (vcsRootUrl.indexOf('/') > -1) {
            return vcsRootUrl.split('/')[3];
        }
        else
        {
            return "";
        }
    }

    internal fun getRepo(): String
    {
        if (vcsRootUrl.indexOf('/') > -1) {
            return vcsRootUrl.split('/')[4];
        }
        else
        {
            return "";
        }
    }

    internal fun getFull(): String
    {
        return vcsRootUrl;
    }
}