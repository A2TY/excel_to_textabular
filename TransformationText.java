package excel_to_textabular;

public class TransformationText {

	String getText;
	String trasformationText;
	String tmp;
	int tabCount;
	char celStyle = 'l';

	/*
	 * ‰½—ñ‚Ì•\‚©‚ğ’²‚×‚é
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
	 * ƒZƒ‹‚ğ‰½‘µ‚¦‚É‚·‚é‚©‚ğİ’è
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
	 * TeX tabularŒ`®‚É•ÏŠ·
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
		trasformationText = "\\begin{table}[h]\n\\caption{}\n\\centering\n\\begin{tabular}[c]"
				+ tabularStyle
				+ "\n\\hline\n"
				+ tmp
				+ "\\\\\n\\hline\n\\end{tabular}\n\\end{table}";

		return trasformationText;
	}
}
