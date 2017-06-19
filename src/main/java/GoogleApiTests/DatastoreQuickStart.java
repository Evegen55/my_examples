package GoogleApiTests;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;

/**
 * @author (created on 6/16/2017).
 */
public class DatastoreQuickStart {

    private static final String projectID = "sound-invention-158813";
    private static final String NAMESPACE = "google_cloud_example";


    public static void main(String... args) throws Exception {
        // Instantiates a client
        //Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
        final GoogleCredentials googleCredentials = GoogleCredentials
                .fromStream(DatastoreQuickStart.class.getClassLoader().getResourceAsStream("My Project-504e19426008.json"));
        System.out.println(googleCredentials);
        DatastoreOptions options =
                DatastoreOptions.newBuilder()
                        .setProjectId(projectID)
                        .setCredentials(googleCredentials)
                        .setNamespace(NAMESPACE)
                        .build();

        final Datastore datastore = options.getService();

        // The kind for the new entity
        String kind = "Task";
        // The name/ID for the new entity
        String name = "sampletask1";
        // The Cloud Datastore key for the new entity
        Key taskKey = datastore.newKeyFactory().setKind(kind).newKey(name);

        // Prepares the new entity
        Entity task = Entity.newBuilder(taskKey)
                .set("description", "Buy milk")
                .build();

        // Saves the entity
        datastore.put(task);

        System.out.printf("Saved %s: %s%n", task.getKey().getName(), task.getString("description"));

        //Retrieve entity
        Entity retrieved = datastore.get(taskKey);

        System.out.printf("Retrieved %s: %s%n", taskKey.getName(), retrieved.getString("description"));

    }
}
