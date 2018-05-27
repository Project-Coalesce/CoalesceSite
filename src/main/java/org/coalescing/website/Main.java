package org.coalescing.website;

import spark.Spark;

import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static spark.Spark.*;

public class Main {

    // Don't forget to change it back to false before pushing!
    private static final boolean LOCALHOST = false;

    private String resourcePath;

    @SuppressWarnings("deprecated")
    private Main() {
        setPort(80);

        resourcePath = "/public";
        if (LOCALHOST) {
            String projectDir = System.getProperty("user.dir") + "/src/main/resources";
            resourcePath = projectDir + resourcePath;
        }

        staticFileLocation("/public");

        get("/", (request, response) -> renderPage("index"));
        get("/:name", (request, response) -> renderPage(request.params(":name")));

        Spark.init();
    }

    private String renderPage(final String page) {
        try {
            URL url = Main.class.getResource(resourcePath + "/" + page + ".html");
            Path path = Paths.get(url.toURI());
            return new String(Files.readAllBytes(path), Charset.defaultCharset());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return "Error 404: Page not found!";
    }

    public static void main(String[] args) {
        new Main();
    }

}
