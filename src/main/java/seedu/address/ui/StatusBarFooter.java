package seedu.address.ui;

import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;

/**
 * A ui for the status bar that is displayed at the footer of the application.
 */
public class StatusBarFooter extends UiPart<Region> {

    private static final String FXML = "StatusBarFooter.fxml";

    @FXML
    private Label saveLocationStatus;

    /**
     * Creates a {@code StatusBarFooter} with the given {@code Path}.
     */
    public StatusBarFooter(Path saveLocation) {
        super(FXML);
        saveLocationStatus.setText(Paths.get(".").resolve(saveLocation).toString());
    }

    public void swapPaths(Path archivePath, Path defaultPath) {
        String currentPathString = saveLocationStatus.getText();
        String archivePathString = Paths.get(".").resolve(archivePath).toString();
        String defaultPathString = Paths.get(".").resolve(defaultPath).toString();

        if (currentPathString.equals(archivePathString)) {
            saveLocationStatus.setText(defaultPathString);
        } else if (currentPathString.equals(defaultPathString)) {
            saveLocationStatus.setText(archivePathString);
        }
    }

}
