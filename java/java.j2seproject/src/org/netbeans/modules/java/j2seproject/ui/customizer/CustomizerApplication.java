/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.netbeans.modules.java.j2seproject.ui.customizer;

import java.awt.Dimension;
import java.io.File;
import java.util.LinkedList;
import java.util.Map;
import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import org.netbeans.api.project.Project;
import org.netbeans.modules.java.j2seproject.J2SEProject;
import org.netbeans.modules.java.j2seproject.api.J2SECategoryExtensionProvider;
import org.netbeans.modules.java.j2seproject.api.J2SERunConfigProvider;
import org.openide.filesystems.FileUtil;
import org.openide.util.HelpCtx;
import org.openide.util.NbBundle;

/**
 * Customizer panel for general application information (title, vendor, description,
 * homepage and splash screen)
 * 
 * @author  Milan Kubec
 */
public class CustomizerApplication extends javax.swing.JPanel implements HelpCtx.Provider {
    
    private File lastImageFolder;
    private J2SEProject project;
    
    private java.util.List<J2SECategoryExtensionProvider> compProviders = new LinkedList<J2SECategoryExtensionProvider>();
    private int nextExtensionYPos;
    
    /** Creates new form CustomizerApplication */
    public CustomizerApplication(J2SEProjectProperties props) {
        initComponents();
        titleTextField.setDocument(props.APPLICATION_TITLE_DOC);
        vendorTextField.setDocument(props.APPLICATION_VENDOR_DOC);
        descTextArea1.setDocument(props.APPLICATION_DESC_DOC);
        homepageTextField.setDocument(props.APPLICATION_HOMEPAGE_DOC);
        splashTextField.setDocument(props.APPLICATION_SPLASH_DOC);

        this.project = props.getProject();
        for (J2SECategoryExtensionProvider compProvider : project.getLookup().lookupAll(J2SECategoryExtensionProvider.class)) {
            if( compProvider.getCategory() == J2SECategoryExtensionProvider.ExtensibleCategory.APPLICATION ) {
                if( addExtPanel(project,compProvider,nextExtensionYPos) ) {
                    compProviders.add(compProvider);
                    nextExtensionYPos++;
                }
            }
        }
        addPanelFiller(nextExtensionYPos);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        mainPanel = new javax.swing.JPanel();
        panelDescLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        vendorLabel = new javax.swing.JLabel();
        descLabel = new javax.swing.JLabel();
        homepageLabel = new javax.swing.JLabel();
        splashLabel = new javax.swing.JLabel();
        titleTextField = new javax.swing.JTextField();
        vendorTextField = new javax.swing.JTextField();
        homepageTextField = new javax.swing.JTextField();
        splashTextField = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        descTextArea1 = new javax.swing.JTextArea();
        extPanel = new javax.swing.JPanel();

        setLayout(new java.awt.GridBagLayout());

        mainPanel.setLayout(new java.awt.GridBagLayout());

        org.openide.awt.Mnemonics.setLocalizedText(panelDescLabel, org.openide.util.NbBundle.getMessage(CustomizerApplication.class, "CustomizerApplication.panelDescLabel.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        mainPanel.add(panelDescLabel, gridBagConstraints);

        titleLabel.setLabelFor(titleTextField);
        org.openide.awt.Mnemonics.setLocalizedText(titleLabel, org.openide.util.NbBundle.getMessage(CustomizerApplication.class, "CustomizerApplication.titleLabel.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 0, 0, 0);
        mainPanel.add(titleLabel, gridBagConstraints);

        vendorLabel.setLabelFor(vendorTextField);
        org.openide.awt.Mnemonics.setLocalizedText(vendorLabel, org.openide.util.NbBundle.getMessage(CustomizerApplication.class, "CustomizerApplication.vendorLabel.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 0, 0, 0);
        mainPanel.add(vendorLabel, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(descLabel, org.openide.util.NbBundle.getMessage(CustomizerApplication.class, "CustomizerApplication.descLabel.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 0, 0, 0);
        mainPanel.add(descLabel, gridBagConstraints);

        homepageLabel.setLabelFor(homepageTextField);
        org.openide.awt.Mnemonics.setLocalizedText(homepageLabel, org.openide.util.NbBundle.getMessage(CustomizerApplication.class, "CustomizerApplication.homepageLabel.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 0, 0);
        mainPanel.add(homepageLabel, gridBagConstraints);

        splashLabel.setLabelFor(splashTextField);
        org.openide.awt.Mnemonics.setLocalizedText(splashLabel, org.openide.util.NbBundle.getMessage(CustomizerApplication.class, "CustomizerApplication.splashLabel.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 0, 0);
        mainPanel.add(splashLabel, gridBagConstraints);

        titleTextField.setText(org.openide.util.NbBundle.getMessage(CustomizerApplication.class, "CustomizerApplication.titleTextField.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 0);
        mainPanel.add(titleTextField, gridBagConstraints);

        vendorTextField.setText(org.openide.util.NbBundle.getMessage(CustomizerApplication.class, "CustomizerApplication.vendorTextField.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 6, 0, 0);
        mainPanel.add(vendorTextField, gridBagConstraints);

        homepageTextField.setText(org.openide.util.NbBundle.getMessage(CustomizerApplication.class, "CustomizerApplication.homepageTextField.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 6, 0, 0);
        mainPanel.add(homepageTextField, gridBagConstraints);

        splashTextField.setText(org.openide.util.NbBundle.getMessage(CustomizerApplication.class, "CustomizerApplication.splashTextField.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 6, 0, 0);
        mainPanel.add(splashTextField, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(browseButton, org.openide.util.NbBundle.getMessage(CustomizerApplication.class, "CustomizerApplication.browseButton.text")); // NOI18N
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(3, 6, 0, 0);
        mainPanel.add(browseButton, gridBagConstraints);

        descTextArea1.setColumns(8);
        descTextArea1.setRows(4);
        jScrollPane.setViewportView(descTextArea1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 0);
        mainPanel.add(jScrollPane, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        add(mainPanel, gridBagConstraints);

        extPanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(extPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
        final JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode (JFileChooser.FILES_ONLY);
        chooser.setMultiSelectionEnabled(false);
        chooser.setFileFilter(new SplashFileFilter());
        if (lastImageFolder != null) {
            chooser.setCurrentDirectory(lastImageFolder);
        }
        chooser.setDialogTitle(NbBundle.getMessage(CustomizerApplication.class, "LBL_Select_Splash_Image"));
        if (JFileChooser.APPROVE_OPTION == chooser.showOpenDialog(this)) {
            File file = FileUtil.normalizeFile(chooser.getSelectedFile());
            splashTextField.setText(file.getAbsolutePath());
            lastImageFolder = file.getParentFile();
        }
    }//GEN-LAST:event_browseButtonActionPerformed
    
    private static class SplashFileFilter extends FileFilter {
        
        // XXX should check size of images?
        public boolean accept(File f) {
            if (f.isDirectory()) {
                return true;
            }
            String name = f.getName();
            int index = name.lastIndexOf('.');
            if (index > 0 && index < name.length() - 1) {
                String ext = name.substring(index+1).toLowerCase();
                if ("gif".equals(ext) || "png".equals(ext) || "jpg".equals(ext)) {  //NOI18N
                    return true;
                }
            }
            return false;
        }
        
        public String getDescription() {
            return NbBundle.getMessage(CustomizerApplication.class, "TXT_SplashImageFiles");
        }
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseButton;
    private javax.swing.JLabel descLabel;
    private javax.swing.JTextArea descTextArea1;
    private javax.swing.JPanel extPanel;
    private javax.swing.JLabel homepageLabel;
    private javax.swing.JTextField homepageTextField;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel panelDescLabel;
    private javax.swing.JLabel splashLabel;
    private javax.swing.JTextField splashTextField;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField titleTextField;
    private javax.swing.JLabel vendorLabel;
    private javax.swing.JTextField vendorTextField;
    // End of variables declaration//GEN-END:variables

    public HelpCtx getHelpCtx() {
        return new HelpCtx(CustomizerApplication.class);
    }
    
    private boolean addExtPanel(Project p, J2SECategoryExtensionProvider compProvider, int gridY) {
        if (compProvider != null) {
            J2SECategoryExtensionProvider.ConfigChangeListener ccl = new J2SECategoryExtensionProvider.ConfigChangeListener() {
                public void propertiesChanged(Map<String, String> updates) {
                }
            };
            JComponent comp = compProvider.createComponent(p, ccl);
            if (comp != null) {
                java.awt.GridBagConstraints constraints = new java.awt.GridBagConstraints();
                constraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
                constraints.gridx = 0;
                constraints.gridy = gridY;
                constraints.weightx = 1.0;
                extPanel.add(comp, constraints);
                return true;
            }
        }
        return false;
    }

    private void addPanelFiller(int gridY) {
        java.awt.GridBagConstraints constraints = new java.awt.GridBagConstraints();
        constraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        constraints.gridx = 0;
        constraints.gridy = gridY;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        extPanel.add( new Box.Filler(
                new Dimension(), 
                new Dimension(),
                new Dimension(10000,10000) ),
                constraints);
    }

}