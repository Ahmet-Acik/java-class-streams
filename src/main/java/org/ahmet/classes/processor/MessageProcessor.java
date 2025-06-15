package org.ahmet.classes.processor;
//
//import javax.annotation.Nonnull;
//import javax.annotation.Nullable;
//
//public class MessageProcessor {
//
//    // Filters a message based on the presence of a keyword
//    @Nullable
//    public String filterMessage(@Nullable final String message, @Nullable final String keyword) {
//        if (message == null || keyword == null) {
//            return null;
//        }
//        return message.contains(keyword) ? message : null;
//    }
//
//    // Transforms a message to uppercase
//    @Nullable
//    public String transformMessage(@Nullable final String message) {
//        return message == null ? null : message.toUpperCase();
//    }
//
//    // Processes a message by appending a prefix
//    @Nonnull
//    public String processMessage(@Nonnull final String message) {
//        if (message == null) {
//            throw new IllegalArgumentException("Input cannot be null.");
//        }
//        return "Processed: " + message;
//    }
//
//    // Appends one message to another
//    @Nullable
//    public String appendMessage(@Nullable final String original, @Nullable final String toAppend) {
//        if (original == null || toAppend == null) {
//            return null;
//        }
//        return original + " " + toAppend;
//    }
//
//    // Replaces a target substring with a replacement in the original message
//    @Nullable
//    public String replaceMessage(@Nullable final String original, @Nullable final String target, @Nullable final String replacement) {
//        if (original == null || target == null || replacement == null) {
//            return null;
//        }
//        return original.replace(target, replacement);
//    }
//
//    // Truncates a message to a specified length
//    @Nullable
//    public String truncateMessage(@Nullable final String message, final int length) {
//        if (message == null || length < 0) {
//            return null;
//        }
//        return message.length() <= length ? message : message.substring(0, length);
//    }
//
//    // Reverses the characters in a message
//    @Nullable
//    public String reverseMessage(@Nullable final String message) {
//        if (message == null) {
//            return null;
//        }
//        return new StringBuilder(message).reverse().toString();
//    }
//
//    // Decodes a message by shifting characters backward
// @Nullable
//        public String decodeMessage(String message, int shift) {
//            if (message == null || shift < 0) {
//                return null; // Return null for invalid input
//            }
//            return message.chars()
//                    .mapToObj(c -> {
//                        if (Character.isLetter(c)) {
//                            char base = Character.isLowerCase(c) ? 'a' : 'A';
//                            return (char) ((c - base + shift + 26) % 26 + base); // Corrected shift direction
//                        } else {
//                            return (char) c;
//                        }
//                    })
//                    .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
//                    .toString();
//        }
//
//    // Encodes a message by shifting characters forward
//        @Nullable
//        public String encodeMessage(@Nullable final String message, final int shift) {
//            if (message == null || shift < 0) {
//                return null;
//            }
//            return message.chars()
//                    .mapToObj(c -> {
//                        if (Character.isLetter(c)) {
//                            char base = Character.isLowerCase(c) ? 'a' : 'A';
//                            return (char) ((c - base + shift) % 26 + base);
//                        } else {
//                            return (char) c;
//                        }
//                    })
//                    .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
//                    .toString();
//        }
//    // Formats a message using a specified format
//    @Nullable
//    public String formatMessage(@Nullable final String message, @Nullable final String format) {
//        if (message == null || format == null) {
//            throw new IllegalArgumentException("Message and format must not be null");
//        }
//        return String.format(format, message);
//    }
//
//    // Counts the number of words in a message
//    public int countWords(@Nonnull final String message) {
//        if (message == null) {
//            throw new IllegalArgumentException("Input cannot be null.");
//        }
//        String trimmedMessage = message.trim();
//        return trimmedMessage.isEmpty() ? 0 : trimmedMessage.split("\\s+").length;
//    }
//
//    // Counts the number of characters in a message
//    public int countCharacters(@Nonnull final String message) {
//        if (message == null) {
//            throw new IllegalArgumentException("Message cannot be null.");
//        }
//        return message.length();
//    }
//}
import org.ahmet.classes.model.Message;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.logging.Logger;

public class MessageProcessor {

    private static final Logger logger = Logger.getLogger(MessageProcessor.class.getName());

    // Filters a message based on the presence of a keyword
    @Nullable
    public Message filterMessage(@Nullable final Message message, @Nullable final String keyword) {
        logger.info("Filtering message with keyword: " + keyword);
        if (message == null || keyword == null) {
            logger.warning("Message or keyword is null");
            return null;
        }
        boolean containsKeyword = message.getContent().contains(keyword);
        logger.info("Keyword found: " + containsKeyword);
        return containsKeyword ? message : null;
    }

    // Transforms a message to uppercase
    @Nullable
    public Message transformMessage(@Nullable final Message message) {
        logger.info("Transforming message to uppercase");
        if (message == null) {
            logger.warning("Message is null");
            return null;
        }
        String transformedContent = message.getContent().toUpperCase();
        return new Message(transformedContent, message.getSender(), message.getReceiver(), message.getTimestamp());
    }

