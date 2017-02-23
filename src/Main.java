import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("kittens.in"));
        long videosCount = scanner.nextLong();
        long endpointsCount = scanner.nextLong();
        long requestsCount = scanner.nextLong();
        long cashesCount = scanner.nextLong();
        long cachesSizes = scanner.nextLong();

        InputData inputData = new InputData();

        inputData.cacheCapasity = cachesSizes;
        inputData.cachesCount = cashesCount;

        for (int i = 0; i < cashesCount; ++i) {
            InputData.Cashe cashe = new InputData.Cashe();
            cashe.index = i;
            cashe.freeSize = cachesSizes;
            inputData.cashes.add(cashe);
        }

        for (long i = 0; i < videosCount; ++i) {
            InputData.Video video = new InputData.Video();
            video.index = i;
            video.size = scanner.nextLong();
            inputData.videos.add(video);
        }

        for (long i = 0; i < endpointsCount; ++i) {
            long serverLathency = scanner.nextLong();
            long connectedCachesCount = scanner.nextLong();
            InputData.Endpoint endpoint = new InputData.Endpoint();
            endpoint.serverLathency = serverLathency;
            for (long j = 0; j < connectedCachesCount; ++j) {
                InputData.CasheServerConnection casheServerConnection = new InputData.CasheServerConnection();
                casheServerConnection.cacheServerIndex = scanner.nextLong();
                casheServerConnection.lathency = scanner.nextLong();
                endpoint.casheServerConnection.add(casheServerConnection);
            }
            endpoint.index = i;
            inputData.endpoints.add(endpoint);
        }

        for (long i = 0; i < requestsCount; ++i) {
            long videoIndex = scanner.nextLong();
            long endpointIndex = scanner.nextLong();
            long videoRequestsCount = scanner.nextLong();
            InputData.EndpointRequest endpointRequest = new InputData.EndpointRequest();
            endpointRequest.video = inputData.videos.get((int) videoIndex);
            endpointRequest.endpoint = inputData.endpoints.get((int) endpointIndex);
            endpointRequest.count = videoRequestsCount;
            inputData.endpointRequests.add(endpointRequest);
        }
    }
}
