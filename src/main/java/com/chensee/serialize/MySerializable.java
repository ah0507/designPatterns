package com.chensee.serialize;

import java.io.*;
import java.util.Objects;

public class MySerializable implements Serializable{

    private String username;
    private transient String password;
    private String number;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public static void main(String[] args) {
        MySerializable mySerializable = new MySerializable();
        mySerializable.setUsername("ahang");
        mySerializable.setPassword("ah950507");
        mySerializable.setNumber("13111114466");
        try {
            FileOutputStream fs = new FileOutputStream("foo.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(mySerializable);
            os.close();
            System.out.println("ok");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //读
        try {
            File file = new File("foo.ser");
            //以行为单位读取
//            FileReader fileReader = new FileReader(file);
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
            //以字符为单位读取
            //InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file));
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            String str="";
            int char1;
            int line=1;
//                while ((str = bufferedReader.readLine()) != null) {
//                    System.out.println("line " + line + ": " + str);
//                    line++;
//                }
                while ((char1 = bufferedInputStream.read()) != -1) {
                    System.out.print((char)char1);
                    line++;
                }
            } catch (Exception e) {
            e.printStackTrace();
        }

        Integer a=150,b=150;
        System.out.println(Objects.equals(a, b));
    }
}
