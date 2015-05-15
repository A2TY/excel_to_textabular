package excel_to_textabular;

public class TransformationText {

	String getText;
	String trasformationText;
	String tmp;
	int tabCount;
	char celStyle = 'l';

	/*
	 * 何列の表かを調べる
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
	 * セルを何揃えにするかを設定
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
	 * TeX tabular形式に変換
	 */
	public String transformationText(String text) {
		this.tabCount(text);
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for (int i = 0; i <= tabCount; i++) {
			sb.append("|" + celStyle);
		}
		sb.append("|}");
		String tabularStyle = new String(sb);
		tmp = text.replaceAll("\t", " & ");
		tmp = tmp.replaceAll("\n", "\\\\\\\\\n\\\\hline\n");
		trasformationText = "\\begin{center}\n\\begin{tabular}[c]"
				+ tabularStyle + "\n\\hline\n" + tmp
				+ "\\\\\n\\hline\n\\end{tabular}\n\\end{center}";

		return trasformationText;
	}
}
