open class GitTesting() {
    //lateinit var vcsRootUrl: String
    constructor(init: GitTesting.() -> Unit) : this(){
        init()
    }

    internal fun getVcsRootUrl(): String
    {
        return "%vcsroot.url%";
    }

    internal fun getOwner(): String
    {
        if (getVcsRootUrl().indexOf("/") > -1) {
            return getVcsRootUrl().split("/")[3];
        }
        else
        {
            return "";
        }
    }

    internal fun getRepo(): String
    {
        if (getVcsRootUrl().indexOf('/') > -1) {
            return getVcsRootUrl().split('/')[4];
        }
        else
        {
            return "";
        }
    }

    internal fun getCounts(): Int {
        return getVcsRootUrl().split("/").count()
    }

    internal fun getFull(): String
    {
        return getVcsRootUrl();
    }
}