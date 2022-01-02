/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje;

import java.io.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Rayene Bech
 */
public class AddSubscriptionPlan extends javax.swing.JFrame {
    //This list is to keep track of all previous gsm providers
    ArrayList<GSMProvider> gsmProviders;
    //This list is to keep track of all previous cable providers
    ArrayList<CableProvider> cableProviders;
    //This list is to keep track of all previous subscription plans
    ArrayList<SubscriptionPlan> subscriptionPlan;
    //This String array is to generate all the names of available providers according to the type of the provider:
    //GSM or Cable into the Combo Box.
    String [] cableTypes, gsmTypes;
    /**
     * Creates new form AddServiceProvider
     */
    public AddSubscriptionPlan() {
        initComponents();
        gsmProviders = new ArrayList<GSMProvider>();
        cableProviders= new ArrayList<CableProvider>();
        subscriptionPlan =  new ArrayList<SubscriptionPlan>();
        
        populateArrayList(); //WE read first all available providers
        
        if(cableProviders.isEmpty() && gsmProviders.isEmpty()){ //We cannot add a new Subscription Plan if we do not have any provider
            JOptionPane.showMessageDialog(null, "Please first add some service Providers");
        }
        else{
            //We prepare the String that will be listed in the Combo Box according to the type of Provider
            // Example: we would have TURKCELL and Vodafone for GSM Provider and Local for Cable Provider
            cableTypes = new String[cableProviders.size()];
            gsmTypes = new String[gsmProviders.size()];
            for(int i=0; i< cableProviders.size(); i++){
                cableTypes[i]= cableProviders.get(i).getName();
            }
            for(int i=0; i< gsmProviders.size(); i++){
                gsmTypes[i]= gsmProviders.get(i).getName();
            }
        }
        

    }
    
    public void populateArrayList(){
        //Read all previous cable providers from the file cable.dat into the list cableProviders
        try{
            FileInputStream file =  new FileInputStream("cable.dat");
            ObjectInputStream inputFile = new ObjectInputStream(file);
            boolean EOF = false;
            while(!EOF){
                try{
                    cableProviders.add( (CableProvider)inputFile.readObject());
                }
                catch(EOFException e){
                    EOF = true;
                }
                catch(Exception f){
                    
                }
            }
            inputFile.close();
            
        }
        catch(IOException e){
           JOptionPane.showMessageDialog(null, e.getMessage());
        }
        //Read all previous GSM Providers from the file gsm.dat into the list gsmProviders
        try{
            FileInputStream file =  new FileInputStream("gsm.dat");
            ObjectInputStream inputFile = new ObjectInputStream(file);
            boolean EOF = false;
            while(!EOF){
                try{
                    gsmProviders.add( (GSMProvider)inputFile.readObject());
                }
                catch(EOFException e){
                    EOF = true;
                }
                catch(Exception f){
                    
                }
            }
            inputFile.close();
            
        }
        catch(IOException e){
           JOptionPane.showMessageDialog(null, e.getMessage());
        }
        //Read all previous subscription plans from the file subscriptionPlans.dat into the list subscriptionPlan
         try{
            FileInputStream file =  new FileInputStream("subscriptionPlans.dat");
            ObjectInputStream inputFile = new ObjectInputStream(file);
            boolean EOF = false;
            while(!EOF){
                try{
                    subscriptionPlan.add( (SubscriptionPlan)inputFile.readObject());
                }
                catch(EOFException e){
                    EOF = true;
                }
                catch(Exception f){
                    
                }
            }
            inputFile.close();
            
        }
        catch(IOException e){
           JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public void saveTOFile(){
        //This function is to save all Subscription Plans including the new added to the file subscriptionPlans.dat
        try{
            FileOutputStream file= new FileOutputStream("subscriptionPlans.dat");
            ObjectOutputStream outputFile =  new ObjectOutputStream(file);
            
            for(int i=0; i< subscriptionPlan.size(); i++){
                outputFile.writeObject(subscriptionPlan.get(i));
            }
            
            outputFile.close();
            JOptionPane.showMessageDialog(null, "Successfully Saved");
            this.dispose();
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getStackTrace());
            
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        providerType = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        providerName = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        planName = new javax.swing.JTextField();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Subscription plan");

        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Add a new SubscrIptIon plan");

        jLabel2.setText("Please select the type of the Service Provider");

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        providerType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "GSM Provider", "Cable Provider" }));
        providerType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                providerTypeActionPerformed(evt);
            }
        });

        jLabel3.setText("Please enter the name of the Service  Provider");

        providerName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        providerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                providerNameActionPerformed(evt);
            }
        });

        jLabel4.setText("Please enter the name of the Subscription Plan");

        planName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                planNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(126, 126, 126))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(planName))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(providerName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(providerType, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(providerType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(providerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(planName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(23, 23, 23))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         //When the user clicks on Submit button
        if(providerType.getSelectedIndex()==0 || planName.getText().isEmpty()){ //check if the user entered all the fields
            JOptionPane.showMessageDialog(null, "Please enter all fields");
        }
        else{
            SubscriptionPlan plan;
            if(providerType.getSelectedIndex()==1){
                //If the selected Service Provider is GSM we create new Plan with GSM Provider
                GSMProvider gsmProvider = new GSMProvider(gsmTypes[providerName.getSelectedIndex()]);
                plan = new SubscriptionPlan (planName.getText(), gsmProvider);
            }
            else{ //If the selected Service Provider is Cable we  create new Plan with Cable Provider
                CableProvider cableProvider = new CableProvider(gsmTypes[providerName.getSelectedIndex()]);
               plan = new SubscriptionPlan (planName.getText(), cableProvider);
            }
            
            try{
                subscriptionPlan.add(plan);
            }
            catch(NullPointerException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            saveTOFile();
            
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void providerTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_providerTypeActionPerformed
        //Adjust data for Combo Box
        if(providerType.getSelectedIndex()==1){
            //If the selected Service Provider is GSM we list all the names (TURKCELL, VODAFONE) in the Combo Box
            providerName.setModel(new javax.swing.DefaultComboBoxModel<>(gsmTypes));
        }
        else if(providerType.getSelectedIndex()==2){
            //If the selected Service Provider is Cable we list all the names (Locale)
            providerName.setModel(new javax.swing.DefaultComboBoxModel<>(cableTypes));
        }
        else if(providerType.getSelectedIndex()==0){
             providerName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Select"}));
        }
    }//GEN-LAST:event_providerTypeActionPerformed

    private void providerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_providerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_providerNameActionPerformed

    private void planNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_planNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_planNameActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(AddSubscriptionPlan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddSubscriptionPlan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddSubscriptionPlan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddSubscriptionPlan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddSubscriptionPlan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField planName;
    private javax.swing.JComboBox<String> providerName;
    private javax.swing.JComboBox<String> providerType;
    // End of variables declaration//GEN-END:variables
}
