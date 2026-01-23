import java.util.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;

public class FileIO {
    public static void main(String[] args) {
        //Reading
        Scanner in = new Scanner(Path.of("myfile.txt"), StandardCharsets.UTF_8);

        //Writing
        PrintWriter out = new PrintWriter("myfile.txt", StandardCharsets.UTF_8);
    }
}