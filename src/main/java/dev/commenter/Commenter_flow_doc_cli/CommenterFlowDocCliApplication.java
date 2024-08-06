import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class CommenterApplication implements CommandLineRunner {

	@Value("${input.directory}")
	private String inputDirectory;

	@Value("${output.directory}")
	private String outputDirectory;

	public static void main(String[] args) {
		SpringApplication.run(CommenterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// 1. Read files from the input directory
		File[] files = new File(inputDirectory).listFiles();
		for (File file : files) {
			// 2. Send each file to the commentor flow and receive the results
			String comments = sendFileToCommentorFlow(file);

			// 3. Add the comments to the file
			String updatedFileContent = addCommentsToFile(file, comments);

			// 4. Write the updated file to the output directory
			writeUpdatedFileToOutputDirectory(file.getName(), updatedFileContent);

			// 5. Print the results to the console
			System.out.println("Updated file " + file.getName() + " with comments and wrote to output directory.");
		}
	}

	// ... rest of the methods ...
}
