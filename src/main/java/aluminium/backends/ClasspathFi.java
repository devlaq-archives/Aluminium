package aluminium.backends;

import aluminium.Files;

import java.io.File;
import java.io.InputStream;


public class ClasspathFi extends AluFiles.AluFi {
    public final Class<?> clazz;

    public ClasspathFi(String fileName, Class<?> clazz) {
        super(fileName, Files.FileType.classpath);
        this.clazz = clazz;
    }

    public ClasspathFi(File file, Class<?> clazz) {
        super(file, Files.FileType.classpath);
        this.clazz = clazz;
    }

    @Override
    public InputStream read() {
        return super.read(this.clazz);
    }

    @Override
    public boolean exists() {
        return super.exists(this.clazz);
    }

    @Override
    public long length() {
        return super.length(this.clazz);
    }
}
