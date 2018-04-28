import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.JOptionPane;

public class Ventana extends JFrame{

	private JPanel panelForma, panelMembresia;
	private JLabel lNombreUsuario,lTipoMembresia,lMembresia,lPosicion;
	private JButton bGuardar,bGuardarArchivo,bCargarArchivo;
	private JFileChooser fileChooser;
	private JTextField tNombreUsuario,tTipoMembresia,tPosicion;
	private Membresia[] membresias;


	public Ventana(){
		membresias = new Membresia[100];
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
		lPosicion= new JLabel("Ingrese la posicion");
		tPosicion= new JTextField();

		bGuardar= new JButton("Guardar");
		bGuardar.addActionListener(new BotonListener());
		bGuardarArchivo= new JButton("Guardar archivo");
		bGuardarArchivo.addActionListener(new BotonSaveFileListener());
		bCargarArchivo= new JButton("Cargar archivo");
		bCargarArchivo.addActionListener(new BotonLoadListener());


		panelForma.add(lNombreUsuario);
		panelForma.add(tNombreUsuario);
		panelForma.add(lTipoMembresia);
		panelForma.add(tTipoMembresia);
		panelForma.add(lPosicion);
		panelForma.add(tPosicion);
		panelForma.add(new JLabel());

		panelForma.add(bGuardar);
		panelForma.add(bGuardarArchivo);
		panelForma.add(bCargarArchivo);
		

		panelMembresia=new JPanel();
		lMembresia= new JLabel();
		panelMembresia.add(lMembresia);
		add(panelForma);
		add(panelMembresia);
		imprimeMembresias();
	}

	public class BotonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String tipoMembresia= tTipoMembresia.getText();
			if(tipoMembresia.equals("B")){
				Membresia m = new MembresiaBlack(tNombreUsuario.getText());
				int pos = Integer.parseInt(tPosicion.getText());
				membresias[pos] = m;
			} else if(tipoMembresia.equals("G")){
				Membresia m = new MembresiaGold(tNombreUsuario.getText());
				int pos = Integer.parseInt(tPosicion.getText());
				membresias[pos] = m;
			}
			imprimeMembresias();
			
		}
	}
	public class BotonSaveFileListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			try{
				JOptionPane pane= new JOptionPane();
				String fileName=pane.showInputDialog("¿Cuál es el nombre del archivo?");
				FileOutputStream fout = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fout);
				oos.writeObject(membresias);
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
				membresias=(Membresia[])ois.readObject();
				imprimeMembresias();
			}catch(FileNotFoundException ex){
				System.out.println("Aun no hay archivo");
			}catch(IOException ex){
				ex.printStackTrace();
			}catch(ClassNotFoundException ex){
				ex.printStackTrace();
			}			
		}
	}
	public void imprimeMembresias(){
		String membresiasString="<html>";
		for(int i=0;i<membresias.length;i++){
			try{
				membresiasString= membresiasString+i+".- "+membresias[i].getNombre()+" "+"<br/>";
			}catch(NullPointerException e){
				membresiasString=membresiasString+i+".- Vacío <br/>";
			}
		}
		membresiasString=membresiasString+"</html>";
		lMembresia.setText(membresiasString);
	}



}
