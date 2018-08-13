package kihon_match;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Pattern {

	private List<PatternElement> expr;

	public Pattern(String pattern){
		expr = compile(pattern);
	}

	public boolean matches (String str){

		//str•ªŒJ‚è•Ô‚·
		for(int i=0; i<str.length(); i++){
				if(matches(str,i)){
					return true;
				}
		}
		return false;
	}

	public boolean matches (String str, int index){

		//node•ªŒJ‚è•Ô‚·
		for(PatternElement node : expr){
			if(!node.matches(str,index)){
				return false;
			}

			System.out.print(node.length());

			index +=node.length();
		}
		return true;
	}

	private List<PatternElement> compile(String pattern) {

		List<PatternElement> list =  new ArrayList<PatternElement>();

			for(int i=0; i<pattern.length(); i++){
				char c= pattern.charAt(i);
				PatternElement node = null;

				if( c== '.'){
					node = new AnyChar();
				}else if(c=='^'){
					node = new BeginningOfString();
				}else if(c=='$'){
					node = new EndOfString();
				}else{
					node = new OneChar(c);
				}
				list.add(node);
			}
			return list;

	}

	public static void main(String[] args) {

		String[] data = {"shtreshore","shtre","shore","hotel"};
		Pattern pattern = new Pattern("ho.e$");

			for(String str : data){

				String result;

				if(pattern.matches(str)){
					result = "matches";
				}else{
					result = "does not  matches";
				}
				System.out.printf("    kekka     %s    %s   %n      ", result, str);
			}

	}

}
