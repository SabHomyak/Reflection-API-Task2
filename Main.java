import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        TextContainer textContainer = new TextContainer("Hello World!");
        Class textContainerClass = textContainer.getClass();
        SaveTo saveTo = (SaveTo) textContainerClass.getAnnotation(SaveTo.class);
        Method[] methods = textContainerClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Saver.class)) {
                try {
                    method.invoke(textContainer, new File(saveTo.path()));
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
