package pl.put.poznan.JSONtools.rest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
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

}