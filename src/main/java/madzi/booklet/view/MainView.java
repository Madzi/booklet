package madzi.booklet.view;

import org.slf4j.Logger;

import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.spi.BeanManager;
import jakarta.enterprise.util.AnnotationLiteral;
import jakarta.inject.Inject;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.stage.Modality;
import javafx.stage.Stage;
import madzi.booklet.cdi.view.annotation.AboutFxmlView;
import madzi.booklet.cdi.view.event.VoidViewEvent;

@Dependent
public class MainView {

    @Inject
    private Logger logger;
    @Inject
    private BeanManager beanManager;

    @FXML
    public void onFileExit() {
        logger.info("Exit");
        Platform.exit();
    }

    @FXML
    public void onHelpAbout() {
        final var stage = new Stage();
        stage.setAlwaysOnTop(true);
        stage.initModality(Modality.APPLICATION_MODAL);
        beanManager.getEvent().select(new AnnotationLiteral<AboutFxmlView>() {
        }).fire(new VoidViewEvent(stage));
    }

//    @FXML
//    public void onHelpSettings() {
//        ///
//    }
}
