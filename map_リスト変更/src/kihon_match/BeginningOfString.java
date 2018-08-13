package kihon_match;

public class BeginningOfString implements PatternElement {

	@Override
	public boolean matches(String str, int index) {

		return index ==0;
	}

	@Override
	public int length() {

		return 0;
	}

}
