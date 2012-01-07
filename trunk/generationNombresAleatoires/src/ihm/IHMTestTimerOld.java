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
public class IHMTestTimerOld extends javax.swing.JFrame {
	public static IHMTestTimerOld ihm;
    /** Creates new form IHMTestTimer */
    public IHMTestTimerOld() {
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
        feuGauche = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        feuHaut = new javax.swing.JPanel();
        feuBas = new javax.swing.JPanel();
        feuDroite = new javax.swing.JPanel();
        lblVoitureGauche = new javax.swing.JLabel();
        lblVoitureBas = new javax.swing.JLabel();
        lblVoitureDroite = new javax.swing.JLabel();
        lblVoitureHaut = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        feuGauche.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        feuGauche.setToolTipText("FeuV1");
        feuGauche.setName("feux"); // NOI18N

        javax.swing.GroupLayout jFeuV1Layout = new javax.swing.GroupLayout(feuGauche);
        feuGauche.setLayout(jFeuV1Layout);
        jFeuV1Layout.setHorizontalGroup(
            jFeuV1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jFeuV1Layout.setVerticalGroup(
            jFeuV1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel2.setName("temps"); // NOI18N

        feuHaut.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        feuHaut.setToolTipText("FeuH2");

        javax.swing.GroupLayout jFeuH2Layout = new javax.swing.GroupLayout(feuHaut);
        feuHaut.setLayout(jFeuH2Layout);
        jFeuH2Layout.setHorizontalGroup(
            jFeuH2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jFeuH2Layout.setVerticalGroup(
            jFeuH2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        feuBas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        feuBas.setToolTipText("FeuH1");

        javax.swing.GroupLayout jFeuH1Layout = new javax.swing.GroupLayout(feuBas);
        feuBas.setLayout(jFeuH1Layout);
        jFeuH1Layout.setHorizontalGroup(
            jFeuH1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jFeuH1Layout.setVerticalGroup(
            jFeuH1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        feuDroite.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        feuDroite.setToolTipText("FeuV2");

        javax.swing.GroupLayout jFeuV2Layout = new javax.swing.GroupLayout(feuDroite);
        feuDroite.setLayout(jFeuV2Layout);
        jFeuV2Layout.setHorizontalGroup(
            jFeuV2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jFeuV2Layout.setVerticalGroup(
            jFeuV2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        lblVoitureGauche.setText("0");
        lblVoitureGauche.setToolTipText("H1");

        lblVoitureBas.setText("0");
        lblVoitureBas.setToolTipText("V1");

        lblVoitureDroite.setText("0");
        lblVoitureDroite.setToolTipText("H2");

        lblVoitureHaut.setText("0");
        lblVoitureHaut.setToolTipText("V2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(feuGauche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblVoitureGauche)
                            .addComponent(feuBas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblVoitureBas)
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblVoitureHaut)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(feuDroite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(feuHaut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblVoitureDroite))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblVoitureHaut)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(feuHaut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblVoitureDroite)
                            .addGap(18, 18, 18)
                            .addComponent(feuDroite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(feuGauche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(74, 74, 74)
                                    .addComponent(jLabel2))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(lblVoitureGauche)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(feuBas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(lblVoitureBas)))
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
    	ihm = new IHMTestTimerOld();
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
            	ihm.setVisible(true);
            }
        });
        Carrefour c = new Carrefour(ihm);
        c.start(false);
    }
    public static void changeBackgroundRouge(String nomFeux){
        if(nomFeux.equals("FeuV1")){
            feuGauche.setBackground(Color.RED);
        }else if(nomFeux.equals("FeuV2")){
            feuDroite.setBackground(Color.RED);
        }else if(nomFeux.equals("FeuH1")){
            feuBas.setBackground(Color.RED);
        }else if(nomFeux.equals("FeuH2")){
            feuHaut.setBackground(Color.RED);
        }
    }
    
    public static void changeBackgroundVert(String nomFeux){
        if(nomFeux.equals("FeuV1")){
            feuGauche.setBackground(Color.GREEN);
        }else if(nomFeux.equals("FeuV2")){
            feuDroite.setBackground(Color.GREEN);
        }else if(nomFeux.equals("FeuH1")){
            feuBas.setBackground(Color.GREEN);
        }else if(nomFeux.equals("FeuH2")){
            feuHaut.setBackground(Color.GREEN);
        }
    }
    public static void changeLabelTraffic(String nomFeux, int valeur){
        if(nomFeux.equals("FeuV1")){
            lblVoitureGauche.setText(""+valeur);
        }else if(nomFeux.equals("FeuV2")){
            lblVoitureDroite.setText(""+valeur);
        }else if(nomFeux.equals("FeuH1")){
            lblVoitureBas.setText(""+valeur);
        }else if(nomFeux.equals("FeuH2")){
            lblVoitureHaut.setText(""+valeur);
        }
    }
    
    public static void changeLabelTrafficV1(int valeur){
            lblVoitureGauche.setText(""+valeur);
            lblVoitureGauche.repaint();
    }
    public static void changeLabelTrafficV2(int valeur){
            lblVoitureDroite.setText(""+valeur);
            lblVoitureDroite.repaint();
    }
    public static void changeLabelTrafficH1(int valeur){
            lblVoitureBas.setText(""+valeur);
            lblVoitureBas.repaint();
    }
    public static void changeLabelTrafficH2(int valeur){
            lblVoitureHaut.setText(""+valeur);
            lblVoitureHaut.repaint();
    }
    
    // Variables declaration - do not modify
    private static javax.swing.JPanel feuBas;
    private static javax.swing.JPanel feuHaut;
    private static javax.swing.JPanel feuGauche;
    private static javax.swing.JPanel feuDroite;
    private javax.swing.JLabel jLabel2;
    private static javax.swing.JLabel lblVoitureBas;
    private static javax.swing.JLabel lblVoitureHaut;
    private static javax.swing.JLabel lblVoitureGauche;
    private static javax.swing.JLabel lblVoitureDroite;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration
}
