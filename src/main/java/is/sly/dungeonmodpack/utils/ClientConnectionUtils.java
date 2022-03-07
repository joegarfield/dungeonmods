package is.sly.dungeonmodpack.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClientConnectionUtils {
    public static List<String> limitedAccountPolicyUsers = new ArrayList<>(Arrays.asList("havnted"));

    public static boolean isOnVPN() {
        try {
            URL url = new URL("http://ifconfig.me/ip");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            if (content.toString().equalsIgnoreCase("144.217.80.47")) {
                return true;
            }
            in.close();
            con.disconnect();
        } catch (Exception ignored) {
        }
        return false;
    }

}

