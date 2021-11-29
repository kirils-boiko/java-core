package com.example.mypackage;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        try {
            URI uri = new
                    URI("https://username:password@myserver.com:5000/catalogue/phone?os=android#samsung");
            System.out.println("Scheme = " + uri.getScheme());
            System.out.println("Scheme-specific part = " + uri.getSchemeSpecificPart());
            System.out.println("Authority = " + uri.getAuthority());
            System.out.println("User info = " + uri.getUserInfo());
            System.out.println("Host = " + uri.getHost());
            System.out.println("Port = " + uri.getPort());
            System.out.println("Path = " + uri.getPath());
            System.out.println("Query = " + uri.getQuery());
            System.out.println("Fragment = " + uri.getFragment());

            URL url = uri.toURL();
            System.out.println("URL = " + url);

            URI baseUri = new URI("https://username:password@myserver.com:5000");
            URI relativeUri = new URI("/catalogue/phone?os=android#samsung");
            URI absoluteUri = baseUri.resolve(relativeUri);
            System.out.println("Absolute URI = " + absoluteUri);

            System.out.println("==========================================");

            URI relativeUri1 = new URI("/catalogue/phone?os=android#samsung");
            URI relativeUri2 = new URI("/catalogue/tvs?manufacturer=samsung");
            URI relativeUri3 = new URI("/stores/locations?zip=12345");

            URI resolvedUri1 = baseUri.resolve(relativeUri1);
            URI resolvedUri2 = baseUri.resolve(relativeUri2);
            URI resolvedUri3 = baseUri.resolve(relativeUri3);

            URL url1 = resolvedUri1.toURL();
            System.out.println("URL 1 = " + url1);
            URL url2 = resolvedUri2.toURL();
            System.out.println("URL 2 = " + url2);
            URL url3 = resolvedUri3.toURL();
            System.out.println("URL 3 = " + url3);

            URI relativizedURI1 = baseUri.relativize(resolvedUri1);
            System.out.println("Relative URI 1 = " + relativizedURI1);

        } catch (URISyntaxException e) {
            System.out.println("URI Bad Syntax: " + e.getMessage());
        } catch (MalformedURLException e) {
            System.out.println("URL Malformed: " + e.getMessage());
        }
    }
}
