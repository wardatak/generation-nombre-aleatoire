/*
 * IHM.java
 *
 * Created on 11 oct. 2011, 00:54:35
 */
package ihm;

import java.awt.Color;
import java.util.ArrayList;

import generateur.Classe;
import generateur.Generateur;
import generateur.GenerateurExponentielle;
import generateur.GenerateurUniforme;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import testeur.TestKhiDeux;

/**
 *
 * @author K�vin
 */
public class IHM extends javax.swing.JFrame {

	XYSeriesCollection dataset = new XYSeriesCollection();
	JFreeChart chart;
	
	Color rouge = new Color(255, 0, 0);
	Color vert = new Color(0, 255, 0);
	Color rougeF = new Color(153, 0, 0);
	Color vertF = new Color(0, 51, 0);
	
    /** Creates new form IHM */
    public IHM() {
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
    	
    	// Genere le graphique
    	chart = ChartFactory.createXYLineChart(
    		"GRAPHIQUE", 	// Titre
    		"Classes", 	// Nom de l'axe X
    		"Echantillon", 		// Nom de l'axe Y
    		dataset,  		// Dataset
    		PlotOrientation.VERTICAL, // Orientation
    		true, // Affichage de la legende
    		true, // Utilisation du tooltip
    		false // pas de generation d'URL
    	);

        panelGraphique = new ChartPanel(chart);
        boutonUniforme = new javax.swing.JButton();
        textFieldEchantillon = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        boutonNormale = new javax.swing.JButton();
        boutonExponentielle = new javax.swing.JButton();
        boutonPoisson = new javax.swing.JButton();
        boutonWeibull = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        panelRouge = new javax.swing.JPanel();
        panelVert = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        boutonGraph = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("G�neration de nombres al�atoires");

        panelGraphique.setBackground(new java.awt.Color(255, 255, 255));
        panelGraphique.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panelGraphiqueLayout = new javax.swing.GroupLayout(panelGraphique);
        panelGraphique.setLayout(panelGraphiqueLayout);
        panelGraphiqueLayout.setHorizontalGroup(
            panelGraphiqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 484, Short.MAX_VALUE)
        );
        panelGraphiqueLayout.setVerticalGroup(
            panelGraphiqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 434, Short.MAX_VALUE)
        );

        boutonUniforme.setText("Loi Uniforme");
        boutonUniforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonUniformeActionPerformed(evt);
            }
        });
        
        textFieldEchantillon.setText("100");

        jLabel1.setText("Taille de l'�chantillon � g�n�rer:");

        boutonNormale.setText("Loi Normale");
        boutonNormale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonNormaleActionPerformed(evt);
            }
        });

        boutonExponentielle.setText("Loi Exponentielle");
        boutonExponentielle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonExponentielleActionPerformed(evt);
            }
        });

        boutonPoisson.setText("Loi de Poisson");
        boutonPoisson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonPoissonActionPerformed(evt);
            }
        });

        boutonWeibull.setText("Loi de Weibull");
        boutonWeibull.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonWeibullActionPerformed(evt);
            }
        });

        jToolBar1.setRollover(true);

        panelRouge.setBackground(new java.awt.Color(153, 0, 0));
        panelRouge.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelRouge.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout panelRougeLayout = new javax.swing.GroupLayout(panelRouge);
        panelRouge.setLayout(panelRougeLayout);
        panelRougeLayout.setHorizontalGroup(
            panelRougeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );
        panelRougeLayout.setVerticalGroup(
            panelRougeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        panelVert.setBackground(new java.awt.Color(0, 51, 0));
        panelVert.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelVert.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout panelVertLayout = new javax.swing.GroupLayout(panelVert);
        panelVert.setLayout(panelVertLayout);
        panelVertLayout.setHorizontalGroup(
            panelVertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );
        panelVertLayout.setVerticalGroup(
            panelVertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        jLabel2.setText("Verification du test du Khi� :");
        
        boutonGraph.setText("Nettoyer graphique");
        boutonGraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonGraphActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(boutonUniforme, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boutonNormale, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boutonWeibull, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boutonPoisson, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boutonExponentielle, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelVert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelRouge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boutonGraph)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelGraphique, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textFieldEchantillon, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textFieldEchantillon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(boutonUniforme)
                                .addGap(18, 18, 18)
                                .addComponent(boutonNormale)
                                .addGap(18, 18, 18)
                                .addComponent(boutonExponentielle)
                                .addGap(18, 18, 18)
                                .addComponent(boutonPoisson)
                                .addGap(18, 18, 18)
                                .addComponent(boutonWeibull))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(panelRouge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(panelVert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(boutonGraph))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(148, 148, 148))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelGraphique, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        pack();
    }// </editor-fold>

    private void boutonUniformeActionPerformed(java.awt.event.ActionEvent evt) {

    	// generation des valeurs al�atoires
    	GenerateurUniforme generateur = new GenerateurUniforme();
    	generateur.generer(getTextField());
    	
    	// rangement des valeurs al�atoire dans les classes
    	ArrayList<Classe> list = generateur.genererClasses();
    	
    	// test du Khi�
    	TestKhiDeux khi2 = new TestKhiDeux();
    	khi2.test(generateur);
    	boolean test = khi2.test(generateur);
    	if (test == true){
    		this.panelVert.setBackground(vert);
    		this.panelRouge.setBackground(rougeF);
    	}else{
    		this.panelRouge.setBackground(rouge);
    		this.panelVert.setBackground(vertF);
    	}
    	
    	genererGraphique(generateur, generateur.getNom());
    	
    }

    private void boutonNormaleActionPerformed(java.awt.event.ActionEvent evt) {
    // TODO add your handling code here:
    }

    private void boutonExponentielleActionPerformed(java.awt.event.ActionEvent evt) {

    	// generation des valeurs al�atoires
    	GenerateurExponentielle generateur = new GenerateurExponentielle();
    	generateur.generer(getTextField());
    	
    	// rangement des valeurs al�atoire dans les classes
    	ArrayList<Classe> list = generateur.genererClasses();
    	
    	// test du Khi�
    	TestKhiDeux khi2 = new TestKhiDeux();
    	boolean test = khi2.test(generateur);
    	if (test == true){
    		this.panelVert.setBackground(vert);
    		this.panelRouge.setBackground(rougeF);
    	}
    	else{
    		this.panelRouge.setBackground(rouge);
    		this.panelVert.setBackground(vertF);
    	}
    	
    	genererGraphique(generateur, generateur.getNom());
    	
    }

    private void boutonPoissonActionPerformed(java.awt.event.ActionEvent evt) {
    // TODO add your handling code here:
    }

    private void boutonWeibullActionPerformed(java.awt.event.ActionEvent evt) {
    // TODO add your handling code here:
    }
    
    private void boutonGraphActionPerformed(java.awt.event.ActionEvent evt) {
    		
    	JFreeChart chart2 = ChartFactory.createXYLineChart(
		    "GRAPHIQUE", 	  	// Titre
		    "Classes", 			// Nom de l'axe X
    		"Echantillon", 		// Nom de l'axe Y
    		dataset,  			// Dataset
    		PlotOrientation.VERTICAL, // Orientation
    		true, // Affichage de la legende
    		true, // Utilisation du tooltip
    		false // pas de generation d'URL
    		    	);
    	this.chart.fireChartChanged();
    	this.panelGraphique = new ChartPanel(chart);
    	this.panelGraphique.repaint();
    }

    private void genererGraphique(Generateur generateur, String name){
    	XYSeries series = new XYSeries("XY Chart");
    	series.add(0, 0);
    	double valeur = 0;
    	ArrayList<Classe> list = generateur.getListeClasses();
    	for (int i=1; i<list.size()+1; i++){
    		valeur = list.get(i-1).getEffectifReel();
    		series.add(i,(double) valeur);
    		
    	}
    	
    	// Ajoute la s�rie au dataset
    	dataset.addSeries(series);
    	
    	
    	// Genere le graphique
    	chart = ChartFactory.createXYLineChart(
    		name, 	  		// Titre
    		"Classes", 	// Nom de l'axe X
    		"Echantillon", 		// Nom de l'axe Y
    		dataset,  		// Dataset
    		PlotOrientation.VERTICAL, // Orientation
    		true, // Affichage de la legende
    		true, // Utilisation du tooltip
    		false // pas de generation d'URL
    	);
    	
    	this.panelGraphique = new ChartPanel(chart);
    	
    }

    
    private int getTextField(){
    	long valeur = Long.parseLong(textFieldEchantillon.getText());
    	if (valeur < 100)
    		valeur = 100;
    	if (valeur > 1000000)
    		valeur = 1000000;
    	this.textFieldEchantillon.setText(String.valueOf(valeur));
    	System.out.println("VALEUR >>>>>>>>>"+(int)valeur);
    	return (int)valeur;
    }
    
    
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
            java.util.logging.Logger.getLogger(IHM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IHM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IHM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IHM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new IHM().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify
    private javax.swing.JButton boutonExponentielle;
    private javax.swing.JButton boutonGraph;
    private javax.swing.JButton boutonNormale;
    private javax.swing.JButton boutonPoisson;
    private javax.swing.JButton boutonUniforme;
    private javax.swing.JButton boutonWeibull;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JToolBar jToolBar1;
    private ChartPanel panelGraphique;
    private javax.swing.JPanel panelRouge;
    private javax.swing.JPanel panelVert;
    private javax.swing.JTextField textFieldEchantillon;
    // End of variables declaration
}
