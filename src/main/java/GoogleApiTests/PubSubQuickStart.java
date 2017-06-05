package GoogleApiTests;

import com.google.api.core.ApiFuture;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.grpc.InstantiatingChannelProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.pubsub.spi.v1.AckReplyConsumer;
import com.google.cloud.pubsub.spi.v1.MessageReceiver;
import com.google.cloud.pubsub.spi.v1.Publisher;
import com.google.cloud.pubsub.spi.v1.Subscriber;
import com.google.cloud.pubsub.spi.v1.SubscriptionAdminClient;
import com.google.cloud.pubsub.spi.v1.SubscriptionAdminSettings;
import com.google.cloud.pubsub.spi.v1.TopicAdminClient;
import com.google.cloud.pubsub.spi.v1.TopicAdminSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.PushConfig;
import com.google.pubsub.v1.Subscription;
import com.google.pubsub.v1.SubscriptionName;
import com.google.pubsub.v1.TopicName;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * @author (created on 5/31/2017).
 */
public class PubSubQuickStart {

    /**
     * Scope of core functionality
     *
     * @param args
     * @throws Exception
     */
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

        //in order to shutting down an exception you should uncomment it
//        catch(com.google.api.gax.grpc.ApiException e) {
//            System.out.println("Catched : io.grpc.StatusRuntimeException: ALREADY_EXISTS: Resource already exists in the project (resource=my-new-topic)");
//        }

        //publish message in a topic
        final ApiFuture<String> stringApiFuture = publishMessageInTopic(topicAdminSettings, topic, "MESSAGE");

        //create subscription. It needs SubscriptionAdminSettings
        SubscriptionAdminSettings subscriptionAdminSettings = SubscriptionAdminSettings
                .defaultBuilder()
                .setChannelProvider(channelProvider)
                .build();
        final Subscription subscription = createSubscription(topic, subscriptionAdminSettings, projectId);
        System.out.println(subscription);

        //delete topic
        try (TopicAdminClient topicAdminClient = TopicAdminClient.create(topicAdminSettings)) {
            topicAdminClient.deleteTopic(topic);
            System.out.printf("Topic %s:%s deleted.\n", topic.getProject(), topic.getTopic(), topic);
        }

        //delete subscription
        deleteSubscription(subscriptionAdminSettings, projectId);


    }

    /**
     * @param topicAdminSettings
     * @param topic
     * @param message
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static ApiFuture<String> publishMessageInTopic(final TopicAdminSettings topicAdminSettings, final TopicName topic, String message) throws ExecutionException, InterruptedException {
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

    /**
     * @param topic
     * @param subscriptionAdminSettings
     * @param projectId
     * @return
     */
    public static Subscription createSubscription(final TopicName topic, final SubscriptionAdminSettings subscriptionAdminSettings, final String projectId) {
        final SubscriptionName subscription = SubscriptionName.create(projectId, "test-subscription");
        try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create(subscriptionAdminSettings)) {
            return subscriptionAdminClient.createSubscription(subscription, topic, PushConfig.getDefaultInstance(), 0);
        } catch (com.google.api.gax.grpc.ApiException e) {
            System.out.println("Catching when created subscription : " +
                    "io.grpc.StatusRuntimeException: ALREADY_EXISTS: " +
                    "Resource already exists in the project (resource=my-new-topic)");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * @param subscriptionAdminSettings
     * @param projectId
     */
    public static void deleteSubscription(final SubscriptionAdminSettings subscriptionAdminSettings, final String projectId) {
        final SubscriptionName subscription = SubscriptionName.create(projectId, "test-subscription");
        try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create(subscriptionAdminSettings)) {
            subscriptionAdminClient.deleteSubscription(subscription);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * @param subscriptionName
     */
    public static void pull(SubscriptionName subscriptionName) {
        MessageReceiver receiver =
                new MessageReceiver() {
                    @Override
                    public void receiveMessage(PubsubMessage message, AckReplyConsumer consumer) {
                        System.out.println("got message: " + message.getData().toStringUtf8());
                        consumer.ack();
                    }
                };
        Subscriber subscriber = null;
        try {
            subscriber = Subscriber.defaultBuilder(subscriptionName, receiver).build();
            subscriber.addListener(
                    new Subscriber.Listener() {
                        @Override
                        public void failed(Subscriber.State from, Throwable failure) {
                            // Handle failure. This is called when the Subscriber encountered a fatal error and is shutting down.
                            System.err.println(failure);
                        }
                    },
                    MoreExecutors.directExecutor());
            subscriber.startAsync().awaitRunning();
        } finally {
            if (subscriber != null) {
                subscriber.stopAsync();
            }
        }
    }

}
