package plugin.utils;

import org.bukkit.ChatColor;

public class Utils {
    
    public static String chat(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static String success(String s) {
        return ChatColor.translateAlternateColorCodes('&', "&a" + s);
    }
    
    public static String fail(String s) {
        return ChatColor.translateAlternateColorCodes('&', "&c" + s);
    }
}
