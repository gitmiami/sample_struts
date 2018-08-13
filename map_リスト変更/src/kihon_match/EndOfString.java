package kihon_match;

public class EndOfString implements PatternElement {

	@Override
	public boolean matches(String str, int index) {

		return index == str.length();
	}

	@Override
	public int length() {

		return 0;
	}

}
