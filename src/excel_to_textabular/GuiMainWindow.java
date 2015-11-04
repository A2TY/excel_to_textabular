package excel_to_textabular;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
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
		// メインフレーム
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// 相互参照ラベル入力エリア
		final JTextArea referenceTextArea = new JTextArea();
		referenceTextArea.setTabSize(2);
		referenceTextArea.setBounds(210, 10, 90, 20);
		contentPane.add(referenceTextArea);

		// 入力エリア
		final JTextArea textArea = new JTextArea();
		textArea.setTabSize(2);
		textArea.setBounds(10, 70, 290, 330);
		contentPane.add(textArea);

		// 出力エリア
		final JTextArea textArea_1 = new JTextArea();
		textArea_1.setTabSize(2);
		textArea_1.setBounds(320, 70, 290, 330);
		contentPane.add(textArea_1);

		// セルの書式を選択
		String[] combodata = { "左詰め", "中央詰め", "右詰め" };
		final JComboBox comboBox = new JComboBox(combodata);
		comboBox.setBounds(10, 7, 117, 28);
		contentPane.add(comboBox);
		comboBox.setPreferredSize(new Dimension(80, 30));

		// 変換ボタンを押した時の動作
		JButton button = new JButton("\u5909\u63DB");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransformationText text = new TransformationText();
				int index = comboBox.getSelectedIndex();
				text.celStyle(index);
				String transformationText = text.transformationText(referenceTextArea.getText(), textArea.getText());
				textArea_1.setText(transformationText);

			}
		});

		// 相互参照ラベル入力エリアラベル
		JLabel referenceLabel = new JLabel("参照ラベル");
		referenceLabel.setBounds(140, 6, 80, 29);
		contentPane.add(referenceLabel);

		// 変換実行ボタン
		button.setBounds(493, 6, 117, 29);
		contentPane.add(button);

		// 出力エリアラベル
		JLabel lblExcel = new JLabel("Excel");
		lblExcel.setBounds(10, 36, 134, 29);
		contentPane.add(lblExcel);

		// 入力エリアラベル
		JLabel lblTexTabular = new JLabel("TeX tabular");
		lblTexTabular.setBounds(320, 36, 134, 29);
		contentPane.add(lblTexTabular);

	}

}