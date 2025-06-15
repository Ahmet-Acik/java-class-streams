package org.ahmet.classes;// MessageProcessorTest.java
import org.ahmet.classes.processor.MessageProcessor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageProcessorTest {
    @Test
    public void testFilterMessage() {
        MessageProcessor processor = new MessageProcessor();
        assertEquals("Hello World", processor.filterMessage("Hello World", "World"));
        assertNull(processor.filterMessage("Hello World", "Test"));
    }

    @Test
    public void testTransformMessage() {
        MessageProcessor processor = new MessageProcessor();
        assertEquals("HELLO WORLD", processor.transformMessage("Hello World"));
        assertNull(processor.transformMessage(null));
    }
    @Test
    public void testProcessMessage() {
        MessageProcessor processor = new MessageProcessor();
        assertEquals("Processed: Hello World", processor.processMessage("Hello World"));
        assertThrows(IllegalArgumentException.class, () -> processor.processMessage(null));
    }

}