    // Appends one message's content to another
    @Nullable
    public Message appendMessage(@Nullable final Message original, @Nullable final Message toAppend) {
        logger.info("Appending messages");
        if (original == null || toAppend == null) {
            logger.warning("One of the messages is null");
            return null;
        }
        String appendedContent = original.getContent() + " " + toAppend.getContent();
        return new Message(appendedContent, original.getSender(), original.getReceiver(), original.getTimestamp());
    }

    // Counts the number of words in a message
    public int countWords(@Nonnull final Message message) {
        logger.info("Counting words in message");
        String trimmedContent = message.getContent().trim();
        return trimmedContent.isEmpty() ? 0 : trimmedContent.split("\\s+").length;
    }
// Counts the number of characters in a message
        public int countCharacters(@Nonnull final Message message) {
            logger.info("Counting characters in message");
            if (message.getContent() == null) {
                logger.severe("Message content is null");
                throw new IllegalArgumentException("Message content cannot be null.");
            }
            return message.getContent().length();
        }

    // Processes a message by appending a prefix
    @Nonnull
    public Message processMessage(@Nonnull final Message message) {
        logger.info("Processing message: " + message.getContent());
        if (message.getContent() == null) {
            logger.severe("Input message content is null");
            throw new IllegalArgumentException("Message content cannot be null.");
        }
        String processedContent = "Processed: " + message.getContent();
        return new Message(processedContent, message.getSender(), message.getReceiver(), message.getTimestamp());
    }

    // Replaces a target substring with a replacement in the original message
    @Nullable
    public Message replaceMessage(@Nullable final Message message, @Nullable final String target, @Nullable final String replacement) {
        logger.info("Replacing target: " + target + " with replacement: " + replacement);
        if (message == null || target == null || replacement == null) {
            logger.warning("One of the inputs is null");
            return null;
        }
        String replacedContent = message.getContent().replace(target, replacement);
        return new Message(replacedContent, message.getSender(), message.getReceiver(), message.getTimestamp());
    }

    // Truncates a message to a specified length
    @Nullable
    public Message truncateMessage(@Nullable final Message message, final int length) {
        logger.info("Truncating message to length: " + length);
        if (message == null || length < 0) {
            logger.warning("Invalid input for truncation");
            return null;
        }
        String truncatedContent = message.getContent().length() <= length ? message.getContent() : message.getContent().substring(0, length);
        return new Message(truncatedContent, message.getSender(), message.getReceiver(), message.getTimestamp());
    }

    // Reverses the characters in a message
    @Nullable
    public Message reverseMessage(@Nullable final Message message) {
        logger.info("Reversing message");
        if (message == null) {
            logger.warning("Message is null");
            return null;
        }
        String reversedContent = new StringBuilder(message.getContent()).reverse().toString();
        return new Message(reversedContent, message.getSender(), message.getReceiver(), message.getTimestamp());
    }

    // Decodes a message by shifting characters backward
    @Nullable
    public Message decodeMessage(@Nullable final Message message, final int shift) {
        logger.info("Decoding message with shift: " + shift);
        if (message == null || shift < 0) {
            logger.warning("Invalid input for decoding");
            return null;
        }
        String decodedContent = message.getContent().chars()
                .mapToObj(c -> {
                    if (Character.isLetter(c)) {
                        char base = Character.isLowerCase(c) ? 'a' : 'A';
                        return (char) ((c - base - shift + 26) % 26 + base);
                    } else {
                        return (char) c;
                    }
                })
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
        return new Message(decodedContent, message.getSender(), message.getReceiver(), message.getTimestamp());
    }

    // Encodes a message by shifting characters forward
    @Nullable
    public Message encodeMessage(@Nullable final Message message, final int shift) {
        logger.info("Encoding message with shift: " + shift);
        if (message == null || shift < 0) {
            logger.warning("Invalid input for encoding");
            return null;
        }
        String encodedContent = message.getContent().chars()
                .mapToObj(c -> {
                    if (Character.isLetter(c)) {
                        char base = Character.isLowerCase(c) ? 'a' : 'A';
                        return (char) ((c - base + shift) % 26 + base);
                    } else {
                        return (char) c;
                    }
                })
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
        return new Message(encodedContent, message.getSender(), message.getReceiver(), message.getTimestamp());
    }

    // Formats a message using a specified format
    @Nullable
    public Message formatMessage(@Nullable final Message message, @Nullable final String format) {
        logger.info("Formatting message with format: " + format);
        if (message == null || format == null) {
            logger.severe("Message or format is null");
            throw new IllegalArgumentException("Message and format must not be null");
        }
        String formattedContent = String.format(format, message.getContent());
        return new Message(formattedContent, message.getSender(), message.getReceiver(), message.getTimestamp());
    }
}