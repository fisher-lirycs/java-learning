package chapter.o3;

/*
 8、密封类

*/

public class MySample08 {
	public static void main(String[] args) {
//		除非一个类声明为 final,    否则任何人都可以派生这个类的子类。如果想对它有更多控制权呢?
//		Java15中作为一个预览特性增加了密封类，并在Java17 中最终确定了这个特性。
//		可以如下将 JSONValue 类声明为密封类：
//		abstract sealed class JSONValue permits JSONArray,JSONNumber,JSONString,JSONBoolean,JSONObject,JSONNult {}
		
//		如果试图定义一个未经允许的子类，那么这将是一个错误：
//		public class JSONComment extends JSONValue{...}
		
//		一个密封类允许的子类必须是可访问的。
//		它们不能是嵌套在另一个类中的私有类，也不能是位于另一个包中的包可见的类。
		
//		对于允许的公共子类，规则要更为严格。它们必须与密封类在同一个包中。
//		使用密封类的一个重要原因是编译时检查。
//		考虑JSONValue类的以下这个方法，其中使用了一个带模式匹配的 switch 表达式

//		public String type() {
//			return switch(this) {
//				case JSONArray j -> "array";
//				case JSONNumber j -> "number";
//				case JSONString j -> "string";
//				case JSONBoolean j -> "boolean";
//				case JSONObject j -> "object";
//				case JSONNull j -> "null";
//				//No default needed here
//			};
//		}
		
		
//		在这个层次结构中，JSONValue 允许有3个子类：
//		public abstract sealed class JSONValue permits JSONObject,JSONArray,JSONPrimitive {}
		
//		JSONPrimitive类也是密封的：
//		public abstract sealed class JSONPrimitive extends JSONValue permits JSONString,JSONNumber,JSONBoolean,JSONNull {}
//		密封类的子类必须指定它是sealed、final,还是允许继续派生子类。对于最后一种情况，必须声明为 non-sealed。



	}
}
