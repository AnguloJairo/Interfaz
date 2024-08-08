import javax.swing.JButton;

import UserInterface.IAStyle;

public class PatButton extends JButton {
    public PatButton(String text) {
        super(text);
        setFont(IAStyle.FONT);
        setForeground(IAStyle.COLOR_FONT);
        setCursor(IAStyle.CURSOR_HAND);
        setBorder(IAStyle.createBorderRect());
    }
}
