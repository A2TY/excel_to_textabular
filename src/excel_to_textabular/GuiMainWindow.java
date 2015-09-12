package excel_to_textabular;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class GuiMainWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMainWindow frame = new GuiMainWindow();
					frame.setTitle("Excel to TeX tabular");
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GuiMainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final JTextArea textArea = new JTextArea();
		textArea.setTabSize(2);
		textArea.setBounds(10, 70, 290, 330);
		contentPane.add(textArea);

		final JTextArea textArea_1 = new JTextArea();
		textArea_1.setTabSize(2);
		textArea_1.setBounds(320, 70, 290, 330);
		contentPane.add(textArea_1);

		String[] combodata = { "左詰め", "中央詰め", "右詰め" };
		final JComboBox comboBox = new JComboBox(combodata);
		comboBox.setBounds(10, 7, 117, 28);
		contentPane.add(comboBox);
		comboBox.setPreferredSize(new Dimension(80, 30));

		JButton button = new JButton("\u5909\u63DB");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransformationText text = new TransformationText();
				int index = comboBox.getSelectedIndex();
				text.celStyle(index);
				String transformationText = text.transformationText(textArea
						.getText());
				textArea_1.setText(transformationText);

			}
		});
		button.setBounds(493, 6, 117, 29);
		contentPane.add(button);

		JLabel lblExcel = new JLabel("Excel");
		lblExcel.setBounds(10, 36, 134, 29);
		contentPane.add(lblExcel);

		JLabel lblTexTabular = new JLabel("TeX tabular");
		lblTexTabular.setBounds(320, 36, 134, 29);
		contentPane.add(lblTexTabular);

	}
}
