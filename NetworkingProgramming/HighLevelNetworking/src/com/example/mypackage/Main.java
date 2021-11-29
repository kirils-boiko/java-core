package com.example.mypackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        try {
            URL url = new URL("https://www.flickr.com/services/feeds/photos_public.gne?tags=cats");
            URI uri = url.toURI();

            //---------------------------------------------------------
            // 1st way of reading data from url
//            URLConnection urlConnection = url.openConnection();
//            urlConnection.connect();
//
//            BufferedReader inputStream = new BufferedReader(
//                    new InputStreamReader(urlConnection.getInputStream())
//            );
//
//            Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
//            for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
//                String key = entry.getKey();
//                List<String> headers = entry.getValue();
//                System.out.println("-----key = " + key);
//                for (String header : headers) {
//                    System.out.println("header field = " + header);
//                }
//            }
//            String line = "";
//            while (line != null) {
//                line = inputStream.readLine();
//                System.out.println(line);
//            }
//            inputStream.close();

            //---------------------------------------------------------
            // 2nd way of reading data from url
//            BufferedReader inputStream = new BufferedReader(
//                    new InputStreamReader(url.openStream()));
//
//            String line = "";
//            while (line != null) {
//                line = inputStream.readLine();
//                System.out.println(line);
//            }
//            inputStream.close();


            //---------------------------------------------------------
            // 3rd way of reading data from url using HttpURLConnection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET"); // setting the method for reading data from URL
            connection.setRequestProperty("User-Agent", "Chrome");
            connection.setReadTimeout(15000);

            int responseCode = connection.getResponseCode();    // implicitly connects to URL
            System.out.println("Response code: " + responseCode);
            if (responseCode != 200) {
                System.out.println("Error reading web page");
                System.out.println(connection.getResponseMessage());
                return;
            }

            BufferedReader inputReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = inputReader.readLine()) != null) {
                System.out.println(line);
            }
            inputReader.close();

            //---------------------------------------------------------
            // getting the flickr cats


            //---------------------------------------------------------
//            System.out.println("Scheme = " + uri.getScheme());
//            System.out.println("Scheme-specific part = " + uri.getSchemeSpecificPart());
//            System.out.println("Authority = " + uri.getAuthority());
//            System.out.println("User info = " + uri.getUserInfo());
//            System.out.println("Host = " + uri.getHost());
//            System.out.println("Port = " + uri.getPort());
//            System.out.println("Path = " + uri.getPath());
//            System.out.println("Query = " + uri.getQuery());
//            System.out.println("Fragment = " + uri.getFragment());

        } catch (MalformedURLException e) {
            System.out.println("URL Malformed: " + e.getMessage());
        } catch (URISyntaxException e) {
            System.out.println("URI Syntax error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
