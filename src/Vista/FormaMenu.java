package Vista;

public class FormaMenu extends javax.swing.JFrame {

    public FormaMenu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dspEscritorio = new javax.swing.JDesktopPane();
        mbMenu = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dspEscritorio.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout dspEscritorioLayout = new javax.swing.GroupLayout(dspEscritorio);
        dspEscritorio.setLayout(dspEscritorioLayout);
        dspEscritorioLayout.setHorizontalGroup(
            dspEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 960, Short.MAX_VALUE)
        );
        dspEscritorioLayout.setVerticalGroup(
            dspEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        getContentPane().add(dspEscritorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 540));
        setJMenuBar(mbMenu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JDesktopPane dspEscritorio;
    public javax.swing.JMenuBar mbMenu;
    // End of variables declaration//GEN-END:variables
}
