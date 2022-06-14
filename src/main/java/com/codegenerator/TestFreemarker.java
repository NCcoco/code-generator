package com.codegenerator;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TestFreemarker {

    public static void main(String[] args) throws IOException, TemplateException {
        // 它是单例的
        // Create your Configuration instance, and specify if up to what FreeMarker
        // version (here 2.3.23) do you want to apply the fixes that are not 100%
        // backward-compatible. See the Configuration JavaDoc for details.
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);

        // Specify the source where the template files come from. Here I set a
        // plain directory for it, but non-file-system sources are possible too:
        cfg.setDirectoryForTemplateLoading(new ClassPathResource("templates/freemarker").getFile());

        // Set the preferred charset template files are stored in. UTF-8 is
        // a good choice in most applications:
        cfg.setDefaultEncoding("UTF-8");

        // Sets how errors will appear.
        // During web page *development* TemplateExceptionHandler.HTML_DEBUG_HANDLER is better.
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        Template template = cfg.getTemplate("Test.ftl");
        Map<String, Object> data = new HashMap<>();
        Map<String, Object> testMap = new LinkedHashMap<>();
        data.put("testMap", testMap);
        testMap.put("D", "d");
        testMap.put("E", "e");
        testMap.put("A", "a");
        testMap.put("B", "b");
        testMap.put("C", "c");


        Writer writer = new OutputStreamWriter(System.out);
        template.process(data, writer);
    }
}
