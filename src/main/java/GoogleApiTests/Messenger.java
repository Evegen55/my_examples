package GoogleApiTests;

import com.google.api.core.ApiFuture;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.grpc.InstantiatingChannelProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.pubsub.spi.v1.TopicAdminSettings;
import com.google.pubsub.v1.TopicName;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static GoogleApiTests.PubSubQuickStart.publishMessageInTopic;

/**
 * @author (created on 6/5/2017).
 */
public class Messenger {


    public static void main(String[] args) throws Exception {

        //first, start application
        new Thread(() -> {
            try {
                PubSubQuickStart.main(args);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(10000);
        // Your Google Cloud Platform project ID
        String projectId = "sound-invention-158813";

        // Your topic ID
        String topicId = "my-new-topic";

        final GoogleCredentials googleCredentials = GoogleCredentials
                .fromStream(PubSubQuickStart.class.getClassLoader().getResourceAsStream("My Project-504e19426008.json"));
        System.out.println(googleCredentials);

        final InstantiatingChannelProvider channelProvider = TopicAdminSettings
                .defaultChannelProviderBuilder()
                .setCredentialsProvider(FixedCredentialsProvider.create(googleCredentials))
                .build();

        System.out.println(channelProvider.getEndpoint());

        final TopicAdminSettings topicAdminSettings = TopicAdminSettings
                .defaultBuilder()
                .setChannelProvider(channelProvider)
                .build();

        // Create a new topic
        TopicName topic = TopicName.create(projectId, topicId);
        //publish message in a topic
        final ApiFuture<String> stringApiFuture = publishMessageInTopic(topicAdminSettings, topic, "MESSAGE FROM OTHER CLASS");

        //publish list of messages
        List<String> list = new ArrayList<>();
        Files.lines(Paths.get("src\\test\\resources\\example.txt")).forEach(list::add);
        list.stream().forEach(line -> {
            try {
                if (!line.isEmpty()) {
                    publishMessageInTopic(topicAdminSettings, topic, line);
                }
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
