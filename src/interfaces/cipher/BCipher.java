package interfaces.cipher;

import java.util.Objects;

public class BCipher implements ICipher {
    private String text;
    private int i;

    public BCipher() {

    }

    public BCipher(String text, int i) {
        this.text = text;
        this.i = i;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public void encode() {
        if (text == null) return;

        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                char shifted = (char) ((ch - base + i) % 26 + base);
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
                char shifted = (char) ((ch - base - i + 26) % 26 + base);
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
        if (!(o instanceof BCipher bCipher)) return false;
        return i == bCipher.i && Objects.equals(text, bCipher.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, i);
    }

    @Override
    public String toString() {
        return "BCipher{" +
                "text='" + text + '\'' +
                ", i=" + i +
                '}';
    }
}
