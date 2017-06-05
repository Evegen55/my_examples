package GoogleApiTests;

import com.google.api.core.ApiFuture;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.grpc.InstantiatingChannelProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.pubsub.spi.v1.Publisher;
import com.google.cloud.pubsub.spi.v1.TopicAdminClient;
import com.google.cloud.pubsub.spi.v1.TopicAdminSettings;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.TopicName;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * @author (created on 5/31/2017).
 */
public class PubSubQuickStart {

    public static void main(String... args) throws Exception {

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
        try (TopicAdminClient topicAdminClient = TopicAdminClient.create(topicAdminSettings)) {
            topicAdminClient.createTopic(topic);
            System.out.printf("Topic %s:%s created.\n", topic.getProject(), topic.getTopic(), topic);
        }

        //publish message in a topic
        final ApiFuture<String> stringApiFuture = publishMessageInTopic(topicAdminSettings, topic, "MESSAGE");


        //delete topic
        try (TopicAdminClient topicAdminClient = TopicAdminClient.create(topicAdminSettings)) {
            topicAdminClient.deleteTopic(topic);
            System.out.printf("Topic %s:%s deleted.\n", topic.getProject(), topic.getTopic(), topic);
        }


    }

    private static ApiFuture<String> publishMessageInTopic(final TopicAdminSettings topicAdminSettings, TopicName topic, String message) throws ExecutionException, InterruptedException {
        Publisher publisher = null;
        ApiFuture<String> messageIdFuture = null;
        try {
            publisher = Publisher.defaultBuilder(topic)
                    .setChannelProvider(topicAdminSettings.getChannelProvider())
                    //.setExecutorProvider(topicAdminSettings.getExecutorProvider())
                    .build();
            ByteString data = ByteString.copyFromUtf8(message);
            PubsubMessage pubsubMessage = PubsubMessage.newBuilder().setData(data).build();
            messageIdFuture = publisher.publish(pubsubMessage);

            System.out.println(messageIdFuture.isDone());
            System.out.println(messageIdFuture.get());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (publisher != null) {
                try {
                    publisher.shutdown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(messageIdFuture.isDone());
        System.out.println(messageIdFuture.get());

        return messageIdFuture;
    }

}
