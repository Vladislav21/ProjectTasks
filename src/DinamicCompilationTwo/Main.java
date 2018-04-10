package DinamicCompilationTwo;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
//from jav a2s  . c  om
import javax.tools.*;

public class Main {
    public static void main(String[] args) throws Exception {
        File sourceFile = new File("src" + File.separator + "DinamicCompilationTwo" + File.separator + "Hero.java");
        FileWriter writer = new FileWriter(sourceFile);
        writer.write("public class Hero{ \n" +
                " public void doit() { \n" +
                " System.out.println(\"Hello world\") ;\n" +
                " }\n" +
                "}");
        writer.close();
        sourceFile.mkdir();
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(
                null, null, null);

        fileManager.setLocation(StandardLocation.CLASS_OUTPUT, Arrays
                .asList(new File("C:\\Users\\Владислав\\IdeaProjects\\ProjectTasks\\src\\DinamicCompilationTwo\\")));
        // Compile the file
        boolean success = compiler.getTask(null, fileManager, null, null, null,
                fileManager.getJavaFileObjectsFromFiles(Arrays.asList(sourceFile)))
                .call();
        fileManager.close();
        runIt(sourceFile);
    }

    @SuppressWarnings("unchecked")
    public static void runIt(File file) {
        try {
            URL[] urls = new URL[]{file.toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls);
            Class loadClass = urlClassLoader.loadClass("Hero");
            Method doit = loadClass.getMethod("doit", null);
            Object o = loadClass.newInstance();
            doit.invoke(o, null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}