package n2exercise1;

import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;

public class ObjectSerializer {
    public static void serializeToJson(Object object, String directory) throws IOException {
        JSONObject jsonObject = new JSONObject(object);
        String json = jsonObject.toString();

        try (FileWriter writer = new FileWriter(directory)) {
            writer.write(json);
        } catch (IOException e) {
            throw new IOException("Error writing to file: " + e.getMessage());
        }
    }
}
