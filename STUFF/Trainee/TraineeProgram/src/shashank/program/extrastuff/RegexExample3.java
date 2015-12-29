package shashank.program.extrastuff;

import java.util.regex.*;  

class RegexExample3{  
public static void main(String args[]){  
System.out.println(Pattern.matches("\\d*", "11"));//false (not a or m or n)  
System.out.println(Pattern.matches("[a-z && [def]]", "dd"));//true (among a or m or n)  
System.out.println(Pattern.matches("[amn]*", "ammmna"));//false (m and a comes more than once)  
}}