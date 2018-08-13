package kihon_match;

public class OneChar implements PatternElement {

	private final char ch;

	OneChar(char ch)
	{
		this.ch = ch;
	}

	@Override
	public boolean matches(String str, int index) {

		return str.length() > index && str.charAt(index)==ch;

	}

	@Override
	public int length() {
		return 1;
	}

}
