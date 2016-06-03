package String;
/**
 * 
 * @author LIn
 * 对字符串的操作
 */
public class StringOperation {
	/**
	 * 问题描述：把一个句子中的单词反转，如"how are you"
	 *        变为"you are how"
	 * 解决方案：1.整体反转;2.每个单词反转
	 * @param s
	 * @return
	 */
	public static String swapWord(String s){
		char[] chars = s.toCharArray();
		//对整个字符串进行字符反转操作
		swap(chars, 0, chars.length-1);
		int begin = 0;
		for(int i = 1; i < chars.length; i++){
			if(chars[i] == ' '){
				swap(chars, begin, i-1);
				begin = i + 1;
			}
		}
		swap(chars, begin, chars.length-1);
		return new String(chars);
	}
	
	private static void swap(char[] a, int front, int end){
		while(front < end){
			char temp = a[end];
			a[end--] = a[front];
			a[front++] = temp;
		}
	}
	
	/**
	 * 统计一行字符中有多少个单词
	 * @param s
	 * @return
	 */
	public static int wordCount(String s){
		boolean word = false;   //前面的字符是否空格
		int count = 0;
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == ' '){
				word = true;
			}else if(!word){
				word = false;
				count++;
			}
		}
		return count;
	}

}
