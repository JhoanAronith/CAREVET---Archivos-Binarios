package Vista;

public class FormaLogin extends javax.swing.JFrame {

    public FormaLogin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtRegistrarUser = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtRegistrarPassword = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtUser = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnIngresar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnMostrar = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 183, 183));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CAREVET");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 300, 60));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("VETERINARIA");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 300, 30));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("_______________________________________");
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 220, -1));

        txtRegistrarUser.setBackground(new java.awt.Color(0, 183, 183));
        txtRegistrarUser.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtRegistrarUser.setForeground(new java.awt.Color(0, 0, 0));
        txtRegistrarUser.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 183, 183), 1, true));
        jPanel1.add(txtRegistrarUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 220, 40));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Contraseña");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        txtRegistrarPassword.setBackground(new java.awt.Color(0, 183, 183));
        txtRegistrarPassword.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtRegistrarPassword.setForeground(new java.awt.Color(0, 0, 0));
        txtRegistrarPassword.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 183, 183), 1, true));
        jPanel1.add(txtRegistrarPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 220, 40));

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("_______________________________________");
        jLabel8.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 220, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Usuario");
        jLabel9.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        btnRegistrar.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(0, 183, 183));
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.setBorder(null);
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 160, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 400));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUser.setBackground(new java.awt.Color(255, 255, 255));
        txtUser.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtUser.setForeground(new java.awt.Color(0, 0, 0));
        txtUser.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 183, 183), 1, true));
        jPanel2.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 200, 40));

        txtPassword.setBackground(new java.awt.Color(255, 255, 255));
        txtPassword.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(0, 0, 0));
        txtPassword.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 183, 183), 1, true));
        jPanel2.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 200, 40));

        btnIngresar.setBackground(new java.awt.Color(0, 183, 183));
        btnIngresar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setText("INGRESAR");
        btnIngresar.setBorder(null);
        jPanel2.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 160, 40));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Contraseña");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Usuario");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        btnMostrar.setBackground(new java.awt.Color(255, 255, 255));
        btnMostrar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnMostrar.setForeground(new java.awt.Color(0, 183, 183));
        btnMostrar.setText("Mostrar contraseña");
        jPanel2.add(btnMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 183, 183));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("INICIAR SESIÓN");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 150, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 300, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnIngresar;
    public javax.swing.JCheckBox btnMostrar;
    public javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JPasswordField txtPassword;
    public javax.swing.JTextField txtRegistrarPassword;
    public javax.swing.JTextField txtRegistrarUser;
    public javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
