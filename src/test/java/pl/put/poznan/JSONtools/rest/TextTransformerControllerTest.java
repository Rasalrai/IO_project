package pl.put.poznan.JSONtools.rest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import pl.put.poznan.JSONtools.logic.JSONMinifier;
import pl.put.poznan.JSONtools.logic.JSONPrettifier;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TextTransformerControllerTest {


    @Test
    void testMinify1() {
        TextTransformerController tr = new TextTransformerController();
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
        assertEquals(tr.minify(s1),s2);
    }

    @Test
    void testMinify2() {
        TextTransformerController tr = new TextTransformerController();
        String s1 = "{\n" +
                "  \"menu\" : {\n" +
                "    \"id\" : \"file\",\n" +
                "    \"value\" : \"File\",\n" +
                "    \"popup\" : {\n" +
                "      \"menuitem\" : [ {\n" +
                "        \"value\" : \"Open\",\n" +
                "        \"onclick\" : \"OpenDoc()\"\n" +
                "      } ]\n" +
                "    }\n" +
                "  }\n" +
                "}";
        String s2 = "{\"menu\":{\"id\":\"file\",\"value\":\"File\",\"popup\":{\"menuitem\":[{\"value\":\"Open\",\"onclick\":\"OpenDoc()\"}]}}}";
        String hlp = tr.get_help();
        assertEquals(tr.minify(s1),s2);
    }

    @Test
    void testMinify3() {
        TextTransformerController tr = new TextTransformerController();
        String s1 = "{\n" +
                "  \"menu\" : {\n" +
                "    \"id\" : \"file\",\n" +
                "    \"popup\" : {\n" +
                "      \"menuitem\" : [ {\n" +
                "        \"value\" : \"Open\"\n" +
                "      } ]\n" +
                "    }\n" +
                "  }\n" +
                "}";
        String s2 = "{\"menu\":{\"id\":\"file\",\"popup\":{\"menuitem\":[{\"value\":\"Open\"}]}}}";
        String hlp = tr.get_help();
        assertEquals(tr.minify(s1),s2);
        assertEquals(hlp,tr.get_help());
    }

    @Test
    void testPrettify1() {
        TextTransformerController tr = new TextTransformerController();
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
        String res = tr.prettify(s2);
        int iCL = 13;
        char cCl = (char) iCL;
        String sCl = "";
        sCl += cCl;
        res = res.replaceAll(sCl,"");
        assertEquals(s1,res);
    }

    @Test
    void testPrettify2() {
        TextTransformerController tr = new TextTransformerController();
        String s1 = "{\n" +
                "  \"menu\" : {\n" +
                "    \"id\" : \"file\",\n" +
                "    \"value\" : \"File\",\n" +
                "    \"popup\" : {\n" +
                "      \"menuitem\" : [ {\n" +
                "        \"value\" : \"Open\",\n" +
                "        \"onclick\" : \"OpenDoc()\"\n" +
                "      } ]\n" +
                "    }\n" +
                "  }\n" +
                "}";
        String s2 = "{\"menu\":{\"id\":\"file\",\"value\":\"File\",\"popup\":{\"menuitem\":[{\"value\":\"Open\",\"onclick\":\"OpenDoc()\"}]}}}";
        String hlp = tr.get_help();
        String res = tr.prettify(s2);
        int iCL = 13;
        char cCl = (char) iCL;
        String sCl = "";
        sCl += cCl;
        res = res.replaceAll(sCl,"");
        assertEquals(s1,res);
    }

    @Test
    void testPrettify3() {
        TextTransformerController tr = new TextTransformerController();
        String s1 = "{\n" +
                "  \"menu\" : {\n" +
                "    \"id\" : \"file\",\n" +
                "    \"popup\" : {\n" +
                "      \"menuitem\" : [ {\n" +
                "        \"value\" : \"Open\"\n" +
                "      } ]\n" +
                "    }\n" +
                "  }\n" +
                "}";
        String s2 = "{\"menu\":{\"id\":\"file\",\"popup\":{\"menuitem\":[{\"value\":\"Open\"}]}}}";
        String hlp = tr.get_help();
        String res = tr.prettify(s2);
        int iCL = 13;
        char cCl = (char) iCL;
        String sCl = "";
        sCl += cCl;
        res = res.replaceAll(sCl,"");
        assertEquals(s1,res);
        assertEquals(hlp,tr.get_help());
    }

    @Test
    void testMiniPrettyfied() {
        TextTransformerController tr = new TextTransformerController();
        String s1 = "{\"menu\":{\"id\":\"file\",\"value\":\"File\",\"popup\":{\"menuitem\":[{\"value\":\"New\",\"onclick\":\"CreateNewDoc()\"},{\"value\":\"Open\",\"onclick\":\"OpenDoc()\"},{\"value\":\"Close\",\"onclick\":\"CloseDoc()\"}]}}}";
        String res1 = tr.prettify(s1);
        String res2 = tr.minify(res1);
        assertEquals(s1,res2);
    }

    @Test
    void testPrettyMinified() {
        TextTransformerController tr = new TextTransformerController();
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
        String res1 = tr.minify(s1);
        String res2 = tr.prettify(res1);
        int iCL = 13;
        char cCl = (char) iCL;
        String sCl = "";
        sCl += cCl;
        res2 = res2.replaceAll(sCl,"");
        assertEquals(s1,res2);
    }

    @Test
    void testMiniMinified() {
        TextTransformerController tr = new TextTransformerController();
        String s1 = "{\"menu\":{\"id\":\"file\",\"value\":\"File\",\"popup\":{\"menuitem\":[{\"value\":\"New\",\"onclick\":\"CreateNewDoc()\"},{\"value\":\"Open\",\"onclick\":\"OpenDoc()\"},{\"value\":\"Close\",\"onclick\":\"CloseDoc()\"}]}}}";
        String res1 = tr.minify(s1);
        String res2 = tr.minify(res1);
        assertEquals(s1,res2);
    }

    @Test
    void testPrettyPrettyfied() {
        TextTransformerController tr = new TextTransformerController();
        String s1 = "{\n" +
                "  \"menu\" : {\n" +
                "    \"id\" : \"file\",\n" +
                "    \"popup\" : {\n" +
                "      \"menuitem\" : [ {\n" +
                "        \"value\" : \"Open\"\n" +
                "      } ]\n" +
                "    }\n" +
                "  }\n" +
                "}";
        String res1 = tr.prettify(s1);
        String res2 = tr.prettify(res1);
        int iCL = 13;
        char cCl = (char) iCL;
        String sCl = "";
        sCl += cCl;
        res2 = res2.replaceAll(sCl,"");
        assertEquals(s1,res2);
    }

    @Test
    void testGet_help() {
        TextTransformerController tr = new TextTransformerController();
        String help_text = "{\n" +
                "  \"Available\" : {\n" +
                "    \"POST\" : {\n" +
                "      \"/compare?left=file1&right=file2\" : \"compare base64 encoded files\",\n" +
                "      \"/min\" : \"minify the request body\",\n" +
                "      \"/pretty\" : \"formats the request body for human-readability\"\n" +
                "    },\n" +
                "    \"GET\" : {\n" +
                "      \"/help\" : \"get help; you are here.\",\n" +
                "      \"/choose\" : \"get only specified entries\",\n" +
                "      \"/remove\" : \"remove specified entries\"\n" +
                "    }\n" +
                "  }\n" +
                "}";
        assertEquals(help_text, tr.get_help());
    }

    @Test
    void testDecodeUnicode() {
        TextTransformerController tr = new TextTransformerController();

        String encoded1 = "eyJ6YcW8w7PFgsSHIjogImfEmcWbbMSFIGphxbrFhCJ9";
        String encoded2 = "eyLwn46uIjogIvCfjI0iLCAiemHFvMOzxYLEhyI6ICJnxJnFm2zEhSBqYcW6xYQifQ==";

        String resp = "not equal: only on right={\uD83C\uDFAE=\uD83C\uDF0D}";

        assertEquals(tr.compare(encoded1, encoded2), resp);
    }

    @Test
    void testCompareNums() {
        TextTransformerController tr = new TextTransformerController();

        String encoded1 = "eyJsb3JlbSI6ICJpcHN1bSIsICJkb2xvciI6IDU1fQ==";
        String encoded2 = "eyJsb3JlbSI6ICJpcHN1bSIsICJkb2xvciI6IDEzfQ==";

        String resp = "not equal: value differences={dolor=(55.0, 13.0)}";

        assertEquals(tr.compare(encoded1, encoded2), resp);
    }

    @Test
    void testChoose() {
        TextTransformerController tr = new TextTransformerController();

        String full = "{\n" +
                "    \"entryId\": \"b29ed77a-b447-4fd8-ae6a-8c5180724cd7\",\"id\": \"8556155a-25f2-4295-a864-043d31ac7bdd\",\n" +
                "    \"isSensitive\": false,\"lastModifiedTimestamp\":\n" +
                "    \n" +
                "    \n" +
                "    1607016821000,\n" +
                "            \"lock\": {\"isLocked\": false},\n" +
                "    \"name\": \"Barry Wilkinson - Układy cyfrowe (1).pdf\",\n" +
                "    \"path\": \"/Shared/Julia ⨊ ૱/Barry Wilkinson - Układy cyfrowe (1).pdf\",\"permission\": \"Full\",\n" +
                "    \"size\": 130399044,\"snapshot\": false, \"type\": \"file\"\n" +
                "}\n";

        String field_names = "isLocked,entryId,lastModifiedTimestamp";

        String expected = "{\"entryId\":\"b29ed77a-b447-4fd8-ae6a-8c5180724cd7\",\"lastModifiedTimestamp\":1607016821000}";

        assertEquals(tr.choose(field_names, full), expected);
    }

    @Test
    void testRemove() {
        TextTransformerController tr = new TextTransformerController();

        String full = "{\n" +
                "    \"entryId\": \"b29ed77a-b447-4fd8-ae6a-8c5180724cd7\",\"id\": \"8556155a-25f2-4295-a864-043d31ac7bdd\",\n" +
                "    \"isSensitive\": false,\"lastModifiedTimestamp\":\n" +
                "    \n" +
                "    \n" +
                "    1607016821000,\n" +
                "            \"lock\": {\"isLocked\": false},\n" +
                "    \"name\": \"Barry Wilkinson - Układy cyfrowe (1).pdf\",\n" +
                "    \"path\": \"/Shared/Julia ⨊ ૱/Barry Wilkinson - Układy cyfrowe (1).pdf\",\"permission\": \"Full\",\n" +
                "    \"size\": 130399044,\"snapshot\": false, \"type\": \"file\"\n" +
                "}\n";

        String field_names = "isLocked,entryId,lastModifiedTimestamp";


        String expected = "{\"id\":\"8556155a-25f2-4295-a864-043d31ac7bdd\",\"isSensitive\":false,\"lock\":{\"isLocked\":false},\"name\":\"Barry Wilkinson - Układy cyfrowe (1).pdf\",\"path\":\"/Shared/Julia ⨊ ૱/Barry Wilkinson - Układy cyfrowe (1).pdf\",\"permission\":\"Full\",\"size\":130399044,\"snapshot\":false,\"type\":\"file\"}";

        assertEquals(tr.remove(field_names, full), expected);
    }

    @Test
    void testGet_helpPretty() {
        TextTransformerController tr = new TextTransformerController();
        tr.jp = mock(JSONPrettifier.class);

        when(tr.jp.decorate(anyString())).thenReturn("lorem ipsum");

        tr.get_help();

        InOrder order_pretty = inOrder(tr.jp);
        order_pretty.verify(tr.jp).decorate(anyString());
    }

    @Test
    void testPrettyMock() {
        TextTransformerController tr = new TextTransformerController();
        tr.jp = mock(JSONPrettifier.class);

        String json = "{\"entryId\":\"b29ed77a-b447-4fd8-ae6a-8c5180724cd7\",\"lock\":{\"isLocked\":false}}";

        when(tr.jp.decorate(anyString())).thenReturn("lorem ipsum");

        tr.prettify(json);

        InOrder order_pretty = inOrder(tr.jp);
        order_pretty.verify(tr.jp).decorate(anyString());
    }

    @Test
    void testMinMock() {
        TextTransformerController tr = new TextTransformerController();
        tr.jm = mock(JSONMinifier.class);

        String json = "{\"entryId\":\"b29ed77a-b447-4fd8-ae6a-8c5180724cd7\",\"lock\":{\"isLocked\":false}}";

        when(tr.jm.decorate(anyString())).thenReturn("lorem ipsum");

        tr.minify(json);

        InOrder order_min = inOrder(tr.jm);
        order_min.verify(tr.jm).decorate(anyString());
    }
}
