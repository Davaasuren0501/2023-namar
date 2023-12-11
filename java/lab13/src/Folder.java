import java.io.File;
        import java.util.Set;
        import java.util.stream.Collectors;
        import java.util.stream.Stream;

public class Folder {
    public static void main(String[] args) {
        String file = listFilesUsingJavaIO("/home/davaa/Documents").toString();
        System.out.println(file);
    }
    public static Set<String> listFilesUsingJavaIO(String dir) {
        return Stream.of(new File(dir).listFiles())
                .filter(file -> !file.isDirectory() && file.getName().toLowerCase().endsWith(".txt"))
                . limit(5)
                .map(File::getName)
                .collect(Collectors.toSet());
    }
}
