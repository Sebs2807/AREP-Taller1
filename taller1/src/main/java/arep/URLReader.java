package arep;

import java.io.*;
import java.net.*;
import java.nio.charset.MalformedInputException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class URLReader {

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.google.com/");

        URLConnection urlConnection = url.openConnection();

        Map<String, List<String>> headers = urlConnection.getHeaderFields();

        Set<Map.Entry<String, List<String>>> entrySet = headers.entrySet();

        for (Map.Entry<String, List<String>> entry : entrySet) {
            String headerName = entry.getKey();
            if(headerName !=null){System.out.print(headerName + ":");}
            List<String> headerValues = entry.getValue();
            for (String value : headerValues) {
                System.out.print(value);
            }
            System.out.println("");
        }

        try {BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

