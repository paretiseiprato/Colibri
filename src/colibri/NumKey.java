package colibri;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class NumKey extends JDialog {

	private final JPanel AbsPane = new JPanel();
	private JTextField txtResult;
	static float Result;
	
	/**
	 * Launch the application.
	 */
	
	
	
	public static void main(String[] args) {
		
		
		try {
			NumKey dialog = new NumKey();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void PopulateText(String Dato){
		
		txtResult.setText(txtResult.getText() + Dato);
		
	}

	/**
	 * Create the dialog.
	 */
	public NumKey() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
			}
		});
		setBounds(100, 100, 384, 475);
		getContentPane().setLayout(null);
		AbsPane.setBounds(0, 0, 434, 461);
		AbsPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(AbsPane);
		AbsPane.setLayout(null);
		
		JButton button_3 = new JButton("3");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				PopulateText("3");
			}
		});
		button_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		button_3.setPreferredSize(new Dimension(80, 80));
		button_3.setBounds(190, 74, 80, 80);
		AbsPane.add(button_3);
		
		JButton button_1 = new JButton("1");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				PopulateText("1");
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		button_1.setPreferredSize(new Dimension(80, 80));
		button_1.setBounds(10, 74, 80, 80);
		AbsPane.add(button_1);
		
		JButton button_2 = new JButton("2");
		
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				PopulateText("2");
			}
		});
		button_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		button_2.setPreferredSize(new Dimension(80, 80));
		button_2.setBounds(100, 74, 80, 80);
		AbsPane.add(button_2);
		{
			JButton okButton = new JButton("OK");
			okButton.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
				
					
					if (!txtResult.getText().isEmpty()) {
						
						Result = Float.valueOf(txtResult.getText()) ;

					}
				
				
				try {
					NumKey.this.setVisible(false);
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				}
			});
			okButton.setForeground(Color.GREEN);
			okButton.setBounds(280, 256, 80, 174);
			AbsPane.add(okButton);
			okButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
			okButton.setPreferredSize(new Dimension(80, 80));
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("EXIT");
			cancelButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					NumKey.this.setVisible(false);
				}
			});
			cancelButton.setForeground(Color.RED);
			cancelButton.setBounds(280, 74, 80, 171);
			AbsPane.add(cancelButton);
			cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
			cancelButton.setPreferredSize(new Dimension(80, 80));
			cancelButton.setActionCommand("Cancel");
		}
		
		JButton button_9 = new JButton("9");
		button_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				PopulateText("9");
			}
		});
		button_9.setFont(new Font("Tahoma", Font.BOLD, 20));
		button_9.setPreferredSize(new Dimension(80, 80));
		button_9.setBounds(190, 256, 80, 80);
		AbsPane.add(button_9);
		
		JButton button_4 = new JButton("4");
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PopulateText("4");
			}
		});
		button_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		button_4.setPreferredSize(new Dimension(80, 80));
		button_4.setBounds(10, 165, 80, 80);
		AbsPane.add(button_4);
		
		JButton button_5 = new JButton("5");
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				PopulateText("5");
			}
		});
		button_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		button_5.setPreferredSize(new Dimension(80, 80));
		button_5.setBounds(100, 165, 80, 80);
		AbsPane.add(button_5);
		
		JButton button_6 = new JButton("6");
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				PopulateText("6");
			}
		});
		button_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		button_6.setPreferredSize(new Dimension(80, 80));
		button_6.setBounds(190, 165, 80, 80);
		AbsPane.add(button_6);
		
		JButton button_7 = new JButton("7");
		button_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				PopulateText("7");
			}
		});
		button_7.setFont(new Font("Tahoma", Font.BOLD, 20));
		button_7.setPreferredSize(new Dimension(80, 80));
		button_7.setBounds(10, 256, 80, 80);
		AbsPane.add(button_7);
		
		JButton button_Punto = new JButton(".");
		button_Punto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				PopulateText(".");
			}
		});
		button_Punto.setFont(new Font("Tahoma", Font.BOLD, 20));
		button_Punto.setPreferredSize(new Dimension(80, 80));
		button_Punto.setBounds(100, 350, 80, 80);
		AbsPane.add(button_Punto);
		
		JButton button_8 = new JButton("8");
		button_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				PopulateText("8");
			}
		});
		button_8.setFont(new Font("Tahoma", Font.BOLD, 20));
		button_8.setPreferredSize(new Dimension(80, 80));
		button_8.setBounds(100, 256, 80, 80);
		AbsPane.add(button_8);
		
		txtResult = new JTextField();
		txtResult.setText("");
		txtResult.setFont(new Font("Tahoma", Font.BOLD, 30));
		txtResult.setBounds(10, 11, 350, 52);
		AbsPane.add(txtResult);
		txtResult.setColumns(10);
		
		JButton btnC = new JButton("C");
		btnC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				txtResult.setText("");
			}
		});
		btnC.setPreferredSize(new Dimension(80, 80));
		btnC.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnC.setBounds(10, 350, 80, 80);
		AbsPane.add(btnC);
		
		JButton button_0 = new JButton("0");
		button_0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				PopulateText("0");
			}
		});
		button_0.setPreferredSize(new Dimension(80, 80));
		button_0.setFont(new Font("Tahoma", Font.BOLD, 20));
		button_0.setBounds(190, 350, 80, 80);
		AbsPane.add(button_0);
	}
}
