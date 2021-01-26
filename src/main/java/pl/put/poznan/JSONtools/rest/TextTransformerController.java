package pl.put.poznan.JSONtools.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.JSONtools.logic.*;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;


/**
 * class TextTransformerController
 * Responsible for receiving HTTP requests, executing the requested methods and sending responses back.
 */
@RestController
public class TextTransformerController {

    private String decodeParam(String param) {
        return new String(Base64.getDecoder().decode(param), StandardCharsets.UTF_8);
    }

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);

    /**
     * Minifier object used for processing the requests.
     */
    public JSONMinifier jm = new JSONMinifier();
    /**
     * Prettifier object used for processing the requests (e.g. formatting the help page).
     */
    public JSONPrettifier jp = new JSONPrettifier();

    /**
     * Help method for the API
     * @return short help JSON with all the available commands listed.
     */
    @RequestMapping(path = "/help", method = RequestMethod.GET, produces = "application/json")
    public String get_help() {

        // log the parameters
        logger.info("help");
        return jp.decorate("{\"Available\":{\"POST\":{\"/compare?left=file1&right=file2\":\"compare base64 encoded files\",\"/min\":\"minify the request body\",\"/pretty\":\"formats the request body for human-readability\"},\"GET\":{\"/help\":\"get help; you are here.\",\"/choose\":\"get only specified entries\",\"/remove\":\"remove specified entries\"}}}");
    }

    /**
     * Method calling JSONCompare
     * @param f1 the first ("left") JSON to compare, encoded in base64
     * @param f2 the second ("right") JSON to compare, encoded in base64
     * @return differences between f1 and f2
     */
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

    /**
     * Method calling JSONMinifier's decorate
     * @param json JSON structure that needs to be minified
     * @return JSON passed as the parameter, but with all unnecessary whitespaces removed
     */
    @RequestMapping(path = "/min", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String minify(@RequestBody String json) {

        // log the parameters
        logger.info("minify");
        logger.debug(json+"\n\n");

        return jm.decorate(json);
    }

    /**
     * Method calling JSONPrettifier's decorate
     * @param json JSON structure that needs to be formatted
     * @return JSON passed as the parameter, but nicely formatted for human readability.
     */
    @RequestMapping(path = "/pretty", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String prettify(@RequestBody String json) {

        // log the parameters
        logger.info("prettify");
        logger.debug(json+"\n\n");

        return jp.decorate(json);
    }

    /**
     * Processes a JSON file, leaving only the specified fields
     * @param fields names of fields that are to stay
     * @param json string with JSON file for processing
     * @return the JSON string, with all but specified fields removed.
     */
    @RequestMapping(path = "/choose", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String choose(@RequestParam(value="fields") String fields,
                         @RequestBody String json) {
        Collection<String> field_names = Arrays.asList(fields.split(","));

        JSONChooser jc = new JSONChooser(field_names);
        return jc.decorate(json);
    }

    /**
     * Processes a JSON file, removing specified fields
     * @param fields names of fields that are to be removed
     * @param json string with JSON file for processing
     * @return the JSON file string, with specified fields removed.
     */
    @RequestMapping(path = "/remove", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String remove(@RequestParam(value="fields") String fields,
                         @RequestBody String json) {
        Collection<String> field_names = Arrays.asList(fields.split(","));
        System.out.println(field_names);

        JSONRemover jr = new JSONRemover(field_names);
        return jr.decorate(json);
    }

}
