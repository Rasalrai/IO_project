package pl.put.poznan.JSONtools.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.JSONtools.logic.*;

import java.nio.charset.StandardCharsets;
import java.util.Base64;


@RestController
public class TextTransformerController {

    private String decodeParam(String param) {
        return new String(Base64.getDecoder().decode(param), StandardCharsets.UTF_8);
    }

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);

    private final JSONMinifier jm = new JSONMinifier();
    private final JSONPrettifier jp = new JSONPrettifier();

    @RequestMapping(path = "/help", method = RequestMethod.GET, produces = "application/json")
    public String get_help() {

        // log the parameters
        logger.info("help");
        return jp.decorate("{\"Available\":{\"POST\":{\"/compare?left=file1&right=file2\":\"compare base64 encoded files\",\"/min\":\"minify the request body\",\"/pretty\":\"formats the request body for human-readability\"},\"GET\":{\"/help\":\"get help; you are here.\"}}}");
    }

    @RequestMapping(path = "/compare", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String compare(@RequestParam(value="left") String f1,
                          @RequestParam(value="right") String f2) {

        String j1 = decodeParam(f1);
        String j2 = decodeParam(f2);

        // log the parameters
        logger.info("compare");
        logger.debug(j1);
        logger.debug(j2+"\n\n");

        // perform the transformation, you should run your logic here, below is just a silly example
        JSONCompare jc = new JSONCompare(j1, j2);
        return jc.compare();
    }

    @RequestMapping(path = "/min", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String minify(@RequestBody String json) {

        // log the parameters
        logger.info("minify");
        logger.debug(json+"\n\n");

        return jm.decorate(json);
    }

    @RequestMapping(path = "/pretty", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String prettify(@RequestBody String json) {

        // log the parameters
        logger.info("prettify");
        logger.debug(json+"\n\n");

        return jp.decorate(json);
    }
}