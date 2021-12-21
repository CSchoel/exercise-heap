package de.thm.mni.aud.commons;

import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;
import java.util.*;

public class AbstractFileIOTest {

    private Map<String,Path> resourcePaths;
    private List<Path> dirs;
    private final List<String> resources;

    public AbstractFileIOTest(String... resources) {
        this.resources = Arrays.asList(resources);
        this.dirs = new ArrayList<>();
    }

    private Map<String, Path> extractToCWD(List<String> resources)
          throws IOException {
        Map<String,Path> resourceMap = new HashMap<>();
        for(String res : resources) {
            try(
              InputStream resStream = getClass()
                                      .getResourceAsStream("/"+res)
            ) {
                String msg = "The resource '%s' is not available in the"
                           + " classpath. Check your classpath configuration"
                           + " or JAR contents.";
                Objects.requireNonNull(resStream,String.format(msg,res));
                Path path = Paths.get(res);
                // get the highest directory that does not exist
                Path parent = path;
                while(parent.getParent() != null
                      && Files.notExists(parent.getParent())
                ) {
                    parent = parent.getParent();
                    dirs.add(parent);
                }
                // check if there is a parent that must be added
                if (!path.equals(parent)) {
                    Files.createDirectories(path.getParent());
                }
                try {
                    Files.copy(resStream, path);
                    resourceMap.put(res, path.toAbsolutePath());
                } catch (FileAlreadyExistsException faee) {
                    /* we want to create the file, if it exists that is ok */
                }
            }
        }
        return resourceMap;
    }

    @Before
    public void extractResources() throws IOException {
        resourcePaths = extractToCWD(resources);
    }

    @After
    public void cleanupResources() throws IOException {
        for(Path p : resourcePaths.values()) {
            Files.delete(p);
        }
        for(Path d : dirs) {
            if(Files.exists(d)) Files.delete(d);
        }
        dirs.clear();
    }

    protected Path pathOf(String resourceName) {
        String msg = String.format(
          "There is no such resource: %s",
          resourceName
        );
        return Objects.requireNonNull(resourcePaths.get(resourceName), msg);
    }
}
