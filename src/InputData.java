import java.util.ArrayList;
import java.util.List;

public class InputData {


    List<Video> videos = new ArrayList<>();
    List<Endpoint> endpoints = new ArrayList<>();
    List<EndpointRequest> endpointRequests = new ArrayList<>();


    static class Endpoint {
        long serverLathency;
        List<CasheServerConnection> casheServerConnection = new ArrayList<>();
        List<EndpointRequest> requests;
    }

    static class CasheServerConnection {
        long cacheServerIndex;
        long lathency;
    }

    static class Video {
        long index;
        long size;
    }

    static class EndpointRequest {
        long count;
        Video video;
        Endpoint endpoint;
    }
}
