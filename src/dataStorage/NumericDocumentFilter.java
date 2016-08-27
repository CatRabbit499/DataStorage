package dataStorage;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

class NumericDocumentFilter extends DocumentFilter {

    @Override
    public void replace(FilterBypass fb, int i, int i1, String string, AttributeSet as) throws BadLocationException {
        for(int n = string.length(); n > 0; n--) {                // An inserted string may be more than a single character i.e a copy and paste of 'aaa123d', also we iterate from the back as super.XX implementation will put last insterted string first and so on thus 'aa123d' would be 'daa', but because we iterate from the back its 'aad' like we want
            char c = string.charAt(n - 1);                        // Get a single character of the string
            if(Character.isDigit(c) || c == ' ') {                // If its an numeric character or white space
                super.replace(fb, i, i1, String.valueOf(c), as);  // Allow update to take place for the given character
            }
        }
    }

    @Override
    public void remove(FilterBypass fb, int i, int i1) throws BadLocationException {
        super.remove(fb, i, i1);
    }

    @Override
    public void insertString(FilterBypass fb, int i, String string, AttributeSet as) throws BadLocationException {
        super.insertString(fb, i, string, as);

    }
}