package com.example.demo.Service;


import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Random;

@Service
public class MouseService {

    private final Robot robot;
    private final Random random;

    public MouseService() throws AWTException {
        if (GraphicsEnvironment.isHeadless()) {
            throw new AWTException("Headless environment detected");
        } else {
            this.robot = new Robot();
        }
        this.random = new Random();
    }

    public void clickAndTypeInNotepad() {
        if (robot != null) {
            // Assuming the cursor is on the Notepad window
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

            // Wait a bit before typing
            robot.delay(500);

            // Type 100 random words
            for (int i = 0; i < 100; i++) {
                String word = generateRandomWord();
                typeString(word + " ");
            }
        }
    }

    private String generateRandomWord() {
        int wordLength = random.nextInt(5) + 3; // Words of length 3 to 7
        StringBuilder word = new StringBuilder(wordLength);
        for (int i = 0; i < wordLength; i++) {
            char c = (char) ('a' + random.nextInt(26));
            word.append(c);
        }
        return word.toString();
    }

    private void typeString(String str) {
        for (char c : str.toCharArray()) {
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
            if (KeyEvent.CHAR_UNDEFINED != keyCode) {
                robot.keyPress(keyCode);
                robot.keyRelease(keyCode);
            }
            robot.delay(50); // Small delay between keystrokes
        }
    }
}