package pl.put.poznan.JSONtools.app;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.put.poznan.JSONtools.logic.JSONCompare;


@SpringBootApplication(scanBasePackages = {"pl.put.poznan.transformer.rest"})
public class TextTransformerApplication {
    public static void main(String[] args) {
        //SpringApplication.run(TextTransformerApplication.class, args);
        //JSONDecorator jsonDecorator = new JSONMinifier();
        //JSONDecorator jsonDecorator1 = new JSONPrettifier();
        String json = "{\n" +
                "  \"wool\": 401733047,\n" +
                "  \"age\": {\n" +
                "    \"toy\": \"similar\",\n" +
                "    \"heart\": [\n" +
                "      false,\n" +
                "      1795333437,\n" +
                "      827997007.9677138,\n" +
                "      false,\n" +
                "      \"grass\",\n" +
                "      -704005095.9028239\n" +
                "    ],\n" +
                "    \"cream\": 1330371826.8983521,\n" +
                "    \"parallel\": 2041370698,\n" +
                "    \"consist\": false,\n" +
                "    \"father\": true\n" +
                "  },\n" +
                "  \"lucky\": true,\n" +
                "  \"cold\": false,\n" +
                "  \"general\": \"mission\",\n" +
                "  \"final\": false\n" +
                "}";
        String json1 = "{\n" +
                "  \"age\": {\n" +
                "    \"toy\": \"similar\",\n" +
                "    \"heart\": [\n" +
                "      false,\n" +
                "      1795333437,\n" +
                "      827997007.9677138,\n" +
                "      false,\n" +
                "      \"grass\",\n" +
                "      -704005095.9028239\n" +
                "    ],\n" +
                "    \"cream\": 1330371826.8983521,\n" +
                "    \"parallel\": 2041370698,\n" +
                "    \"consist\": false,\n" +
                "    \"father\": true\n" +
                "  },\n" +
                "  \"lucky\": true,\n" +
                "  \"cold\": false,\n" +
                "  \"general\": \"mission\",\n" +
                "  \"final\": false\n" +
                "}";
        JSONCompare jsonCompare = new JSONCompare(json, json1);
        String file = jsonCompare.compare();
        System.out.println(file);
    }
}
