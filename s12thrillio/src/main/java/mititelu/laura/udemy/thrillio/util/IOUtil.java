package mititelu.laura.udemy.thrillio.util;

import java.io.*;

public class IOUtil {

    public static void read(String[] data, String filename){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"))){
            String line;
            int count = 0;
            while((line = br.readLine()) != null){
                data[count] = line;
                count++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String read(InputStream in) {
        StringBuilder text = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"))){
            String line;
            while((line = br.readLine()) != null){
                text.append(line).append("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }

    public static void write(String webpage, long id) {
        //name of the file will be the id of the bookmark
        try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("D:/Programare/Udemy Thales/JavaInDepth/s12thrillio/pages/" +
                        String.valueOf(id)+".html"), "UTF-8"))){
            writer.write(webpage);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
