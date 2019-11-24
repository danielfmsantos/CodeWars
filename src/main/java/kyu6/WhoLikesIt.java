package kyu6;

/**
 * https://www.codewars.com/kata/5266876b8f4bf2da9b000362/
 * @author Daniel Santos
 *
 */
public class WhoLikesIt {
	
	public static final String LIKES_THIS = "likes this";
	public static final String LIKE_THIS = "like this";
	
	public static void main(String[] args) {
		System.out.println(whoLikesIt());
		System.out.println(whoLikesIt("Peter"));
		System.out.println(whoLikesIt("Jacob", "Alex"));
		System.out.println(whoLikesIt("Max", "John", "Mark"));
		System.out.println(whoLikesIt("Alex", "Jacob", "Mark", "Max"));
		
	}
    public static String whoLikesIt(String... names) {
        if(names == null || names.length <= 0) {
        	return "no one " + LIKES_THIS;
        }
        StringBuilder msg = new StringBuilder();
        switch (names.length) {
		case 1:
			msg.append(names[0] + " " + LIKES_THIS);
			break;
		case 2:
			msg.append(names[0] + " and " + names[1] + " " + LIKE_THIS);
			break;
		case 3:
			msg.append(names[0] + ", " + names[1] + " and " + names[2] 
					+ " " + LIKE_THIS);
			break;
		default:
			msg.append(names[0] + ", " + names[1] + " and " + (names.length - 2) 
					+ " others " + LIKE_THIS);
			break;
		}
        return msg.toString();        
    }
    
    /**
     * Better Solution
     * @param names
     * @return
     */
    public static String whoLikesIt2(String... names) {
        switch (names.length) {
          case 0: return "no one likes this";
          case 1: return String.format("%s likes this", names[0]);
          case 2: return String.format("%s and %s like this", names[0], names[1]);
          case 3: return String.format("%s, %s and %s like this", names[0], names[1], names[2]);
          default: return String.format("%s, %s and %d others like this", names[0], names[1], names.length - 2);
        }
    }
}