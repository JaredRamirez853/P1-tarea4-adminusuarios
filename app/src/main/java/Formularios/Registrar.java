/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Formularios;
import Controlador.controladorRegistro;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author ramir
 */
public class Registrar extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Registrar.class.getName());
    
    private final controladorRegistro controlador;


    /**
     * Creates new form Registrar
     */
    public Registrar() {
        initComponents();
        controlador = new controladorRegistro();

        configurarIconoVentana();
        configurarPlaceholders();
        setLocationRelativeTo(null);
    }
    
       private void configurarIconoVentana() {
        try {
            Image icon = Toolkit.getDefaultToolkit()
                    .getImage(getClass().getResource("/login-usuarios.png"));
            setIconImage(icon);
        } catch (Exception ex) {
            // Si el recurso no existe, se registra en el log pero no se detiene la aplicación.
            logger.log(java.util.logging.Level.WARNING,
                    "No se pudo cargar el icono de la ventana de registro.", ex);
        }
    }
       
     private void configurarPlaceholders() {
        aplicarPlaceholder(txtNombreUsuario, "Ingrese su nombre de usuario aquí");
        aplicarPlaceholder(txtNombre, "Ingrese su nombre");
        aplicarPlaceholder(txtApellido, "Ingrese su apellido");
        aplicarPlaceholder(txtCorreo, "Ingrese su correo electrónico");
        aplicarPlaceholder(txtTelefono, "Ingrese su número de teléfono");

        // Si txtContraseña y txtConfirmarContraseña son JPasswordField:
        if (txtContraseña instanceof JPasswordField contraseñaField) {
            aplicarPlaceholder(contraseñaField, "Ingrese su contraseña aquí");
        } else {
            aplicarPlaceholder(txtContraseña, "Ingrese su contraseña aquí");
        }

        if (txtConfirmarContraseña instanceof JPasswordField confirmarField) {
            aplicarPlaceholder(confirmarField, "Confirme su contraseña aquí");
        } else {
            aplicarPlaceholder(txtConfirmarContraseña, "Confirme su contraseña aquí");
        }
    }
     
    
    private void aplicarPlaceholder(JTextField field, String placeholder) {
        field.setText(placeholder);
        field.setForeground(new Color(150, 150, 150));

        field.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                if (field.getText().equals(placeholder)) {
                    field.setText("");
                    field.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (field.getText().isEmpty()) {
                    field.setText(placeholder);
                    field.setForeground(new Color(150, 150, 150));
                }
            }
        });
    }
    
    private void aplicarPlaceholder(JPasswordField field, String placeholder) {
        field.setEchoChar((char) 0);
        field.setText(placeholder);
        field.setForeground(new Color(150, 150, 150));

        field.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                String pass = new String(field.getPassword());
                if (pass.equals(placeholder)) {
                    field.setText("");
                    field.setEchoChar('•');
                    field.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                String pass = new String(field.getPassword());
                if (pass.isEmpty()) {
                    field.setEchoChar((char) 0);
                    field.setText(placeholder);
                    field.setForeground(new Color(150, 150, 150));
                }
            }
        });
    }

    /**
     * Devuelve el contenido real de un JTextField, omitiendo el texto de placeholder.
     */
    private String obtenerTextoSinPlaceholder(JTextField field, String placeholder) {
        String text = field.getText();
        return text.equals(placeholder) ? "" : text;
    }

    /**
     * Devuelve el contenido real de un JPasswordField, omitiendo el texto de placeholder.
     */
    private String obtenerTextoSinPlaceholder(JPasswordField field, String placeholder) {
        String text = new String(field.getPassword());
        return text.equals(placeholder) ? "" : text;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new javax.swing.JPanel();
        PanelBanner = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        lblNombreUsuario = new javax.swing.JLabel();
        lblContraseña = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        lblApellido = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        lblCorreo = new javax.swing.JLabel();
        lblConfirmarContraseña = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        lblVolver = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JPasswordField();
        txtConfirmarContraseña = new javax.swing.JPasswordField();
        btnRegistrarse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelFondo.setBackground(new java.awt.Color(255, 255, 255));

        PanelBanner.setBackground(new java.awt.Color(251, 54, 64));

        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registrarse");

        javax.swing.GroupLayout PanelBannerLayout = new javax.swing.GroupLayout(PanelBanner);
        PanelBanner.setLayout(PanelBannerLayout);
        PanelBannerLayout.setHorizontalGroup(
            PanelBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelBannerLayout.setVerticalGroup(
            PanelBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBannerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        txtNombreUsuario.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N

        lblNombreUsuario.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        lblNombreUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreUsuario.setText("Nombre de usuario");

        lblContraseña.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        lblContraseña.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblContraseña.setText("Contraseña");

        txtNombre.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N

        lblNombre.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre.setText("Nombre");

        txtApellido.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N

        lblApellido.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        lblApellido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblApellido.setText("Apellido");

        txtCorreo.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N

        lblCorreo.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        lblCorreo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorreo.setText("Correo");

        lblConfirmarContraseña.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        lblConfirmarContraseña.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblConfirmarContraseña.setText("Confirmar Contraseña");

        txtTelefono.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        txtTelefono.addActionListener(this::txtTelefonoActionPerformed);

        lblTelefono.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        lblTelefono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTelefono.setText("Teléfono");

        lblVolver.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        lblVolver.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVolver.setText("Si ya tienes un usuario creado, presiona aquí para volver al menú anterior.");
        lblVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVolverMouseClicked(evt);
            }
        });

        txtContraseña.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        txtContraseña.setText("jPasswordField1");

        txtConfirmarContraseña.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        txtConfirmarContraseña.addActionListener(this::txtConfirmarContraseñaActionPerformed);

        btnRegistrarse.setBackground(new java.awt.Color(234, 231, 231));
        btnRegistrarse.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        btnRegistrarse.setText("Registrar");
        btnRegistrarse.addActionListener(this::btnRegistrarseActionPerformed);

        javax.swing.GroupLayout panelFondoLayout = new javax.swing.GroupLayout(panelFondo);
        panelFondo.setLayout(panelFondoLayout);
        panelFondoLayout.setHorizontalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelBanner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblVolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelFondoLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFondoLayout.createSequentialGroup()
                        .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombreUsuario)
                            .addComponent(lblNombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                            .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtApellido)
                            .addComponent(lblApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE))
                        .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFondoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                                    .addComponent(lblCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(panelFondoLayout.createSequentialGroup()
                                .addGap(174, 174, 174)
                                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblConfirmarContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(panelFondoLayout.createSequentialGroup()
                                        .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addGap(85, 85, 85))
            .addGroup(panelFondoLayout.createSequentialGroup()
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addGap(314, 314, 314)
                        .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                            .addComponent(lblTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addGap(400, 400, 400)
                        .addComponent(btnRegistrarse)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelFondoLayout.createSequentialGroup()
                    .addGap(54, 54, 54)
                    .addComponent(txtConfirmarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(562, Short.MAX_VALUE)))
        );
        panelFondoLayout.setVerticalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondoLayout.createSequentialGroup()
                .addComponent(PanelBanner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelFondoLayout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblConfirmarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegistrarse)
                .addGap(24, 24, 24)
                .addComponent(lblVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFondoLayout.createSequentialGroup()
                    .addContainerGap(348, Short.MAX_VALUE)
                    .addComponent(txtConfirmarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(248, 248, 248)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void lblVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVolverMouseClicked
        Login ventanaLogin = new Login();
        ventanaLogin.setVisible(true);
        ventanaLogin.setLocationRelativeTo(null); // Centrar ventana

        this.dispose(); // Cerrar formulario actual (Registrar)
    }//GEN-LAST:event_lblVolverMouseClicked

    private void txtConfirmarContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConfirmarContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConfirmarContraseñaActionPerformed

    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed
                String nombreUsuario = obtenerTextoSinPlaceholder(txtNombreUsuario, "Ingrese su nombre de usuario aquí");
        String nombre        = obtenerTextoSinPlaceholder(txtNombre, "Ingrese su nombre");
        String apellido      = obtenerTextoSinPlaceholder(txtApellido, "Ingrese su apellido");
        String correo        = obtenerTextoSinPlaceholder(txtCorreo, "Ingrese su correo electrónico");
        String telefono      = obtenerTextoSinPlaceholder(txtTelefono, "Ingrese su número de teléfono");

        String clave;
        String confirmarClave;

        if (txtContraseña instanceof JPasswordField contraseñaField) {
            clave = obtenerTextoSinPlaceholder(contraseñaField, "Ingrese su contraseña aquí");
        } else {
            clave = obtenerTextoSinPlaceholder(txtContraseña, "Ingrese su contraseña aquí");
        }

        if (txtConfirmarContraseña instanceof JPasswordField confirmarField) {
            confirmarClave = obtenerTextoSinPlaceholder(confirmarField, "Confirme su contraseña aquí");
        } else {
            confirmarClave = obtenerTextoSinPlaceholder(txtConfirmarContraseña, "Confirme su contraseña aquí");
        }

        boolean registrado = controlador.registrarUsuario(
                nombre,
                apellido,
                correo,
                telefono,
                nombreUsuario,
                clave,
                confirmarClave
        );

        if (registrado) {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Registro realizado correctamente. Ahora puede iniciar sesión.",
                    "Información",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE
            );

            Login loginView = new Login();
            loginView.setVisible(true);
            loginView.setLocationRelativeTo(null);

            dispose();
        } else {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "No se pudo completar el registro. Verifique los datos ingresados.",
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_btnRegistrarseActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Registrar().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelBanner;
    private javax.swing.JButton btnRegistrarse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblConfirmarContraseña;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblVolver;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JPasswordField txtConfirmarContraseña;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
