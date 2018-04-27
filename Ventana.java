import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.JOptionPane;

public class Ventana extends JFrame{

	private JPanel panelForma, panelMembresia;
	private JLabel lNombreUsuario,lTipoMembresia,lMembresia;
	private JButton bGuardar,bGuardarArchivo,bCargarArchivo;
	private JFileChooser fileChooser;
	private JTextField tNombreUsuario,tTipoMembresia;
	//private Membresia[] membresias;


	public Ventana(){
		//listaMiembro= new ListaMiembro();
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Lista de Membresias");
		initComponents();
		setVisible(true);
	}


	public void initComponents(){

		setLayout(new GridLayout(1,2));

		panelForma= new JPanel();
		panelForma.setLayout(new GridLayout(8,1));


		lNombreUsuario= new JLabel("Ingresa nombre del miembro:");
		tNombreUsuario= new JTextField();
		lTipoMembresia= new JLabel("Tipo de membresia");
		tTipoMembresia= new JTextField();

		bGuardar= new JButton("Guardar");
		//bGuardar.addActionListener(new BotonListener());
		bGuardarArchivo= new JButton("Guardar archivo");
		//bGuardarArchivo.addActionListener(new BotonSaveFileListener());
		bCargarArchivo= new JButton("Cargar archivo");
		//bCargarArchivo.addActionListener(new BotonLoadListener());


		panelForma.add(lNombreUsuario);
		panelForma.add(tNombreUsuario);
		panelForma.add(lTipoMembresia);
		panelForma.add(tTipoMembresia);
		panelForma.add(new JLabel());

		panelForma.add(bGuardar);
		panelForma.add(bGuardarArchivo);
		panelForma.add(bCargarArchivo);
		

		panelMembresia=new JPanel();
		lMembresia= new JLabel();
		panelMembresia.add(lMembresia);
		add(panelForma);
		add(panelMembresia);
		//imprimeAgenda();
	}

	/*
	public class BotonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String nombre= tNombre.getText();
			String direccion= tDireccion.getText();
			String telefono= tTelefono.getText();
			Contacto c= new Contacto(nombre,direccion,telefono);
			int pos= Integer.parseInt(tPos.getText());
			agenda.addContacto(c,pos);
			imprimeAgenda();
		}
	}

	public class BotonSaveFileListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			try{
				JOptionPane pane= new JOptionPane();
				String fileName=pane.showInputDialog("¿Cuál es el nombre del archivo?");
				FileOutputStream fout = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fout);
				oos.writeObject(agenda);
				oos.close();				
			}catch(FileNotFoundException ex){
				ex.printStackTrace();
			}catch(IOException ex){
				ex.printStackTrace();
			}


		}
	}

	public class BotonLoadListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			fileChooser= new JFileChooser();
			fileChooser.showOpenDialog(null);
			try{
				File selectedFile = fileChooser.getSelectedFile();
				FileInputStream fin = new FileInputStream(selectedFile);
				ObjectInputStream ois = new ObjectInputStream(fin);
				agenda= (Agenda)ois.readObject();
				imprimeAgenda();
			}catch(FileNotFoundException ex){
				System.out.println("Aun no hay archivo");
			}catch(IOException ex){
				ex.printStackTrace();
			}catch(ClassNotFoundException ex){
				ex.printStackTrace();
			}			
		}
	}

	public void imprimeAgenda(){
		String agendaString="<html>";
		for(int i=0;i<agenda.getContactos().length;i++){
			try{
				agendaString= agendaString+i+".- "+
				agenda.getContactos()[i].getNombre()+" "
				+agenda.getContactos()[i].getTelefono()+"<br/>";
			}catch(NullPointerException e){
				agendaString=agendaString+i+".- Vacío <br/>";
			}
		}
		agendaString=agendaString+"</html>";
		lAgenda.setText(agendaString);
	}
	*/



}















