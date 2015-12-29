package com.yash.serializedemo;

import java.io.*;

public class SerializeDemo
{
   public static void main(String [] args)
   {
      Employee e = Employee.getEmpObject();
      e.name = "Shashank";
      e.address = "THIS is address";
      e.SSN = 11122333;
      e.number = 101;
      
      try
      {
         FileOutputStream fileOut =
         new FileOutputStream("D://serialdemo.txt");
         System.out.println("SERIALIZE CLASS : " +e);
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(e);
         out.close();
         fileOut.close();
         System.out.printf("SAVED IN FILE D://serialdemo.txt");
      }catch(IOException i)
      {
          i.printStackTrace();
      }
   }
}