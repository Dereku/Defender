/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.Sonicxd2.PubDefender;

import org.bukkit.ChatColor;

/**
 *
 * @author Yaroslav
 */
public class Messages {
    public static String prefix=ChatColor.GREEN+"[Defender]";
    public static String messageSuccess=ChatColor.GREEN+"Вы прошли проверку!";
    public static String messageError=ChatColor.RED+"У вас осталось %number% попыток";
    public static String kickMessage=ChatColor.RED+"Вы не прошли проверку!";
    public static String sum=ChatColor.BOLD+"плюс ";
    public static String min=ChatColor.BOLD+"минус ";
    public static String umn=ChatColor.BOLD+"умножить на ";
    public static String primer=prefix+" %num1% %znak% "+ChatColor.GREEN+" %num2%";
}
