import java.util.*;
public class RestoreIPAddress {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();

        int len = s.length();

        if (len > 12) return res;

        for (int i = 1; i <= 3 && i < len; i++) {
            for (int j = i + 1; j <= i+3 && j < len; j++) {
                for (int k = j + 1; k <= j + 3 && k < len; k++) {
                    long a = Long.valueOf(s.substring(0, i));
                    long b = Long.valueOf(s.substring(i, j));
                    long c = Long.valueOf(s.substring(j, k));
                    long d = Long.valueOf(s.substring(k));

                    if (a > 255 || b > 255 || c > 255 || d > 255) continue;

                    String ip = a + "." + b + "." + c + "." + d;

                    if (ip.length() < len + 3) continue;
                    res.add(ip);
                }
            }
        }

        return res;
    }

}
