package DinamicCompilation;

import javax.tools.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.Locale;

public class CompilerAPITest {

    private static final String CLASS_NAME = "DinamicCompilation.HelloWorld";

    private static final String SOURCE_CODE = "package DinamicCompilation;"+
           "public class HelloWorld {"+
           "public static void main (String args[]){"+
           "System.out.println(\"Hello, dynamic compilation world!\");"+
           "}"+
           "}";
    public void doCompilation(File outputDir) throws IOException {

        SimpleJavaFileObject fileObject = new DynamicJavaSourceCodeObject(CLASS_NAME,SOURCE_CODE);
        JavaFileObject javaFileObject[] = new JavaFileObject[]{fileObject};
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        StandardJavaFileManager stdFileManager = compiler.getStandardFileManager(null, Locale.getDefault(),null);
        /*stdFileManager.setLocation(StandardLocation.CLASS_OUTPUT,Arrays.asList(new File("C:\\Users\\Владислав\\IdeaProjects\\ProjectTasks\\")));*/
        Iterable compliationUnits = Arrays.asList(javaFileObject);
        String[] compileOptions = new String[]{"-d",outputDir.getAbsolutePath()};
        Iterable compilationOptions = Arrays.asList(compileOptions);
        DiagnosticCollector diagnostics = new DiagnosticCollector();
        JavaCompiler.CompilationTask task = compiler.getTask(null, stdFileManager, diagnostics, compilationOptions, null, compliationUnits);
        boolean status = task.call();
        stdFileManager.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        File outputDir = new File("src" + File.separator + "DinamicCompilation");
        outputDir.mkdir(); // checking
        new CompilerAPITest().doCompilation(outputDir);
        invoke(outputDir);
    }

    private static void invoke(File outputDir) throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        URL[] urls = new URL[]{outputDir.toURI().toURL()};
        URLClassLoader ucl = new URLClassLoader(urls);
        Class clazz = ucl.loadClass(CLASS_NAME);
        Method main = clazz.getMethod("main",String[].class);
        String[] mainArgs = new String[]{};
        System.out.format("invoking %s.main()%n", clazz.getName());
        main.invoke(null,(Object) mainArgs);
    }

}
