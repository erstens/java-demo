import javassist.ClassPool;
import javassist.CtClass;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class CtClassMain {
    public static void main(String[] args) throws IOException {
        String src = "";

        InputStream classfile = new ByteArrayInputStream(src.getBytes(StandardCharsets.UTF_8));
        CtClass c = new ClassPool(true).makeClass(classfile);

//        com.alibaba.dubbo.common.compiler.support.JavassistCompiler.doCompile()
    }
}
