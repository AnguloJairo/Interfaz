// package UserInterface;

// import java.awt.Color;
// import java.awt.Cursor;
// import java.awt.Font;
// import java.net.URL;
// import javax.swing.BorderFactory;
// import javax.swing.SwingConstants;
// import javax.swing.border.CompoundBorder;
// import javax.swing.border.EmptyBorder;
// import javax.swing.border.LineBorder;

// public class IAStyle {
//     public static final Color COLOR_FONT = new Color(200, 150, 50);
//     public static final Color COLOR_FONT_LIGHT = new Color(100, 100, 100);
//     public static final Color COLOR_CURSOR = Color.black;
//     public static final Color COLOR_BORDER = Color.lightGray;
//     public static final Font FONT= new Font("JetBrains Mono", Font.PLAIN, 14);
//     public static final Font FONT_BOLD= new Font("JetBrains Mono", Font.BOLD | Font.PLAIN, 14);
//     public static final Font FONT_SMALL= new Font("JetBrains Mono", Font.PLAIN | Font.PLAIN, 10);

//     public static final int ALIGMENT_LEFT = SwingConstants.LEFT;
//     public static final int ALIGMENT_RIGHT = SwingConstants.RIGHT;
//     public static final int ALIGMENT_CENTER = SwingConstants.CENTER;

//     public static final Cursor CURSOR_HAND = new Cursor(Cursor.HAND_CURSOR);
//     public static final Cursor CURSOR_DAFAUL = new Cursor(Cursor.DEFAULT_CURSOR);

//     public static final URL URL_MAIN = IAStyle.class.getResource("");

//     public static final CompoundBorder createBorderRect(){
//         return BorderFactory.createCompoundBorder(new LineBorder(Color.lightGray),
//                                                   new EmptyBorder(5, 5, 5, 5)  );
//     }

//     // public static final void showMsg(String msg){
//     //     JOptionPane.showMessageDialog(null, msg, "IABot".INFORMATION_MESSAGE);
//     // }

//     // public static final void showMsgError(String msg){
//     //     JOptionPane.showMessageDialog(null, msg, "IABot".INFORMATION.OK_OPTION);
//     // }

//     // public static final void showConfirmYesNo(String msg){
//     //     return (JOptionPane.showMessageDialog(null, msg, "IABot".INFORMATION.YES_NO_OPTION) --JOptionPane.YES_OPTION);
//     // }

// }


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.net.URL;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class IAStyle {
    public static final Color COLOR_FONT = new Color(200, 150, 50);
    public static final Color COLOR_FONT_LIGHT = new Color(100, 100, 100);
    public static final Color COLOR_CURSOR = Color.black;
    public static final Color COLOR_BORDER = Color.lightGray;
    public static final Font FONT = new Font("JetBrains Mono", Font.PLAIN, 14);
    public static final Font FONT_BOLD = new Font("JetBrains Mono", Font.BOLD | Font.PLAIN, 14);
    public static final Font FONT_SMALL = new Font("JetBrains Mono", Font.PLAIN, 10);

    public static final int ALIGNMENT_LEFT = SwingConstants.LEFT;
    public static final int ALIGNMENT_RIGHT = SwingConstants.RIGHT;
    public static final int ALIGNMENT_CENTER = SwingConstants.CENTER;

    public static final Cursor CURSOR_HAND = new Cursor(Cursor.HAND_CURSOR);
    public static final Cursor CURSOR_DEFAULT = new Cursor(Cursor.DEFAULT_CURSOR);

    // Update to use the correct relative path to resources
    public static final URL URL_SPLASH = IAStyle.class.getResource("/ImagenLogo/logo.jpeg");
    public static final CompoundBorder createBorderRect() {
        return BorderFactory.createCompoundBorder(new LineBorder(Color.lightGray),
                new EmptyBorder(5, 5, 5, 5));
    }

    // Method to show a message dialog
    public static void showMsg(String msg) {
        JOptionPane.showMessageDialog(null, msg, "IABot", JOptionPane.INFORMATION_MESSAGE);
    }

    // Method to show an error message dialog
    public static void showMsgError(String msg) {
        JOptionPane.showMessageDialog(null, msg, "IABot", JOptionPane.ERROR_MESSAGE);
    }

    // Method to show a confirmation dialog and return the result
    public static int showConfirmYesNo(String msg) {
        return JOptionPane.showConfirmDialog(null, msg, "IABot", JOptionPane.YES_NO_OPTION);
    }
}

