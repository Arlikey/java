package interfaces.cipher;

import java.util.Objects;

public class ACipher implements ICipher {
    private String text;

    public ACipher() {
    }

    public ACipher(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void encode() {
        if (text == null) return;

        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                char shifted = (char) ((ch - base + 1) % 26 + base);
                result.append(shifted);
            } else {
                result.append(ch);
            }
        }
        text = result.toString();
    }

    @Override
    public void decode() {
        if (text == null) return;

        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                char shifted = (char) ((ch - base - 1 + 26) % 26 + base);
                result.append(shifted);
            } else {
                result.append(ch);
            }
        }
        text = result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ACipher aCipher)) return false;
        return Objects.equals(text, aCipher.text);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(text);
    }

    @Override
    public String toString() {
        return "ACipher{" +
                "text='" + text + '\'' +
                '}';
    }
}
