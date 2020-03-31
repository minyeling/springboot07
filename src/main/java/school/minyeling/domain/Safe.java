package school.minyeling.domain;

public class Safe {

    String FilterName;
    String RemoteHost;
    String RemoteAddr;

    public String getFilterName() {
        return FilterName;
    }

    public void setFilterName(String filterName) {
        FilterName = filterName;
    }

    public String getRemoteHost() {
        return RemoteHost;
    }

    public void setRemoteHost(String remoteHost) {
        RemoteHost = remoteHost;
    }

    public String getRemoteAddr() {
        return RemoteAddr;
    }

    public void setRemoteAddr(String remoteAddr) {
        RemoteAddr = remoteAddr;
    }

    @Override
    public String toString() {
        return "Safe{" +
                "FilterName='" + FilterName + '\'' +
                ", RemoteHost='" + RemoteHost + '\'' +
                ", RemoteAddr='" + RemoteAddr + '\'' +
                '}';
    }
}
