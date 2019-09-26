import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@SaveTo
public class TextContainer {
    private String string;

    public TextContainer() {
    }

    public TextContainer(String string) {
        this.string = string;
    }

    @Saver
    public void save(File file) throws IOException {
        try (FileWriter fw = new FileWriter(file)) {
            fw.write(string);
        } catch (IOException e) {
            throw e;
        }
    }
}
