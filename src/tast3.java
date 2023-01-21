import com.google.gson.*;

import java.io.*;



public class tast3 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: Need to attach two files");
            return;
        }
        String input_tests = args[0]; // the program accepts tests.json file
        String input_values = args[1]; // the program accepts values.json file

        JsonElement fileElementTests = null;
        try {
            fileElementTests = JsonParser.parseReader(new FileReader(input_tests));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        JsonObject fileObjectTests = fileElementTests.getAsJsonObject();

        JsonElement fileElementValues = null;
        try {
            fileElementValues = JsonParser.parseReader(new FileReader(input_values));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        JsonObject fileObjectValues = fileElementValues.getAsJsonObject();

        JsonArray arrayTests = fileObjectTests.get("tests").getAsJsonArray();
        JsonArray arrayValues = fileObjectValues.get("values").getAsJsonArray();

        for (JsonElement ValuesElement : arrayValues) {
            JsonObject ValuesObject = ValuesElement.getAsJsonObject();
            int id = ValuesObject.get("id").getAsInt();
            String value = ValuesObject.get("value").getAsString();
            
            for (JsonElement TestsElement : arrayTests) {
                JsonObject TestsObject = TestsElement.getAsJsonObject();
                int id1 = TestsObject.get("id").getAsInt();
                if (id == id1) {
                    TestsObject.addProperty("value", value);
                }

                if (TestsObject.has("values")) {
                    JsonArray arrayTests1 = TestsObject.get("values").getAsJsonArray();
                    for (JsonElement ValuesElement1 : arrayTests1) {
                        JsonObject ValuesObject1 = ValuesElement1.getAsJsonObject();
                        int id3 = ValuesObject1.get("id").getAsInt();
                        if (id == id3) {
                            ValuesObject1.addProperty("value", value);
                        }

                        if (ValuesObject1.has("values")) {
                            JsonArray arrayTests2 = ValuesObject1.get("values").getAsJsonArray();
                            for (JsonElement ValuesElement2 : arrayTests2) {
                                JsonObject ValuesObject2 = ValuesElement2.getAsJsonObject();
                                int id4 = ValuesObject2.get("id").getAsInt();
                                if (id == id4) {
                                    ValuesObject2.addProperty("value", value);
                                }

                                if (ValuesObject2.has("values")) {
                                    JsonArray arrayTests3 = ValuesObject2.get("values").getAsJsonArray();
                                    for (JsonElement ValuesElement3 : arrayTests3) {
                                        JsonObject ValuesObject3 = ValuesElement3.getAsJsonObject();
                                        int id5 = ValuesObject3.get("id").getAsInt();
                                        if (id == id5) {
                                            ValuesObject3.addProperty("value", value);
                                        }

                                        if (ValuesObject3.has("values")) {
                                            JsonArray arrayTests4 = ValuesObject3.get("values").getAsJsonArray();
                                            for (JsonElement ValuesElement4 : arrayTests4) {
                                                JsonObject ValuesObject4 = ValuesElement4.getAsJsonObject();
                                                int id6 = ValuesObject4.get("id").getAsInt();
                                                if (id == id6) {
                                                    ValuesObject4.addProperty("value", value);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        try (PrintWriter out = new PrintWriter(new FileWriter("report.json"))) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonString = gson.toJson(fileObjectTests);
            out.write(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}