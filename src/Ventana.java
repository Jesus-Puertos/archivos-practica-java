
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.io.FilenameFilter;

public class Ventana extends JFrame {
    private JList<String> fileList;
    private JTextArea editorTexto;

    public Ventana() {
        //Propiedades de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Editor de TXT");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(600, 400);
        setLayout(new BorderLayout());
        setVisible(true);

        //Componente NORTE barra de menu
        JMenuBar menuBar = new JMenuBar();
        //Primer menu ("Arhivo"), si se quieren hacer mas se tiene que hacer de esta forma
        //Paso 1
        JMenu menuArchivo = new JMenu("Archivo");
        //Agregando los items ("abrir y guardar"), puedes agregar los que necesites
        //Paso 2
        menuArchivo.add(new JMenuItem("Abrir"));
        menuArchivo.add(new JMenuItem("Guardar"));
        //Agregando el menuArchivo que hicimos al menuBar
        //Paso 3
        menuBar.add(menuArchivo);

        //Haciendo otro menu ("EDICION")
        //Paso 1
        JMenu menuEdicion = new JMenu("Edicion");
        //Paso 2
        menuEdicion.add(new JMenuItem("Copiar"));
        menuEdicion.add(new JMenuItem("Pegar"));
        //Paso 3
        menuBar.add(menuEdicion);

        //Menu Ayuda
        JMenu menuAyuda = new JMenu("Ayuda");
        menuAyuda.add(new JMenuItem("Acerca De..."));
        menuBar.add(menuAyuda);


        //Componente SUR
        //Crear texto de credistos
        JLabel creditos = new JLabel("Creado por Jesus Alberto Rodriguez Puertos | Todos los derechos reservados");
        //Coloar texto a la derecha
        creditos.setHorizontalAlignment(SwingConstants.RIGHT);
        creditos.setBorder(new EmptyBorder(10, 10, 10, 12));

        //Componente OESTE
        JPanel panelOeste = new JPanel();
        //Acomodando panelOeste
        panelOeste.setLayout(new BoxLayout(panelOeste, BoxLayout.Y_AXIS));
        //Creando texto Lista de archivos y dandole margen
        JLabel textoOeste = new JLabel("Lista de Archivos");
        textoOeste.setBorder(new EmptyBorder(15, 15, 15, 15));
        textoOeste.setFont(new Font("Jetbrains Mono", Font.BOLD, 20 ));
        //Agregando el texto al panel
        panelOeste.add(textoOeste);

        //Buscar la carpeta donde estan los archivos que se necesiten
            //La URL se cambia por el lugar donde este la carpeta en el explorador
        String folderPath = "C:\\Users\\226w0\\archivosTxtTAP";
        File folder = new File(folderPath);
        if(folder.exists() && folder.isDirectory()){
            String [] txtFiles = folder.list(
                    new FilenameFilter() {
                        @Override
                        public boolean accept(File dir, String name) {
                            return name.toLowerCase().endsWith(".txt");
                        }
                    });
            fileList = new JList<>(txtFiles);
            fileList.setBorder(new EmptyBorder(15,15,15,15));

        }else{
            fileList = new JList<>(new String[]{});
        }
        //Haciendo un panelScroll para arrojar ahi la lista y poder usarlo sin problemas si son muhcos archivos
        JScrollPane scrollPane =  new JScrollPane(fileList);
        scrollPane.setPreferredSize(new Dimension(150,getHeight()));
        fileList.setFont(new Font("Jetbrains Mono", Font.BOLD, 18 ));
        //Agregar el scrolPanel al panelOeste
        panelOeste.add(scrollPane);

        //componente CENTRO
        //Creando el JtextArea
        editorTexto =  new JTextArea("Escribe aqui...");
        editorTexto.setFont(new Font("Jetbrains Mono", Font.BOLD, 18 ));
        JScrollPane scrollCentro = new JScrollPane(editorTexto);


        JButton bC = new JButton("Boton CENTRO");

        //Agregar los componente a la ventana
        add(menuBar, BorderLayout.NORTH);
        add(creditos, BorderLayout.SOUTH);
        add(panelOeste, BorderLayout.WEST);
        add(scrollCentro, BorderLayout.CENTER);

    }
}
