//TMF 2634 Java for Multimedia Programming Assignment
//TMFG2_34
//A program that allows the user to input a String literal, and 
//the program shall display an encoded String literal as an output. 

package my.secretcode;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class SecretCode extends javax.swing.JFrame {
    /**
     * Creates new form SecretCodeUI
     */
    @SuppressWarnings("serial")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        jButtonReset = new javax.swing.JButton();
        jTextField_Input = new javax.swing.JTextField();
        jLabel_Encode = new javax.swing.JLabel();
        jLabel_Input = new javax.swing.JLabel();
        jButtonEncode = new javax.swing.JButton();
        jLabelTitle = new javax.swing.JLabel();
        jButtonExit = new javax.swing.JButton();
        jTextField_Encode = new javax.swing.JTextField();
        jLabel_sLength = new javax.swing.JLabel();
        jTextField_sLength = new javax.swing.JTextField();
        jLabel_Pic = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Secret Code");
        setSize(new java.awt.Dimension(530, 343));

        jPanel.setLayout(null);

        jButtonReset.setText("Reset");
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });
        jPanel.add(jButtonReset);
        jButtonReset.setBounds(312, 246, 80, 32);

        jTextField_Input.setText("write some words here");
        jTextField_Input.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_InputKeyPressed(evt);
            }
        });
        jPanel.add(jTextField_Input);
        jTextField_Input.setBounds(200, 103, 235, 30);

        jLabel_Encode.setText("Encoded Words:");
        jLabel_Encode.setOpaque(true);
        jPanel.add(jLabel_Encode);
        jLabel_Encode.setBounds(89, 151, 93, 16);

        jLabel_Input.setText("Input Words:");
        jLabel_Input.setOpaque(true);
        jPanel.add(jLabel_Input);
        jLabel_Input.setBounds(110, 107, 72, 16);

        jButtonEncode.setText("Encode");
        jButtonEncode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEncodeActionPerformed(evt);
            }
        });
        jPanel.add(jButtonEncode);
        jButtonEncode.setBounds(163, 246, 80, 32);

        jLabelTitle.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabelTitle.setText("Secret Code");
        jLabelTitle.setOpaque(true);
        jPanel.add(jLabelTitle);
        jLabelTitle.setBounds(159, 33, 210, 35);

        jButtonExit.setText("Exit");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });
        jPanel.add(jButtonExit);
        jButtonExit.setBounds(420, 290, 60, 32);

        jTextField_Encode.setEditable(false);
        jTextField_Encode.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jPanel.add(jTextField_Encode);
        jTextField_Encode.setBounds(200, 145, 235, 30);

        jLabel_sLength.setText("String Length:");
        jLabel_sLength.setOpaque(true);
        jPanel.add(jLabel_sLength);
        jLabel_sLength.setBounds(103, 190, 79, 16);

        jTextField_sLength.setEditable(false);
        jPanel.add(jTextField_sLength);
        jTextField_sLength.setBounds(200, 190, 50, 30);

        jLabel_Pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/secretcode/lock.jpg"))); // NOI18N
        jLabel_Pic.setOpaque(true);
        jPanel.add(jLabel_Pic);
        jLabel_Pic.setBounds(0, 0, 500, 340);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
   
    private String inputString;
    private int stringLength;
    private String outputString;
    
    //default constructor
    public SecretCode() {
        initComponents();
    }
    
    //constructor
    public SecretCode(String inputString) {
        initComponents();
        this.inputString = inputString;
    }
    
    //compute the number of characters inside inputString,
    //excluding whitespace(s).
    public int getStringLength (String inputString) {
        this.inputString = inputString;
        stringLength = inputString.replace(" ", "").length();

        return stringLength;
    }
    
    //perform a check on inputString
    public boolean checkStringValidity (String inputString) {
        this.inputString = inputString;

        //check to ensure inputString only has a-z or whitespace.
        //Note that the space before a-z is important as it means whitespace
        Pattern condition = Pattern.compile("^[ a-z]+$");
        Matcher check = condition.matcher(inputString);
        boolean valid = check.matches();

        return valid;
    }
    
    //shift each character forward n position(s), with n equals to the 
    //number of characters (excluding whitespace) inside inputString
    public String shiftChar (String inputString, int stringLength) {
        this.inputString = inputString;
        char code;
        char[] allChars = {'a','b','c','d','e','f','g','h','i','j',
              'k','l','m','n','o','p','q','r','s','t','u','v','w',
              'x','y','z',' '};

        if (this.checkStringValidity(inputString) == false) {     
            JOptionPane.showMessageDialog(null,"Input can only contain "
                    + "lowercase 'a' to 'z' or whitespace."
                    + "\nPlease enter a new input.",
                    "ERROR",JOptionPane.ERROR_MESSAGE);
        }
        else {
            int numOfChar = this.getStringLength(inputString);
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < stringLength; i++) {
                Character letter = inputString.charAt(i);
                int j = 0;

                while (letter != allChars[j]) {
                    j++;
                }
                
                int pos = (j + numOfChar) % allChars.length;
                code = allChars[pos];
                sb.append(code);
            }
            outputString = sb.toString();
        }         
        return outputString;
    }    
    
    //reset button action listener
    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
        //set all text field to empty
        jTextField_Input.setText ("");
        jTextField_Encode.setText ("");
        jTextField_sLength.setText ("");
    }//GEN-LAST:event_jButtonResetActionPerformed

    //Input text field key listener. Enable user to press the "ENTER" button 
    //in keyboard to trigger the "Encode" button.
    private void jTextField_InputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_InputKeyPressed
        //Use "Enter key" as default for the encode button.
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
           jButtonEncode.doClick(); 
    }//GEN-LAST:event_jTextField_InputKeyPressed

    //the encode button action listener
    private void jButtonEncodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEncodeActionPerformed
        inputString = jTextField_Input.getText();
        SecretCode code = new SecretCode(inputString);
        jTextField_Encode.setText(code.shiftChar(inputString, inputString.length()));
        if(code.checkStringValidity(inputString) == true )
        jTextField_sLength.setText(String.valueOf(code.getStringLength(inputString)));
    }//GEN-LAST:event_jButtonEncodeActionPerformed

    //exit button action listener
    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        if(JOptionPane.showConfirmDialog(null, "Confirm want to Exit?", "Exit",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
            System.exit(0);}
    }//GEN-LAST:event_jButtonExitActionPerformed
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SecretCode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SecretCode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SecretCode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SecretCode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        new SecretCode().setVisible(true);
        /* Create and display the form */    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEncode;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabel_Encode;
    private javax.swing.JLabel jLabel_Input;
    private javax.swing.JLabel jLabel_Pic;
    private javax.swing.JLabel jLabel_sLength;
    private javax.swing.JPanel jPanel;
    private javax.swing.JTextField jTextField_Encode;
    private javax.swing.JTextField jTextField_Input;
    private javax.swing.JTextField jTextField_sLength;
    // End of variables declaration//GEN-END:variables
}

