package org.coalescing.website;

import spark.Spark;

import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static spark.Spark.*;

public class Main {

    public Main() {
        setPort(80);

        staticFileLocation("/public");

        get("/", (request, response) -> renderIndex());

        Spark.init();
    }

    private String renderIndex() {
        try {
            URL url = Main.class.getResource("/public/index.html");
            System.out.println(url);
            Path path = Paths.get(url.toURI());
            return new String(Files.readAllBytes(path), Charset.defaultCharset());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return "FATAL ERROR";
    }

    public static void main(String[] args) {
        new Main();
    }

}
