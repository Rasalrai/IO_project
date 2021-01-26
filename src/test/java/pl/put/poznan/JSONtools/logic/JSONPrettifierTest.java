package pl.put.poznan.JSONtools.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JSONPrettifierTest {

    @Test
    void testDecorate() {
        JSONPrettifier jp = new JSONPrettifier();
        String s1 = "{\n" +
                "  \"menu\" : {\n" +
                "    \"id\" : \"file\",\n" +
                "    \"value\" : \"File\",\n" +
                "    \"popup\" : {\n" +
                "      \"menuitem\" : [ {\n" +
                "        \"value\" : \"New\",\n" +
                "        \"onclick\" : \"CreateNewDoc()\"\n" +
                "      }, {\n" +
                "        \"value\" : \"Open\",\n" +
                "        \"onclick\" : \"OpenDoc()\"\n" +
                "      }, {\n" +
                "        \"value\" : \"Close\",\n" +
                "        \"onclick\" : \"CloseDoc()\"\n" +
                "      } ]\n" +
                "    }\n" +
                "  }\n" +
                "}";
        String s2 = "{\"menu\":{\"id\":\"file\",\"value\":\"File\",\"popup\":{\"menuitem\":[{\"value\":\"New\",\"onclick\":\"CreateNewDoc()\"},{\"value\":\"Open\",\"onclick\":\"OpenDoc()\"},{\"value\":\"Close\",\"onclick\":\"CloseDoc()\"}]}}}";
        String res = jp.decorate(s2);
        int iCL = 13;
        char cCl = (char) iCL;
        String sCl = "";
        sCl += cCl;
        res = res.replaceAll(sCl,"");
        assertEquals(s1,res);
    }
}