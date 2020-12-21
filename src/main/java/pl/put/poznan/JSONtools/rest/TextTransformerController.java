package pl.put.poznan.JSONtools.rest;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.JSONtools.logic.*;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;


@RestController
@RequestMapping("/{text}")
public class TextTransformerController {

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String get(@PathVariable String text,
                          @RequestParam(value="f1") String f1,
                          @RequestParam(value="f2") String f2) {

        String j1 = new String(Base64.getDecoder().decode(f1), StandardCharsets.UTF_8);
        String j2 = new String(Base64.getDecoder().decode(f2), StandardCharsets.UTF_8);

        // log the parameters
        logger.debug(text);
        logger.debug(j1);
        logger.debug(j2);

        // perform the transformation, you should run your logic here, below is just a silly example
        JSONCompare jc = new JSONCompare(j1, j2);
        return jc.compare();
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String post(@PathVariable String text,
                       @RequestBody String transforms) {

        // log the parameters
        logger.debug(text);
        logger.debug(transforms);
//        logger.debug(Arrays.toString(transforms));

        JSONPrettifier jm = new JSONPrettifier();
        transforms = jm.decorate(transforms);
        return transforms;
    }

}


