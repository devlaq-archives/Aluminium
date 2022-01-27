package aluminium.backends;

import aluminium.Files;
import aluminium.files.Fi;
import aluminium.util.AluRuntimeException;
import aluminium.util.OS;

import java.io.File;

public final class AluFiles implements Files {
    public static final String externalPath = OS.userHome + File.separator;
    public static final String localPath = new File("").getAbsolutePath() + File.separator;

    @Override
    public Fi get(String fileName, FileType type){
        return new AluFi(fileName, type);
    }

    @Override
    public String getExternalStoragePath(){
        return externalPath;
    }

    @Override
    public boolean isExternalStorageAvailable(){
        return true;
    }

    @Override
    public String getLocalStoragePath(){
        return localPath;
    }

    @Override
    public boolean isLocalStorageAvailable(){
        return true;
    }

    public static class AluFi extends Fi {
        public AluFi(String fileName, FileType type){
            super(fileName, type);
        }

        public AluFi(File file, FileType type){
            super(file, type);
        }

        @Override
        public Fi child(String name){
            if(file.getPath().length() == 0) return new AluFi(new File(name), type);
            return new AluFi(new File(file, name), type);
        }

        @Override
        public Fi sibling(String name){
            if(file.getPath().length() == 0) throw new AluRuntimeException("Cannot get the sibling of the root.");
            return new AluFi(new File(file.getParent(), name), type);
        }

        @Override
        public File file(){
            if(type == FileType.external) return new File(externalPath, file.getPath());
            if(type == FileType.local) return new File(localPath, file.getPath());
            return file;
        }
    }
}