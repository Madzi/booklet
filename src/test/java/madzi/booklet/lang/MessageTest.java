package madzi.booklet.lang;

import java.util.ResourceBundle;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Message")
public class MessageTest {

    private ResourceBundle bundle = ResourceBundle.getBundle("lang/booklet");

    @Test
    @DisplayName("should cover all resources")
    public void testEnumOverResources() {
        final Set<String> messages = Stream.of(Message.values()).map(Message::key).collect(Collectors.toSet());
        final var iterator = bundle.getKeys().asIterator();
        while (iterator.hasNext()) {
            final var key = iterator.next();
            if (!messages.contains(key)) {
                Assertions.fail("Expecting " + key + " to be into Enum");
            }
        }
    }

    @Test
    @DisplayName("should be consistant with resourecs")
    public void testResourcesOverEnum() {
        final Set<String> resources = bundle.keySet();
        for (Message message : Message.values()) {
            if (!resources.contains(message.key())) {
                Assertions.fail("Expecting " + message.key() + " to be into Properties");
            }
        }
    }
}
