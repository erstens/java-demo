/*
 * Created by JFormDesigner on Mon Dec 24 16:57:25 CST 2018
 */

package com.demo.swing;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;

/**
 * @author wang'ao
 */
public class MainJPanel extends JPanel {

    public static final int WIDTH = 450 ;
    public static final int HEIGHT = 500 ;

    public static final int PANEL_CONTEXT_WIDTH = 400 ;
    public static final int PANEL_CONTEXT_HEIGHT = 220 ;

    public static final int PANEL_INNER_WIDTH = 350 ;
    public static final int PANEL_INNER_HEIGHT = 200 ;

    public static final int TEMPLATE_LEFT_WIDTH = 95 ;
    public static final int TEMPLATE_RIGHT_WIDTH = 300 ;
    public static final int TEMPLATE_HEIGHT = 150 ;

    public static final int EXPAND_HEIGHT = TEMPLATE_HEIGHT + 20 ;

    private JButton submitButton;
    private JLabel expandLink;
    private JList modelTypeList;

    private JTextArea jTextArea;
    private JPanel templatePanel;
    private JTextField hostField;
    private JTextField userField;
    private JTextField pwdField;
    private JTextField dbField;
    private JTextField tableField;
    private JCheckBox entityCheckBox;
    private JCheckBox daoCheckBox;
    private JTextField jFileChooser;

