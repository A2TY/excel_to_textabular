package excel_to_textabular;

public class TransformationText {

	String getText;
	String trasformationText;
	String tmp;
	int tabCount;
	char celStyle = 'l';

	/*
	 * 列数をカウント
	 */
	public void tabCount(String text) {
		char word = 0;
		for (int i = 0; word != '\n'; i++) {
			word = text.charAt(i);
			if (word == '\t') {
				tabCount++;
			}
		}
	}

	/*
	 * セルの書式を設定する
	 */
	public void celStyle(int index) {
		switch (index) {
		case 0:
			celStyle = 'l';
			break;
		case 1:
			celStyle = 'c';
			break;
		case 2:
			celStyle = 'r';
			break;
		}
	}

	/*
	 * TeXのtabular形式で出力
	 */
	public String transformationText(String referenceText, String titleNameText, String text) {
		this.tabCount(text);
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for (int i = 0; i <= tabCount; i++) {
			sb.append("|" + celStyle);
		}
		sb.append("|}");
		String tabularStyle = new String(sb);
		tmp = text.replaceAll("\t", " & ");
		tmp = tmp.replaceAll("\n", "\\\\\\\\\n\t\t\\\\hline\n\t\t");
		trasformationText = "%\\tabref{tbl:"
				+ referenceText
				+ "}\n\\begin{table}[h]\n\t\\caption{"
				+ titleNameText
				+ "}\n\t\\label{tbl:"
				+ referenceText
				+ "}\n\t\\centering\n\t\\begin{tabular}[c]"
				+ tabularStyle
				+ "\n\t\t\\hline\n\t\t"
				+ tmp
				+ "\\\\\n\t\t\\hline\n\t\\end{tabular}\n\\end{table}";

		return trasformationText;
	}
}
