package ru.job4j.gc.cache;

import java.io.File;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirFileCache extends AbstractCache<String, String> {

private final String cachingDir;

public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
        }

@Override
protected String load(String key) {
    String result = null;
    try {
        result = Files.readString(Paths.get(cachingDir, key));
    } catch (IOException e) {
       e.printStackTrace();
    }
    return result;
}


}
