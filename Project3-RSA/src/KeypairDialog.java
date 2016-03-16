/*
 * Project 3 - RSA Algorithm
 * By Nick Zakharov and Andrew Podgorski
 * CS 342 - UIC - Spring 2016
 * ---
 * KeypairDialog Class
 * This is an extra GUI class that will be used to create an extra GUI window, allowing our main window to be a little cleaner.
 * This dialog will ask the user to specify prime numbers for their generated keypair, or have the Java program generate them for it.
 */

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class KeypairDialog extends JDialog {
 private static final long serialVersionUID = 5082502657415599101L;
 private final JPanel contentPanel = new JPanel();
 private JTextField txtResourceFilePath;
 private static boolean alreadyExists = false;
 private static JTextArea txtrPrime1;
 private static JTextArea txtrPrime2;
 

 /**
  * Create the dialog.
  */
 public KeypairDialog() {
   if (!alreadyExists) {
  setBounds(100, 100, 450, 300);
  getContentPane().setLayout(new BorderLayout());
  contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
  getContentPane().add(contentPanel, BorderLayout.CENTER);
  contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));
  {
   JSplitPane splitPane = new JSplitPane();
   splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
   splitPane.setResizeWeight(0.75);
   contentPanel.add(splitPane);
   {
    JPanel split_top_panel = new JPanel();
    splitPane.setLeftComponent(split_top_panel);
    split_top_panel.setLayout(new GridLayout(2, 2, 0, 0));
    {
     JLabel lblPrime1 = new JLabel("Prime #1:");
     split_top_panel.add(lblPrime1);
    }
    {
     txtrPrime1 = new JTextArea();
     txtrPrime1.setText("prime1");
     split_top_panel.add(txtrPrime1);
    }
    {
     JLabel lblPrime2 = new JLabel("Prime #2:");
     split_top_panel.add(lblPrime2);
    }
    {
     txtrPrime2 = new JTextArea();
     txtrPrime2.setText("prime2");
     split_top_panel.add(txtrPrime2);
    }
   }
   {
    JPanel split_bottom_panel = new JPanel();
    splitPane.setRightComponent(split_bottom_panel);
    split_bottom_panel.setLayout(new BoxLayout(split_bottom_panel, BoxLayout.PAGE_AXIS));
    {
     JButton btnGeneratePrimes = new JButton("Generate Primes");
     btnGeneratePrimes.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent arg0) {
    //select primes from resource file
     HUI choice = MainWindow.resFile.selectPrime();
     txtrPrime1.setText(choice.toString());
     choice = MainWindow.resFile.selectPrime(choice);
     txtrPrime2.setText(choice.toString());
   }
  });
     split_bottom_panel.add(btnGeneratePrimes);
    }
    {
     JLabel lblLocationOfPrime = new JLabel("Location of Prime # Resource File: ");
     split_bottom_panel.add(lblLocationOfPrime);
    }
    {
     txtResourceFilePath = new JTextField();
     txtResourceFilePath.setEditable(false);
     txtResourceFilePath.setText(MainWindow.basePath + MainWindow.RESOURCE_FILE_NAME);
     split_bottom_panel.add(txtResourceFilePath);
     txtResourceFilePath.setColumns(10);
    }
   }
  }
  {
   JPanel buttonPane = new JPanel();
   buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
   getContentPane().add(buttonPane, BorderLayout.SOUTH);
   {
    JButton okButton = new JButton("OK");
    okButton.addActionListener(new ActionListener() {
     public void actionPerformed(ActionEvent e) {
       alreadyExists = false;
      //process primes
       //TODO USE RSA CLASS TO PROCESS PRIMES INTO KEYPAIR
      //close the dialog:
      KeypairDialog.this.setVisible(false);
      KeypairDialog.this.dispatchEvent(new WindowEvent(
        KeypairDialog.this, WindowEvent.WINDOW_CLOSING));
     }
    });
    okButton.setActionCommand("OK");
    buttonPane.add(okButton);
    getRootPane().setDefaultButton(okButton);
   }
   {
    JButton cancelButton = new JButton("Cancel");
    cancelButton.addActionListener(new ActionListener() {
     public void actionPerformed(ActionEvent e) {
      //close the dialog:
      KeypairDialog.this.setVisible(false);
      KeypairDialog.this.dispatchEvent(new WindowEvent(
        KeypairDialog.this, WindowEvent.WINDOW_CLOSING));
      alreadyExists = false;
     }
    });
    cancelButton.setActionCommand("Cancel");
    buttonPane.add(cancelButton);
   }
  }
   alreadyExists = true;
 } else {
   System.out.println("Attempted to create another dialog on top of already existing dialog.");
 }
 }
 
 public static boolean alreadyExists() {
   return alreadyExists;
 }

}
