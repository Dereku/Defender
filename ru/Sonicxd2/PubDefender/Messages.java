/*
 * Заголовок лицензии. Удали его, если ты не выбрал лицензию.
 */
package ru.Sonicxd2.PubDefender;

import org.bukkit.ChatColor;

/**
 *
 * @author Yaroslav
 */
public class Messages {

    /* 
        Нет, так не годится. Используй .properties или же .yml 
        (в крайнем случае) вместо этого. 
    */
    public static String prefix = ChatColor.GREEN + "[Defender]";
    public static String messageSuccess = ChatColor.GREEN + "Вы прошли проверку!";
    public static String messageError = ChatColor.RED + "У вас осталось %number% попыток";
    public static String kickMessage = ChatColor.RED + "Вы не прошли проверку!";
    public static String sum = ChatColor.BOLD + "плюс ";
    public static String min = ChatColor.BOLD + "минус ";
    public static String umn = ChatColor.BOLD + "умножить на ";
    public static String primer = prefix + " %num1% %znak% " + ChatColor.GREEN + " %num2%";
}
