package example;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

/**
 * Created with IntelliJ IDEA.
 * User: Evgen
 * Date: 05.04.13
 * Time: 18:53
 * To change this template use File | Settings | File Templates.
 */
public class ClientConverter {
    public static void main(String[] args) throws IOException, InterruptedException {
        File inputFile = new File("input_files\\invoice.txt");

        WatchService service = FileSystems.getDefault().newWatchService();	// Create a WatchService
        Path path = Paths.get(inputFile.getParent());	// Get the directory to be monitored
        path.register(service, StandardWatchEventKinds.ENTRY_MODIFY);

        Converter.performConverting(inputFile);

        while(true)
        {
            WatchKey key = service.take();	// retrieve the watchkey
            for (WatchEvent event : key.pollEvents())
            {
                System.out.println(event.kind() + ": "+ event.context());	// Display event and file
                Converter.performConverting(inputFile);
            }
            boolean valid = key.reset();
            if (!valid)
            {
                break;	// Exit if directory is deleted
            }
        }
    }
}
