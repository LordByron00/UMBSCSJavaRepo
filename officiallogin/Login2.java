package officiallogin;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import com.intellij.uiDesigner.core.*;

public class Login2 {
    public Login2() {
        initComponents();
    }

    public static void main(String[] a) {
        OfficialLogIn frame = new OfficialLogIn();
        frame.setTitle("Login Form");
        frame.setVisible(true);
        frame.setBounds(600, 100, 370, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);


    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - unknown
        var panel1 = new JPanel();

        //======== panel1 ========
        {
            panel1.setBorder(new CompoundBorder(new TitledBorder(new EmptyBorder(
                    0, 0, 0, 0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", TitledBorder.CENTER, TitledBorder
                    .BOTTOM, new Font("Dia\u006cog", Font.BOLD, 12), Color.
                    red), panel1.getBorder()));
            panel1.addPropertyChangeListener(new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent e) {
                    if ("bord\u0065r".equals(e.getPropertyName())) throw new RuntimeException();
                }
            });
            panel1.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
    }
}