    public MainJPanel() {
        JPanel baseArea = getBaseArea();
        JPanel summitButtonArea = getSubmitButtonArea();
        JPanel templateLinkArea = getTemplateLinkArea();
        JPanel templateArea = getTemplateArea();

        //init property
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBorder(BorderFactory.createEtchedBorder());

        //init area panels .
        this.add(baseArea);
        this.add(summitButtonArea);
        this.add(templateLinkArea);
        this.add(templateArea);

        //init listeners .
        this.expandLink.addMouseListener(expandLinkClick);
        this.modelTypeList.addListSelectionListener(listSelectionListener);
        this.submitButton.addActionListener(buttonClick);
        this.jTextArea.addKeyListener(textAreaKeyListener);
        this.jFileChooser.addMouseListener(fileChooseListener);

        //init by data .
        this.initFromStorage() ;

    }
    public void initFromStorage() {
        if(DataMap.alreadeyInited()) {
            DataMap dataMap = DataMap.getInstance();
            hostField.setText(dataMap.getHost());
            userField.setText(dataMap.getUser());
            pwdField.setText(dataMap.getPwd());
            dbField.setText(dataMap.getDb());
            tableField.setText(dataMap.getTable());
            jFileChooser.setText(dataMap.getOutput());
            Optional.ofNullable(dataMap.getModelType()).map(Map::keySet).orElseGet(HashSet::new).stream().forEach(s -> {
                String key = String.valueOf(s);
                if ("dao".equals(key)) {
                    daoCheckBox.setSelected(true);
                    DataMapTemplate.dao = String.valueOf(dataMap.getModelType().get(key));
                }
                if ("entity".equals(key)) {
                    entityCheckBox.setSelected(true);
                    DataMapTemplate.entity = String.valueOf(dataMap.getModelType().get(key));
                }
            });
        }
        if (!DataMap.alreadeyInited()) {
            daoCheckBox.setSelected(true);
            entityCheckBox.setSelected(true);
            modelTypeList.setSelectedIndex(0);
            jTextArea.setText(ExampleData.DAO);
            jFileChooser.setText(ExampleData.USER_DIR);

            DataMapTemplate.entity = ExampleData.ENTITY;
            DataMapTemplate.dao = ExampleData.DAO;
        }
    }
    MouseListener fileChooseListener = new MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e) {
            JFileChooser jfc = new JFileChooser();
            jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY );
            jfc.setDialogTitle("select an output path ");
            jfc.setAcceptAllFileFilterUsed(false);
            jfc.setFileHidingEnabled(true);
            jfc.setMultiSelectionEnabled(false);

            int ret = jfc.showOpenDialog(null);
            if (JFileChooser.APPROVE_OPTION == ret) {
                jFileChooser.setText(jfc.getSelectedFile().getPath());
            }else if(JFileChooser.CANCEL_OPTION != ret){
                JOptionPane.showMessageDialog(null, "please re-select directory .", "error", JOptionPane.ERROR_MESSAGE);
            }
        }
    };
    KeyListener textAreaKeyListener = new KeyAdapter(){
        @Override
        public void keyReleased(KeyEvent e) {
            if ("dao".equals(String.valueOf(modelTypeList.getSelectedValue()))) {
                DataMapTemplate.dao = jTextArea.getText();
            }
            if ("entity".equals(String.valueOf(modelTypeList.getSelectedValue()))) {
                DataMapTemplate.entity = jTextArea.getText();
            }
        }
    };
    MouseListener expandLinkClick = new MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e) {
            if (templatePanel.isVisible()) {
                templatePanel.setVisible(false);
                return ;
            }
            if (!templatePanel.isVisible()) {
                templatePanel.setVisible(true);
                return ;
            }
        }
    };
    ListSelectionListener listSelectionListener = e -> {
        if ("dao".equals(String.valueOf(modelTypeList.getSelectedValue()))) {
            jTextArea.setText(DataMapTemplate.dao);
        }
        if ("entity".equals(String.valueOf(modelTypeList.getSelectedValue()))) {
            jTextArea.setText(DataMapTemplate.entity);
        }
    };
    ActionListener buttonClick = e -> {
        if (blank(hostField.getText())) {
            JOptionPane.showMessageDialog(null, "host is null .", "error", JOptionPane.ERROR_MESSAGE);
            return ;
        }
        if (blank(userField.getText())) {
            JOptionPane.showMessageDialog(null, "user is null .", "error", JOptionPane.ERROR_MESSAGE);
            return ;
        }
        if (blank(pwdField.getText())) {
            JOptionPane.showMessageDialog(null, "pwd is null .", "error", JOptionPane.ERROR_MESSAGE);
            return ;
        }
        if (blank(dbField.getText())) {
            JOptionPane.showMessageDialog(null, "db is null .", "error", JOptionPane.ERROR_MESSAGE);
            return ;
        }
        if (blank(tableField.getText())) {
            JOptionPane.showMessageDialog(null, "table is null .", "error", JOptionPane.ERROR_MESSAGE);
            return ;
        }
        if (!entityCheckBox.isSelected() && !entityCheckBox.isSelected()) {
            JOptionPane.showMessageDialog(null, "must be select model .", "error", JOptionPane.ERROR_MESSAGE);
            return ;
        }
        DataMap dataMap = DataMap.getInstance();

        dataMap.setHost(hostField.getText());
        dataMap.setUser(userField.getText());
        dataMap.setPwd(pwdField.getText());
        dataMap.setDb(dbField.getText());
        dataMap.setTable(tableField.getText());
        dataMap.setOutput(jFileChooser.getText());

        if(entityCheckBox.isSelected()) {
            Map m = Optional.ofNullable(dataMap.getModelType()).orElseGet(HashMap::new);
            m.put("entity",DataMapTemplate.entity );
            dataMap.setModelType(m);
        }

        if(daoCheckBox.isSelected()) {
            Map m = Optional.ofNullable(dataMap.getModelType()).orElseGet(HashMap::new);
            m.put("dao",DataMapTemplate.dao );
            dataMap.setModelType(m);
        }
    };

    private JPanel getBaseArea() {
        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(8,2));
        panel.setPreferredSize(new Dimension(50, 50));

        JLabel userLabel0 = new JLabel("driver:");
        panel.add(userLabel0);
        JRadioButton jRadioButton = new JRadioButton("mysql 5.6+");
        jRadioButton.setBounds(0,0,1,1);
        jRadioButton.setSelected(true);
        jRadioButton.setEnabled(false);
        panel.add(jRadioButton);

        JLabel userLabel1 = new JLabel("host:");
        panel.add(userLabel1);
        this.hostField = new JTextField();
        panel.add(hostField);

        JLabel userLabel2 = new JLabel("user:");
        panel.add(userLabel2);
        this.userField = new JTextField();
        panel.add(userField);

        JLabel userLabel3 = new JLabel("pwd:");
        panel.add(userLabel3);
        this.pwdField = new JTextField();
        panel.add(pwdField);

        JLabel userLabel4 = new JLabel("db:");
        panel.add(userLabel4);
        this.dbField = new JTextField();
        panel.add(dbField);

        JLabel userLabel5 = new JLabel("table:");
        panel.add(userLabel5);

        this.tableField = new JTextField();
        panel.add(tableField);

        JLabel userLabel6 = new JLabel("model:");
        panel.add(userLabel6);

        panel.add(getCheckboxArea());

        JLabel userLabel7 = new JLabel("output:");
        panel.add(userLabel7);

        this.jFileChooser = new JTextField();
        jFileChooser.setEditable(false);
        panel.add(jFileChooser);

        panel.setPreferredSize(new Dimension(PANEL_INNER_WIDTH, PANEL_INNER_HEIGHT));

        return getMarginPanel(panel,PANEL_CONTEXT_WIDTH,PANEL_CONTEXT_HEIGHT);
    }

    public JPanel getCheckboxArea() {
        JPanel panel = new JPanel() ;

        panel.setLayout(new GridLayout(1,2));

        this.entityCheckBox = new JCheckBox("entity");
        entityCheckBox.setSelected(true);
        panel.add(entityCheckBox);

        this.daoCheckBox = new JCheckBox("dao");
        daoCheckBox.setSelected(true);
        panel.add(daoCheckBox);

        return panel;
    }

    public JPanel getTemplateArea() {
        this.templatePanel = new JPanel();

        templatePanel.setLayout(new FlowLayout());

        ListModel jListModel =  new DefaultComboBoxModel(new String[] { "dao", "entity" });
        this.modelTypeList = new JList();
        modelTypeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelTypeList.setModel(jListModel);
        modelTypeList.setBorder(BorderFactory.createEtchedBorder());
        modelTypeList.setPreferredSize(new Dimension(TEMPLATE_LEFT_WIDTH, TEMPLATE_HEIGHT));


        templatePanel.add(modelTypeList);

        this.jTextArea = new JTextArea();
        JScrollPane scroll = new JScrollPane(jTextArea);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setAutoscrolls(true);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setPreferredSize(new Dimension(TEMPLATE_RIGHT_WIDTH, TEMPLATE_HEIGHT));

        templatePanel.add(scroll);

        return templatePanel;

    }

    public JPanel getTemplateLinkArea() {
        JPanel panel = new JPanel();
        this.expandLink = new JLabel("-------- beetl template settings --------");
        expandLink.setCursor(new Cursor(Cursor.HAND_CURSOR));
        expandLink.setForeground(Color.BLUE);
        panel.add(expandLink);

        return panel;

    }

    public JPanel getSubmitButtonArea() {
        JPanel panel = new JPanel();
        this.submitButton = new JButton("general to code");
        panel.add(submitButton);
        return panel ;
    }

    private static boolean blank(String str) {
        if (null == str) {
            return true;
        }
        if ("".equals(str.trim())) {
            return true;
        }
        return false ;
    }

    public JPanel getMarginPanel(JPanel panel, int width, int height) {
        JPanel panelMargin = new JPanel();

        JPanel panelPadding = new JPanel();
        panelPadding.setBorder(BorderFactory.createEtchedBorder());
        panelPadding.setPreferredSize(new Dimension(width, height));

        panelPadding.add(panel);

        panelMargin.add(panelPadding);

        return panelMargin;
    }
}
