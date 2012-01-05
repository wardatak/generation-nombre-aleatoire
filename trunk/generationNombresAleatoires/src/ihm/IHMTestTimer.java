/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * IHMTestTimer.java
 *
 * Created on 4 janv. 2012, 22:05:49
 */
package ihm;

import gestionTraffic.Carrefour;

import java.awt.Color;

/**
 *
 * @author DRANOS
 */
public class IHMTestTimer extends javax.swing.JFrame {

    /** Creates new form IHMTestTimer */
    public IHMTestTimer() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jFeuV1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jFeuH2 = new javax.swing.JPanel();
        jFeuH1 = new javax.swing.JPanel();
        jFeuV2 = new javax.swing.JPanel();
        jLabelV1 = new javax.swing.JLabel();
        jLabelH1 = new javax.swing.JLabel();
        jLabelV2 = new javax.swing.JLabel();
        jLabelH2 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jFeuV1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jFeuV1.setToolTipText("FeuV1");
        jFeuV1.setName("feux"); // NOI18N

        javax.swing.GroupLayout jFeuV1Layout = new javax.swing.GroupLayout(jFeuV1);
        jFeuV1.setLayout(jFeuV1Layout);
        jFeuV1Layout.setHorizontalGroup(
            jFeuV1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jFeuV1Layout.setVerticalGroup(
            jFeuV1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel2.setName("temps"); // NOI18N

        jFeuH2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jFeuH2.setToolTipText("FeuH2");

        javax.swing.GroupLayout jFeuH2Layout = new javax.swing.GroupLayout(jFeuH2);
        jFeuH2.setLayout(jFeuH2Layout);
        jFeuH2Layout.setHorizontalGroup(
            jFeuH2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jFeuH2Layout.setVerticalGroup(
            jFeuH2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jFeuH1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jFeuH1.setToolTipText("FeuH1");

        javax.swing.GroupLayout jFeuH1Layout = new javax.swing.GroupLayout(jFeuH1);
        jFeuH1.setLayout(jFeuH1Layout);
        jFeuH1Layout.setHorizontalGroup(
            jFeuH1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jFeuH1Layout.setVerticalGroup(
            jFeuH1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jFeuV2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jFeuV2.setToolTipText("FeuV2");

        javax.swing.GroupLayout jFeuV2Layout = new javax.swing.GroupLayout(jFeuV2);
        jFeuV2.setLayout(jFeuV2Layout);
        jFeuV2Layout.setHorizontalGroup(
            jFeuV2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jFeuV2Layout.setVerticalGroup(
            jFeuV2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabelV1.setText("0");
        jLabelV1.setToolTipText("H1");

        jLabelH1.setText("0");
        jLabelH1.setToolTipText("V1");

        jLabelV2.setText("0");
        jLabelV2.setToolTipText("H2");

        jLabelH2.setText("0");
        jLabelH2.setToolTipText("V2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jFeuV1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelV1)
                            .addComponent(jFeuH1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelH1)
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelH2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFeuV2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jFeuH2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabelV2))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelH2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jFeuH2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelV2)
                            .addGap(18, 18, 18)
                            .addComponent(jFeuV2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jFeuV1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(74, 74, 74)
                                    .addComponent(jLabel2))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabelV1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jFeuH1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(jLabelH1)))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    /**
     * @param args the command line arguments
     */
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new IHMTestTimer().setVisible(true);
            }
        });
        Carrefour c = new Carrefour();
        c.run();
    }
    public static void changeBackgroundRouge(String nomFeux){
        if(nomFeux.equals("FeuV1")){
            jFeuV1.setBackground(Color.RED);
        }else if(nomFeux.equals("FeuV2")){
            jFeuV2.setBackground(Color.RED);
        }else if(nomFeux.equals("FeuH1")){
            jFeuH1.setBackground(Color.RED);
        }else if(nomFeux.equals("FeuH2")){
            jFeuH2.setBackground(Color.RED);
        }
    }
    
    public static void changeBackgroundVert(String nomFeux){
        if(nomFeux.equals("FeuV1")){
            jFeuV1.setBackground(Color.GREEN);
        }else if(nomFeux.equals("FeuV2")){
            jFeuV2.setBackground(Color.GREEN);
        }else if(nomFeux.equals("FeuH1")){
            jFeuH1.setBackground(Color.GREEN);
        }else if(nomFeux.equals("FeuH2")){
            jFeuH2.setBackground(Color.GREEN);
        }
    }
    public static void changeLabelTraffic(String nomFeux, int valeur){
        if(nomFeux.equals("FeuV1")){
            jLabelV1.setText(""+valeur);
        }else if(nomFeux.equals("FeuV2")){
            jLabelV2.setText(""+valeur);
        }else if(nomFeux.equals("FeuH1")){
            jLabelH1.setText(""+valeur);
        }else if(nomFeux.equals("FeuH2")){
            jLabelH2.setText(""+valeur);
        }
    }
    
    public static void changeLabelTrafficV1(int valeur){
            jLabelV1.setText(""+valeur);
    }
    public static void changeLabelTrafficV2(int valeur){
            jLabelV2.setText(""+valeur);
    }
    public static void changeLabelTrafficH1(int valeur){
            jLabelH1.setText(""+valeur);
    }
    public static void changeLabelTrafficH2(int valeur){
            jLabelH2.setText(""+valeur);
    }
    
    // Variables declaration - do not modify
    private static javax.swing.JPanel jFeuH1;
    private static javax.swing.JPanel jFeuH2;
    private static javax.swing.JPanel jFeuV1;
    private static javax.swing.JPanel jFeuV2;
    private javax.swing.JLabel jLabel2;
    private static javax.swing.JLabel jLabelH1;
    private static javax.swing.JLabel jLabelH2;
    private static javax.swing.JLabel jLabelV1;
    private static javax.swing.JLabel jLabelV2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration
}
