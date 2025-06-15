package org.ahmet.classes.processor;

import org.ahmet.classes.model.Message;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MessageProcessorTest {

    private final MessageProcessor processor = new MessageProcessor();

    @Test
    public void testFilterMessage() {
        Message message = new Message("Meeting scheduled for 3 PM", "Alice", "Bob", System.currentTimeMillis());
        Message result = processor.filterMessage(message, "scheduled");
        assertNotNull(result);
        assertEquals("Meeting scheduled for 3 PM", result.getContent());

        result = processor.filterMessage(message, "cancelled");
        assertNull(result);
    }

    @Test
    public void testTransformMessage() {
        Message message = new Message("meeting scheduled for 3 pm", "Alice", "Bob", System.currentTimeMillis());
        Message result = processor.transformMessage(message);
        assertNotNull(result);
        assertEquals("MEETING SCHEDULED FOR 3 PM", result.getContent());
    }

    @Test
    public void testProcessMessage() {
        Message message = new Message("Meeting scheduled for 3 PM", "Alice", "Bob", System.currentTimeMillis());
        Message result = processor.processMessage(message);
        assertNotNull(result);
        assertEquals("Processed: Meeting scheduled for 3 PM", result.getContent());
    }

    @Test
    public void testAppendMessage() {
        Message message1 = new Message("Meeting scheduled for 3 PM", "Alice", "Bob", System.currentTimeMillis());
        Message message2 = new Message("Please confirm attendance", "Alice", "Bob", System.currentTimeMillis());
        Message result = processor.appendMessage(message1, message2);
        assertNotNull(result);
        assertEquals("Meeting scheduled for 3 PM Please confirm attendance", result.getContent());
    }

    @Test
    public void testReplaceMessage() {
        Message message = new Message("Meeting scheduled for 3 PM", "Alice", "Bob", System.currentTimeMillis());
        Message result = processor.replaceMessage(message, "scheduled", "confirmed");
        assertNotNull(result);
        assertEquals("Meeting confirmed for 3 PM", result.getContent());
    }

    @Test
    public void testTruncateMessage() {
        Message message = new Message("Meeting scheduled for 3 PM", "Alice", "Bob", System.currentTimeMillis());
        Message result = processor.truncateMessage(message, 7);
        assertNotNull(result);
        assertEquals("Meeting", result.getContent());
    }

    @Test
    public void testReverseMessage() {
        Message message = new Message("Meeting scheduled for 3 PM", "Alice", "Bob", System.currentTimeMillis());
        Message result = processor.reverseMessage(message);
        assertNotNull(result);
        assertEquals("MP 3 rof deludehcs gniteeM", result.getContent()); // Correct expected value
    }

    @Test
    public void testDecodeMessage() {
        Message message = new Message("Khoor Zruog", "Alice", "Bob", System.currentTimeMillis());
        Message result = processor.decodeMessage(message, 3);
        assertNotNull(result);
        assertEquals("Hello World", result.getContent());
    }

    @Test
    public void testEncodeMessage() {
        Message message = new Message("Hello World", "Alice", "Bob", System.currentTimeMillis());
        Message result = processor.encodeMessage(message, 3);
        assertNotNull(result);
        assertEquals("Khoor Zruog", result.getContent());
    }

    @Test
    public void testCountWords() {
        Message message = new Message("Meeting scheduled for 3 PM", "Alice", "Bob", System.currentTimeMillis());
        int wordCount = processor.countWords(message);
        assertEquals(5, wordCount);
    }

@Test
    public void testCountCharacters() {
        Message message = new Message("Meeting scheduled for 3 PM", "Alice", "Bob", System.currentTimeMillis());
        int charCount = processor.countCharacters(message);
        System.out.println("Expected character count (excluding spaces): " + message.getContent().replace(" ", "").length());
        assertEquals(26, charCount);
    }

    @Test
    public void testFormatMessage() {
        Message message = new Message("Meeting", "Alice", "Bob", System.currentTimeMillis());
        Message result = processor.formatMessage(message, "%s scheduled for 3 PM");
        assertNotNull(result);
        assertEquals("Meeting scheduled for 3 PM", result.getContent());
    }

    @Test
    public void testFilterMessageWithNullKeyword() {
        Message message = new Message("Meeting scheduled for 3 PM", "Alice", "Bob", System.currentTimeMillis());
        Message result = processor.filterMessage(message, null);
        assertNull(result);
    }

}