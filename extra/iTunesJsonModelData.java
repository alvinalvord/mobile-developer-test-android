import java.util.*;

public class iTunesJsonModelData {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		String in = sc.nextLine ();
		
		String[] in_arr = in.split (",\\s*");
		
		StringBuilder sb = new StringBuilder ();
		
		for (String s: in_arr) {
			String[] entry = s.split (":");
			
			sb.append ("@SerializedName(").append (entry[0]).append (")\n");
			sb.append ("private ");
			
			if (entry[1].matches ("[0-9]+")) {
				sb.append ("Integer");
			} else if (entry[1].matches ("[0-9]+\\.[0-9]+")) {
				sb.append ("Double");
			} else if (entry[1].contains ("\"")) {
				sb.append ("String");
			} else if (entry[1].matches ("true|false")) {
				sb.append ("Boolean");
			}
			
			sb.append (" ").append (entry[0].replaceAll ("\"", "")).append (";\n");
			
		}
		
		System.out.println (sb.toString ());
	}
	
}