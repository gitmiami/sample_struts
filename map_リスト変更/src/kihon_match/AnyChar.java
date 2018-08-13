package kihon_match;

public class AnyChar implements PatternElement {

	@Override
	public boolean matches(String str, int index) {

		return str.length() > index;

	}

	@Override
	public int length() {
		return 1;
	}

}
