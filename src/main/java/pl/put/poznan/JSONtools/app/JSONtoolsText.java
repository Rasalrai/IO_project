package pl.put.poznan.JSONtools.app;

import org.slf4j.LoggerFactory;
import pl.put.poznan.JSONtools.logic.JSONCompare;
import pl.put.poznan.JSONtools.rest.TextTransformerController;

import java.util.logging.Logger;


public class JSONtoolsText {
    public static void main(String[] args) {
        TextTransformerController text = new TextTransformerController();
        String s1 = "{\"Available\":{\"POST\":{\"/compare?left=file1&right=file2\":\"compare base64 encoded files\",\"/min\":\"minify the request body\",\"/pretty\":\"formats the request body for human-readability\"},\"GET\":{\"/help\":\"get help; you are here.\"}}}";
        String s2 = "{\"Available\":{\"POST\":{\"/compare?left=file1&right=file2\":\"compare base64 encoded files\",\"/pretty\":\"formats the request body for human-readability\"},\"GET\":{\"/help\":\"get help; you are here.\"}}}";
        String hlp = "{\"Available\":{\"POST\":{\"/compare?left=file1&right=file2\":\"compare base64 encoded files\",\"/min\":\"minify the request body\",\"/pretty\":\"formats the request body for human-readability\"},\"GET\":{\"/help\":\"get help; you are here.\"}}}";
        String res = text.compare("tak","nie");
        //JSONCompare jc = new JSONCompare(s1, s2);
        //String res = jc.compare();
        System.out.println("result:");
        System.out.println("|"+res+"|");
    }
}
